
public class game{
	private int playerMaxWeight = 7;
	private int health = 2;
	private RoomStore[][][] store = new RoomStore[ 1 ][ 3 ][ 3 ];//change
	private int[] gameStart = { 0, 0, 2 }; //starting locashon
	//define one for each room. null you can go in that dorecshon. 
	//wall if there is a wall. Anything else will be displayed
	String[] roomO1 = {"wall","wall","wall",null,"There is a big wooden door","wall"};
	String[] roomO2 = {"wall","wall","wall",null,"wall","There is a big wooden door"};
	String[] roomO3 = {"wall","wall","wall",null,"wall","wall"};
	String[] roomO4 = {"wall","wall",null,null,"wall","wall"};
	String[] roomO5 = {"wall","wall",null,null,null,"wall"};
	String[] roomO6 = {"wall","wall",null,null,"wall",null};
	String[] roomO7 = {"wall","wall",null,"wall",null,"wall"};
	String[] roomO8 = {"wall","wall",null,"wall","wall",null};
	String[] roomO9 = {"wall","wall",null,"wall","wall","wall"};
	
	private Items sword = new Items( "SWORD", 5, 0, 2 );
	private Items key = new Items( "KEY", "There is a big wooden door" );
	private Items axe = new Items( "AXE", 3, 4, 4 );
	private Items rock = new Items( "ROCK", 2, 2, 5 );
	private Monster piret = new Monster( "Pirate", 5, 1 );
	
	public game(){
		
		//needs room discription and room dereconse from above
		store[0][0][0] = new RoomStore("room 1\nYou can go south or east", roomO1, new int[] { 0, 0, 0, 0, 4, 0 } );
		store[0][0][1] = new RoomStore("room 2\nYou can go south or west", roomO2, new int[] { 0, 0, 0, 0, 0, 4 } );
		store[0][0][2] = new RoomStore("room 3\nYou can go south", new Items[] { sword, key, rock, axe }, roomO3 );
		store[0][1][0] = new RoomStore("room 4\nYou can go south or north", roomO4 );
		store[0][1][1] = new RoomStore("room 5\nYou can go north, south or east", roomO5 );
		store[0][1][2] = new RoomStore("room 6\nYou can go west, south or north",new Monster[] { piret }, roomO6 );
		store[0][2][0] = new RoomStore("room 7\nYou can go north or east", roomO7 );
		store[0][2][1] = new RoomStore("room 8\nYou can go north or west", roomO8 );
		store[0][2][2] = new RoomStore("room 9\nYou can go north", roomO9 );
		
	}

	public RoomStore[][][] getGame() { return store; }
	
	public int[] start() { return gameStart; }

	public int maxWeight() { return playerMaxWeight; }
	
	public int startHealth() { return health; }
}