import java.util.Arrays;
import java.util.ArrayList;

public class Room{
	
	private String discripshon = "";
	private ArrayList<Items> items = new ArrayList<Items>();
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	private String[] out = new String[ 6 ];
	private String dOut = "";
	private int[] smash = new int[ 6 ];
	
	public Room(){
		
	}

	public String look(){
		dOut = discripshon;
		if ( out[ 0 ] != null && !out[ 0 ].equalsIgnoreCase( "wall" ) )
			dOut += "\n" + out[ 0 ] + " above you";
		if ( out[ 1 ] != null && !out[ 1 ].equalsIgnoreCase( "wall" ) )
			dOut += "\n" + out[ 1 ] + " below you";
		if ( out[ 2 ] != null && !out[ 2 ].equalsIgnoreCase( "wall" ) )
			dOut += "\n" + out[ 2 ] + " to the north";
		if ( out[ 3 ] != null && !out[ 3 ].equalsIgnoreCase( "wall" ) )
			dOut += "\n" + out[ 3 ] + " to the south";
		if ( out[ 4 ] != null && !out[ 4 ].equalsIgnoreCase( "wall" ) )
			dOut += "\n" + out[ 4 ] + " to the east";
		if ( out[ 5 ] != null && !out[ 5 ].equalsIgnoreCase( "wall" ) )
			dOut += "\n" + out[ 5 ] + " to the west";

		for ( int i = 0; i < items.size(); i++ ) {
			 dOut += ( "\nThere is a " + items.get( i ).returnName() );
		}
		for ( int i = 0; i < monsters.size(); i++ ) {
			 dOut += ( "\nThere is a " + monsters.get( i ).Name() );
		}
		return dOut;
	}

	public Items get( String in ) {//test
		Items dout = null;
		for ( int i = 0; i < items.size(); i++ ) {
			if ( items.get( i ).returnName().equalsIgnoreCase( in ) ) {
				dout = items.get( i );
				items.remove( i );
			}
		}
		if ( dOut != null ) return dout;
		else return null;
	}

	public void add( Items in ) {//test
		items.add( in );
	}
		
	public int open( String in ) {
		int i = 0;
		for ( ; i < 6; i++ ) if ( out[ i ] != null &&
			out[ i ].equalsIgnoreCase( in ) ) break;
		if ( i != 6 && out[ i ].equalsIgnoreCase( in ) ) {
			out[ i ] = null;
			return i;
		} else return -1;	
	}
	
	public int open( int in ) {
		int i = 0;
		for ( ; i < 6; i++ ) if ( smash[ i ] != 0 && smash[ i ] <= in ) break;
		if ( i != 6 && smash[ i ] <= in ) {
			out[ i ] = null;
			return i;
		} else return -1;	
	}
	
	public int damage() {
		int count = 0;
		for ( int i = 0; i <  monsters.size(); i++ ) 
			count += monsters.get( i ).Damage();
		return count;
	}
	public String kill( String m, int dam ) {
		String back = "";
		Monster back2 = null;
		int health = 0;
		for ( int i = 0; i < monsters.size(); i++ ) {
			if ( monsters.get( i ).Name().equalsIgnoreCase( m ) ) {
				back2 = monsters.get( i );
				monsters.remove( i );
			}
		}
		if ( back2 != null ) {
			health = back2.hit( dam );
			if ( health <= 0 ) back = back2.Name() + " killed";
			else { 
				back = back2.Name() + " takes damage"; 
				monsters.add( back2 );
			}
		}
		else back = "No " + m + " Found";
		
		return back;
	}

	public ArrayList<Monster> upDataM( ArrayList<Monster> in ) {
		ArrayList<Monster> temp = monsters;
		monsters = in;
		return temp;
	}
	
		public int[] upDataS( int[] in ) {
		int[] temp = smash;
		smash = in;
		return temp;
	}

	public ArrayList<Items> upDataI( ArrayList<Items> in ) {
		ArrayList<Items> temp = items;
		items = in;
		return temp;
	}
	
	public String upDataD( String in ) {
		String temp = discripshon;
		discripshon = in;
		return temp;
	}

	public String[] upDataOut( String[] in ) {
		String[] temp = out;
		out = in;
		return temp;
	}

	public String go( int in ) {
		return out[ in ];
	}

}