import java.util.ArrayList;

public class RoomStore{
	private String discripshon = "";
	private ArrayList<Items> items = new ArrayList<Items>();
	private String[] monsters = new String[ 10 ];
	private String[] out = new String[ 6 ];
	
	public RoomStore( String in0, Items[] in1, String[] in2, String[] in3 ) {
		discripshon = in0;
		if ( in1 != null )
			for ( int i = 0; i < in1.length; i++ ) items.add( in1[ i ] );
		if ( in2 != null )
			for ( int i = 0; i < in2.length; i++ ) monsters[ i ] = in2[ i ];
		out = in3;
	}

	public String discripshonOut() { return discripshon; }
	public ArrayList<Items> itemsOut() { return items; }
	public String[] monstersOut() { return monsters; }
	public String[] outOut() { return out; }
	
	public void discripshonIn( String in ) { discripshon = in; }
	public void itemsIn( ArrayList<Items> in ) { items = in; }
	public void monstersIn( String[] in ) { monsters = in; }
	public void outIn( String[] in ) { out = in; }
}