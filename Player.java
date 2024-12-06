
import java.util.ArrayList;

public class Player{
	
	private ArrayList<Items> items = new ArrayList<Items>();
	private int[] posishon = { 0, 0, 0 };
	private int[] posishonOld = { 0, 0, 0 };
	private int health;
	private int max;
	
	public Player( int[] start, int weight, int h ){
		posishon = start;
		max = weight;
		health = h;
	}
	
	public Items drop( String in ) {
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
	
	public void get( Items in ) {
		items.add( in );
	}
	
	public Items search( String in ) {
		Items out = null;
		for ( int i = 0; i < items.size(); i++ ) {
			if ( items.get( i ).returnName().equalsIgnoreCase( in ) ) {
				out = items.get( i );
			}
		}
		if (true) return out;
		else return null;
	}
	
	public String full( int in ){//fix
		String out = null;
		int count = 0;
		for ( int i = 0; i <  items.size(); i++ ) 
			count += items.get( i ).returnWeight();
		if ( count + in > max ) out = "Too heavy by " + ( count + in - max );
		return out;
	}
	
	public void up() { old(); posishon[ 0 ] += 1; }
	public void down() { old(); posishon[ 0 ] -= 1; }
	public void north() { old(); posishon[ 1 ] -= 1; }
	public void south() { old(); posishon[ 1 ] += 1; }
	public void east() { old(); posishon[ 2 ] += 1; }
	public void west() { old(); posishon[ 2 ] -= 1; }
	
	public int[] position() { return posishon; }
	
	public int[] OL() { return posishonOld; }
	
	public String myStuff() {
		int count = 0;
		for ( int i = 0; i <  items.size(); i++ ) 
			count += items.get( i ).returnWeight();
		String out = "Curent health: " + health;
		out += "\nCurent weight: " + count + " out of " + max;
		out += "\nYou have:";
		boolean anything = false;
		for ( int i = 0; i < items.size(); i++ ) {
				out += "\nA " + items.get( i ).returnName() + "  Wg:" +
					items.get( i ).returnWeight();
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
	
	public int damage( int in ){
		health -= in;
		return health;
	}
}