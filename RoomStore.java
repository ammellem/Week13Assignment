

public class RoomStore{
	private String discripshon = "";
	private String[] items = new String[ 10 ];
	private String[] monsters = new String[ 10 ];
	private String[] out = new String[ 6 ];
	
	public RoomStore( String in0, String[] in1, String[] in2, String[] in3 ) { //make more declaers
		discripshon = in0;
		if ( in1 != null )
			for ( int i = 0; i < in1.length; i++ ) items[ i ] = in1[ i ];
		if ( in2 != null )
			for ( int i = 0; i < in2.length; i++ ) monsters[ i ] = in2[ i ];
		out = in3;
	}

	public String discripshonOut() { return discripshon; }
	public String[] itemsOut() { return items; }
	public String[] monstersOut() { return monsters; }
	public String[] outOut() { return out; }
	
	public void discripshonIn( String in ) { discripshon = in; }
	public void itemsIn( String[] in ) { items = in; }
	public void monstersIn( String[] in ) { monsters = in; }
	public void outIn( String[] in ) { out = in; }
}