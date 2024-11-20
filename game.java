public class game{
	private RoomStore[][][] store = new RoomStore[ 1 ][ 3 ][ 3 ];//change
	private int[] gameStart = { 0, 0, 2 }; //starting locashon
	//define one for each room. null you can go in that dorecshon 
	String[] roomO1 = {"cant","cant","cant",null,null,"cant"};
	String[] roomO2 = {"cant","cant","cant",null,"cant",null};
	String[] roomO3 = {"cant","cant","cant",null,"cant","cant"};
	String[] roomO4 = {"cant","cant",null,null,"cant","cant"};
	String[] roomO5 = {"cant","cant",null,null,null,"cant"};
	String[] roomO6 = {"cant","cant",null,null,"cant",null};
	String[] roomO7 = {"cant","cant",null,"cant",null,"cant"};
	String[] roomO8 = {"cant","cant",null,"cant","cant",null};
	String[] roomO9 = {"cant","cant",null,"cant","cant","cant"};
	
	private Items sword = new Items( "SWORD", null );
	
	public game(){
		
		//needs room discription and room dereconse from above
		store[0][0][0] = new RoomStore("room 1\nYou can go south or east", null, null, roomO1 );
		store[0][0][1] = new RoomStore("room 2\nYou can go south or west", null, null, roomO2 );
		store[0][0][2] = new RoomStore("room 3\nYou can go south", new Items[] { sword }, null, roomO3 );
		store[0][1][0] = new RoomStore("room 4\nYou can go south or north", null, null, roomO4 );
		store[0][1][1] = new RoomStore("room 5\nYou can go north, south or east", null, null, roomO5 );
		store[0][1][2] = new RoomStore("room 6\nYou can go south or north", null, null, roomO6 );
		store[0][2][0] = new RoomStore("room 7\nYou can go north or east", null, null, roomO7 );
		store[0][2][1] = new RoomStore("room 8\nYou can go north or west", null, null, roomO8 );
		store[0][2][2] = new RoomStore("room 9\nYou can go north", null, null, roomO9 );
		
	}

	public RoomStore[][][] getGame() {
		return store;
	}
	
	public int[] start() {
		return gameStart;
	}

}