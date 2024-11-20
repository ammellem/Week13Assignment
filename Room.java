import java.util.Arrays;
import java.util.ArrayList;

public class Room{
	
	private String discripshon = "";
	private ArrayList<Items> items = new ArrayList<Items>();
	private String[] monsters = new String[ 6 ];
	private String[] out = new String[ 6 ];
	private String dOut = "";
	
	
	public Room(){
		
	}

	public String look(){
		dOut = discripshon;
		for ( int i = 0; i < items.size(); i++ ) {
			 dOut += ( "\nThere is a " + items.get( i ).returnName() );
		}
		for ( String i : monsters ) {
			if ( i != null ) dOut += ( "\nThere i a " + i );
		}
		return dOut;
	}

	public Items get( String in ) {//test
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

	public void add( Items in ) {//test
		items.add( in );
	}


	public String[] upDataM( String[] in ) {
		String[] temp = monsters;
		monsters = in;
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