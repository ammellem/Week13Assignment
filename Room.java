import java.util.Arrays;

public class Room{
	
	private String discripshon = "";
	private String[] items = new String[ 6 ];
	private String[] monsters = new String[ 6 ];
	private String[] out = new String[ 6 ];
	private String dOut = "";
	
	
	public Room( String in0, String[] in1, String[] in2, String[] in3 ){
		discripshon = in0;
		if ( in1 != null )
			for ( int i = 0; i < in1.length; i++ ) items[ i ] = in1[ i ];
		if ( in2 != null )
			for ( int i = 0; i < in2.length; i++ ) monsters[ i ] = in2[ i ];
		out = in3;
	}

	public String look(){
		dOut = discripshon;
		for ( String i : items ) {
			if ( i != null ) dOut += ( "\nThere is a " + i );
		}
		for ( String i : monsters ) {
			if ( i != null ) dOut += ( "\nThere i a " + i );
		}
		return dOut;
	}

	public String get( String in ) {
		String out = "No " + in + " found";
		for ( int i = 0; i < items.length; i++ ) {
			if ( items[ i ] != null && items[ i ].equals( in ) ) {
				out = items[ i ];
				items[ i ] = null;
			}
		}
		return out;
	}

	public void add( String in ) {
		for ( int i = 0; i < items.length; i++ ) {
			if ( items[ i ] == null ) {
				items[ i ] = in;
				break;
			}
		}
	}


	public String[] upDataM( String[] in ) {
		String[] temp = monsters;
		monsters = in;
		return temp;
	}

	public String[] upDataI( String[] in ) {
		String[] temp = items;
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