
public class game{
	private int playerMaxWeight = 7;
	private int health = 2;
	private RoomStore[][][] store = new RoomStore[ 1 ][ 3 ][ 3 ];//change
	private int[] gameStart = { 0, 0, 2 }; //starting locashon
	//define one for each room. null There is a path in that dorecshon. 
	//wall if there is a wall. Anything else will be displayed
	String[] roomO1 = { "wall", "wall", "wall", "wall",
		"There is a door that needs to be smashed", "wall" };
	String[] roomO2 = { "wall", "wall", "wall", 
		"There is a door that needs a key", "wall",
		"There is a door that needs to be smashed" };
	String[] roomO3 = { "wall", "wall", "wall", null, "wall", "wall" };
	String[] roomO5 = { "wall", "wall", "There is a door that needs a key", 
		"wall", null, "wall" };
	String[] roomO6 = { "wall", "wall", null, null, "wall", null };
	String[] roomO9 = { "wall", "wall", null, "wall", "wall", "wall" };
	
	private Items sword = new Items( "SWORD", 5, 0, 2 );
	private Items key = new Items( "KEY", "There is a door that needs a key" );
	private Items axe = new Items( "AXE", 3, 4, 6 );
	private Items rock = new Items( "ROCK", 2, 2, 5 );
	private Monster monster = new Monster( "Monster", 5, 1 );
	
	public game(){
		
		//needs room discription and room dereconse from above
	  store[0][0][0] = new RoomStore( "Congrats on compleating the tutorial!" +
			"\nType: Quit to end the game\nThere is a path east", 
			roomO1, new int[] { 0, 0, 0, 0, 4, 0 } );
		store[0][0][1] = new RoomStore( "Smash the door\n" +
			"You cant pick up the axe because you dont have room in your" +
			" inventory\nType: Inventory or Stuff\nType: Drop < item >\n" +
			"Type: Smash door with Axe\nThere is a path south and west", 
			new Items[] { axe }, roomO2, new int[] { 0, 0, 0, 0, 0, 4 } );
		store[0][0][2] = new RoomStore( "Welcome to the tutorial!" +
			"\nType: Get Sword\nType: Go South\nThere is a path south", 
			new Items[] { sword }, roomO3 );
		store[0][1][1] = new RoomStore( "Unlock the door\n" +
			"Type: Open door with Key\nThere is a path north, south and east",
			new Items[] { key }, roomO5 );
		store[0][1][2] = new RoomStore( "You made it to room 2!" +
		    "\nType: Kill Monster with Sword" +
			"\nGo west when the Monster is dead" +
		    "\nThere is a path west, south and north", 
		    new Monster[] { monster }, roomO6 );
		store[0][2][2] = new RoomStore( "You were suppose to go west!\n" +
			"There is a path north", roomO9 );
		
	}

	//do not change
	public RoomStore[][][] getGame() { return store; }
	public int[] start() { return gameStart; }
	public int maxWeight() { return playerMaxWeight; }
	public int startHealth() { return health; }
}