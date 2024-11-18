

public class Player{
	
	private String[] inventory = new String[ 6 ]; //change to what you want the max to be
	private int count = 0;// change to 0 later
	private int[] posishon = { 0, 0, 0 };
	private int[] posishonOld = { 0, 0, 0 };
	private int health = 2; // change lader
	
	public Player(){
		//inventory[0]="aa";
		//inventory[1]="bb";
		//inventory[2]="cc";
		//inventory[3]="dd";
		//inventory[4]="ee";
		//inventory[5]="ff";
	}
	
	public String drop( String in ) {
		String out = null;
		in = in.trim();
		for ( int i = 0; i < inventory.length; i++ ) {
			if ( inventory[ i ] != null && inventory[ i ].equals( in ) ) {
				count--;
				out = inventory[ i ];
				for (int j = i; j < inventory.length - 1; j++ ) {
					inventory[ j ] = inventory[ j + 1 ];
				}
				inventory[ inventory.length - 1 ] = null;
				break;
			}
		}
		if ( out != null ) return out;
		else return "not in inventory:(";
	}
	
	public void get( String in ) {
		count++;
		inventory[ count ] = in;
	}
	
	public boolean full(){
		return count == inventory.length - 1;
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
		String out = "You have:";
		boolean anything = false;
		for ( String i : inventory ) {
			if ( i != null ) {
				out += "\nA " + i;
				anything = true;
			}
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