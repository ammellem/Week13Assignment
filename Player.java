
import java.util.ArrayList;

public class Player{
	
	private ArrayList<Items> items = new ArrayList<Items>();
	private int[] posishon = { 0, 0, 0 };
	private int[] posishonOld = { 0, 0, 0 };
	private int health = 2; // change lader
	private int weight = 0;
	private int max = 6; //change
	
	public Player( int[] start ){
		posishon = start;
		
	}
	
	public Items drop( String in ) {//test
		Items out = null;
		for ( int i = 0; i < items.size(); i++ ) {
			if ( items.get( i ).returnName().equalsIgnoreCase( in ) ) {
				out = items.get( i );
				items.remove( i );
			}
		}
		if (true) return out;
		else return null;
	}
	
	public void get( Items in ) {//test
		items.add( in );
	}
	
	public boolean full(){//fix
		return false;
	}
	
	public void up() { old(); posishon[ 0 ] += 1; }
	public void down() { old(); posishon[ 0 ] -= 1; }
	public void north() { old(); posishon[ 1 ] -= 1; }
	public void south() { old(); posishon[ 1 ] += 1; }
	public void east() { old(); posishon[ 2 ] += 1; }
	public void west() { old(); posishon[ 2 ] -= 1; }
	
	public int[] position() { return posishon; }
	
	public int[] OL() { return posishonOld; }
	
	public String myStuff() {//test
		String out = "You have:";
		boolean anything = false;
		for ( int i = 0; i < items.size(); i++ ) {
				out += "\nA " + items.get( i ).returnName();
				anything = true;
		}
		if ( !anything ) out += "\nNothing:(";
		return out;
	}
	
	private void old() { 
		posishonOld[ 0 ] = posishon[ 0 ]; 
		posishonOld[ 1 ] = posishon[ 1 ];
		posishonOld[ 2 ] = posishon[ 2 ];
	}
}