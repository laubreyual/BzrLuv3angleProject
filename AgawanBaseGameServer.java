import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import javax.swing.*;

public class AgawanBaseGameServer implements Runnable, AgawanBaseConstants{

	String playerData;
	int playerCount=0;
    DatagramSocket serverSocket = null;
	AgawanBaseGameState game;
	int gameStage=WAITING_FOR_PLAYERS;
	int numPlayers;
	Thread t = new Thread(this);
	
	//constructor
	public AgawanBaseGameServer(int numPlayers){
		this.numPlayers = numPlayers;
		try {
            serverSocket = new DatagramSocket(PORT);
			serverSocket.setSoTimeout(100);
		} catch (IOException e) {
            System.err.println("Could not listen on port: "+PORT);
            System.exit(-1);
		}catch(Exception e){}
		
		game = new AgawanBaseGameState();
		
		System.out.println("Game created..");
		
		t.start();
	}
	
	public void broadcast(String msg){
		for(Iterator ite=game.getPlayers().keySet().iterator();ite.hasNext();){
			String name=(String)ite.next();
			AgawanBaseNetPlayer player=(AgawanBaseNetPlayer)game.getPlayers().get(name);			
			send(player,msg);	
		}
	}


	public void send(AgawanBaseNetPlayer player, String msg){
		DatagramPacket packet;	
		byte buf[] = msg.getBytes();		
		packet = new DatagramPacket(buf, buf.length, player.getAddress(),player.getPort());
		try{
			serverSocket.send(packet);
		}catch(IOException ioe){
			ioe.printStackTrace();
		}
	}
	
	public void run(){
		while(true){
						
			// Get the data from players
			byte[] buf = new byte[256];
			DatagramPacket packet = new DatagramPacket(buf, buf.length);
			try{
     			serverSocket.receive(packet);
			}catch(Exception ioe){}
			
			//converts byte to string
			playerData=new String(buf);
			
			//remove excess bytes
			playerData = playerData.trim();
		
			// process
			switch(gameStage){
				  case WAITING_FOR_PLAYERS:
						JOptionPane.showMessageDialog(null, "Waiting for players..", "Agawan Base", JOptionPane.INFORMATION_MESSAGE);
						if (playerData.startsWith("CONNECT")){
							String tokens[] = playerData.split(" ");
							AgawanBaseNetPlayer player=new AgawanBaseNetPlayer(tokens[1],packet.getAddress(),packet.getPort());
							System.out.println("Player connected: "+tokens[1]);
							game.update(tokens[1].trim(),player);
							broadcast("CONNECTED "+tokens[1]);
							playerCount++;
							if (playerCount==numPlayers){
								gameStage=GAME_START;
							}
						}
					  break;	
				  case GAME_START:
					  System.out.println("Game State: START");
					  broadcast("START");
					  gameStage=IN_PROGRESS;
					  break;
				  case IN_PROGRESS:
					  //System.out.println("Game State: IN_PROGRESS");
					  
					  if (playerData.startsWith("PLAYER")){
						  //Tokenize:
						  //The format: PLAYER <player name> <x> <y>
						  String[] playerInfo = playerData.split(" ");					  
						  String pname =playerInfo[1];
						  int x = Integer.parseInt(playerInfo[2].trim());
						  int y = Integer.parseInt(playerInfo[3].trim());
						  //Get the player from the game state
						  AgawanBaseNetPlayer player=(AgawanBaseNetPlayer)game.getPlayers().get(pname);					  
						  player.setX(x);
						  player.setY(y);
						  //Update the game state
						  game.update(pname, player);
						  //Send to all the updated game state
						  broadcast(game.toString());
					  }
					  break;
			}				  
		}
	}	
	
}

