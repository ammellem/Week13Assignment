/*
* defiance the game
* Version 1.0 
* @author Austin Deegan
*/
public class game{
	private int playerMaxWeight = 0;//small 10 medeom 25 hevy 50
	private int health = 1;
	private RoomStore[][][] store = new RoomStore[ 1 ][ 5 ][ 5 ];//change
	private int[] gameStart = { 0, 4, 2 }; //starting locashon
	//define one for each room. null There is a path in that dorecshon. 
	//wall if there is a wall. Anything else will be displayed. null is clear
	String[] r00 = { "wall", "wall", "wall", null, "wall", "wall" };
	String[] r01 = { "wall", "wall", "wall", null, "wall", "wall" };
	String[] r02 = { "wall", "wall", "wall", "Locked Door", "wall", "wall" };
	String[] r03 = { "wall", "wall", "wall", null, null, "wall" };
	String[] r04 = { "wall", "wall", "wall", null, "wall", null };
	String[] r10 = { "wall", "wall", null, null, "wall", "wall" };
	String[] r11 = { "wall", "wall", null, "wall", null, "wall" };
	String[] r12 = { "wall", "wall", "Locked Door", "wall", null, "wall" };
	String[] r13 = { "wall", "wall", null, "wall", "wall", null };
	String[] r14 = { "wall", "wall", null, null, "wall", "wall" };
	String[] r20 = { "wall", "wall", null, null, null, "wall" };
	String[] r21 = { "wall", "wall", "wall", null, null, null };
	String[] r22 = { "wall", "wall", "wall", "wall", null, null };
	String[] r23 = { "wall", "wall", "wall", "wall", null, null };
	String[] r24 = { "wall", "wall", null, "wall", "wall", null };
	String[] r30 = { "wall", "wall", null, null, "wall", "wall" };
	String[] r31 = { "wall", "wall", null, null, null, "wall" };
	String[] r32 = { "wall", "wall", "wall", null, null, null };
	String[] r33 = { "wall", "wall", "wall", "wall", null, null };
	String[] r34 = { "wall", "wall", "wall", null, "wall", null };
	String[] r40 = { "wall", "wall", null, "wall", null, "wall" };
	String[] r41 = { "wall", "wall", null, "wall", "wall", null };
	String[] r42 = { "wall", "wall", null, "wall", "wall", "wall" };
	String[] r43 = { "wall", "wall", "wall", "wall", null, "wall" };
	String[] r44 = { "wall", "wall", null, "wall", "wall", null };
	
		
	//item: name , damage, smash, wg, speshal
	private Items key = new Items( "key", 0, 0, 0, "Locked Door" );

	
	
	public game(){
		
		//needs room discription and room dereconse from above
		// discripshon, items, monsters, out, smash
	   store[0][0][0] = new RoomStore( "You can go south",
		new Items[] { key }, r00 );
	   store[0][0][1] = new RoomStore( "You can go south", r01 );
	   store[0][0][2] = new RoomStore( 
		"You made it to the end congrats!\nquiting", r02 );
	   store[0][0][3] = new RoomStore( "You can go south east", r03 );
	   store[0][0][4] = new RoomStore( "You can go south west", r04 );
	   store[0][1][0] = new RoomStore( "You can go north south", r10 );
	   store[0][1][1] = new RoomStore( "You can go north east", r11 );
	   store[0][1][2] = new RoomStore( "You can go north east west", r12 );
	   store[0][1][3] = new RoomStore( "You can go north west", r13 );
	   store[0][1][4] = new RoomStore( "You can go north south", r14 );
	   store[0][2][0] = new RoomStore( "You can go north south east", r20 );
	   store[0][2][1] = new RoomStore( "You can go south east west", r21 );
	   store[0][2][2] = new RoomStore( "You can go east west", r22 );
	   store[0][2][3] = new RoomStore( "You can go east west", r23 );
	   store[0][2][4] = new RoomStore( "You can go north west", r24 );
	   store[0][3][0] = new RoomStore( "You can go north south", r30 );
	   store[0][3][1] = new RoomStore( "You can go north south east", r31 );
	   store[0][3][2] = new RoomStore( "You can go south east west", r32 );
	   store[0][3][3] = new RoomStore( "You can go east west", r33 );
	   store[0][3][4] = new RoomStore( "You can go south west", r34 );
	   store[0][4][0] = new RoomStore( "You can go north east", r40 );
	   store[0][4][1] = new RoomStore( "You can go north west", r41 );
	   store[0][4][2] = new RoomStore( 
		"Welcome to MAZE!\nGood luck\nYou can go north", r42 );
	   store[0][4][3] = new RoomStore( "You can go east", r43 );
	   store[0][4][4] = new RoomStore( "You can go north west", r44 );
	   
	}

	//do not change
	public RoomStore[][][] getGame() { return store; }
	public int[] start() { return gameStart; }
	public int maxWeight() { return playerMaxWeight; }
	public int startHealth() { return health; }
}