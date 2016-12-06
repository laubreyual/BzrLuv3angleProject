import java.net.InetAddress;

public class AgawanBaseNetPlayer {
	
	private InetAddress address;		//network address of the player
	private int port;					//port number
	private String name;				//name of player
	private int x,y;					//position of player

	//constructor
	public AgawanBaseNetPlayer(String name,InetAddress address, int port){
		this.address = address;
		this.port = port;
		this.name = name;
	}

	//getters
	public InetAddress getAddress(){
		return address;
	}

	public int getPort(){
		return port;
	}

	public String getName(){
		return name;
	}
	
	public int getX(){
		return x;
	}

	public int getY(){
		return y;
	}


	//setters
	public void setX(int x){
		this.x=x;
	}

	public void setY(int y){
		this.y=y;		
	}

	//converts to string
	public String toString(){
		String retval="";
		retval+="PLAYER ";
		retval+=name+" ";
		retval+=x+" ";
		retval+=y;
		return retval;
	}	
}
