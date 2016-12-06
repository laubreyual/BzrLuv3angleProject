import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class AgawanBaseGameState{
	//key-value pair of <player name,AgawanBaseNetPlayer>
	private Map players=new HashMap();
	
	public AgawanBaseGameState(){}
	
	public void update(String name, AgawanBaseNetPlayer player){
		players.put(name,player);
	}
	
	public String toString(){
		String retval="";
		for(Iterator ite=players.keySet().iterator();ite.hasNext();){
			String name=(String)ite.next();
			AgawanBaseNetPlayer player=(AgawanBaseNetPlayer)players.get(name);
			retval+=player.toString()+":";
		}
		return retval;
	}
	
	public Map getPlayers(){
		return players;
	}
}
