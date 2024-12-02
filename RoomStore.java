import java.util.ArrayList;

public class RoomStore{
	private String discripshon = "";
	private ArrayList<Items> items = new ArrayList<Items>();
	private ArrayList<Monster> monsters = new ArrayList<Monster>();
	private String[] out = new String[ 6 ];
	private int[] smash = { 0, 0, 0, 0, 0, 0 };
	
	public RoomStore( String in0, Items[] in1,
		Monster[] in2, String[] in3 ) {
		discripshon = in0;
		for ( int i = 0; i < in1.length; i++ ) items.add( in1[ i ] );
		for ( int i = 0; i < in2.length; i++ ) monsters.add( in2[ i ] );
		out = in3;
	}
	public RoomStore( String in0, Items[] in1, Monster[] in2, 
		String[] in3, int[] in4 ) {
		discripshon = in0;
		for ( int i = 0; i < in1.length; i++ ) items.add( in1[ i ] );
		for ( int i = 0; i < in2.length; i++ ) monsters.add( in2[ i ] );
		out = in3;
		smash = in4;
	}
	public RoomStore( String in0, Items[] in1, String[] in3 ) {
		discripshon = in0;
		for ( int i = 0; i < in1.length; i++ ) items.add( in1[ i ] );
		out = in3;
	}
	public RoomStore( String in0, Items[] in1, String[] in3, int[] in4 ) {
		discripshon = in0;
		for ( int i = 0; i < in1.length; i++ ) items.add( in1[ i ] );
		out = in3;
		smash = in4;
	}
	public RoomStore( String in0, Monster[] in2, String[] in3 ) {
		discripshon = in0;
		for ( int i = 0; i < in2.length; i++ ) monsters.add( in2[ i ] );
		out = in3;
	}
	public RoomStore( String in0, Monster[] in2, String[] in3, int[] in4 ) {
		discripshon = in0;
		for ( int i = 0; i < in2.length; i++ ) monsters.add( in2[ i ] );
		out = in3;
		smash = in4;
	}
	public RoomStore( String in0, String[] in3, int[] in4 ) {
		discripshon = in0;
		out = in3;
		smash = in4;
	}
	public RoomStore( String in0, String[] in3 ) {
		discripshon = in0;
		out = in3;
	}

	public void open( int in ){
		if ( in % 2 == 1 ) in--;
		else in++;
		out[ in ] = null;
	}

	public String discripshonOut() { return discripshon; }
	public ArrayList<Items> itemsOut() { return items; }
	public ArrayList<Monster> monstersOut() { return monsters; }
	public String[] outOut() { return out; }
	public int[] smashOut() { return smash; }
	
	public void discripshonIn( String in ) { discripshon = in; }
	public void itemsIn( ArrayList<Items> in ) { items = in; }
	public void monstersIn( ArrayList<Monster> in ) { monsters = in; }
	public void outIn( String[] in ) { out = in; }
	public void smashIn( int[] in ) { smash = in; }
}