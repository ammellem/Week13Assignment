
public class game{
	private int playerMaxWeight = 125;//small 10 medeom 25 hevy 50
	private int health = 16;
	private RoomStore[][][] store = new RoomStore[ 4 ][ 3 ][ 7 ];//change
	private int[] gameStart = { 0, 1, 3 }; //starting locashon
	//define one for each room. null There is a path in that dorecshon. 
	//wall if there is a wall. Anything else will be displayed. null is clear
	String[] r013 = { "wall", "wall", "wall", "wall",
		"Celldoor", "wall" };
	String[] r014 = { "wall", "wall", "wall", "wall",
		"Wooden Door", null };
	String[] r015 = { null, "wall", "wall", "wall",
		"wall", null };
	String[] r115 = { "wall", null, null, "iron door",
		"wall", null };
	String[] r114 = { "wall", "wall", "Locked door with a" +
		" pirate hat engraved on it", "wall",
		null, null };
	String[] r104 = { "Parrot blocking the stairs looking for gold", 
		"wall", "wall" , null, "wall", "wall" };
	String[] r113 = { "wall", "wall", "Locked porthole" , "wall",
		null, "wall" };
	String[] r102 = { "wall", "wall", "wall" , "wall",
		"wall", "wall" };
	String[] r103 = { "wall", "wall", "wall" , null,
		"wall", "The age of the boat" };
	String[] r105 = { "wall", "wall", "wall" , null,
		"wall", "wall" };
		
	String[] r204 = { "Boat mask", null, "wall" , "wall", 
		"Locked door with a skull", null };
		
	String[] r205 = { "wall", "wall" , "wall" , "wall", "wall", null };
		
	String[] r203 = { "wall", "wall", "wall" , "wall", null, "wall" };
		
	String[] r304 = { "wall", null, "wall" , "wall", "wall", "wall" };
		
	//item: name , damage, smash, wg, speshal
	private Items knife = new Items( "KNIFE", 2, 0, 5 );
	private Items key = new Items( "KEY", 5, "Celldoor" );
	private Items ball = new Items( "CANNONBALL", 100, 5, 120 );
	private Items coins = new Items( "COIN", 0, 0, 40, 
		"Parrot blocking the stairs looking for gold" );
	private Items rope = new Items( "ROPE", 0, 0, 30, 
		"The age of the boat" );
	private Items nails = new Items( "NAILS", 0, 0, 20, "" );
	private Items dagger = new Items( "DAGGER", 10, 0, 30, "" );
	private Items sword = new Items( "SWORD", 50, 0, 75, "" );
	private Items key2 = new Items( "PIRATE_KEY", 0, 0, 5, 
		"Locked door with a pirate hat engraved on it" );
	private Items key3 = new Items( "SKULL_KEY", 0, 0, 5, 
		"Locked door with a skull" );
	private Items key4 = new Items( "BOAT_KEY", 0, 0, 5, "Locked porthole" );
	private Items ladder = new Items( "LADDER", 0, 0, 50, "Boat mask" );
	//monster: name, health, damage, items
	private Monster guard = new Monster( "GUARD", 2, 1 );
	private Monster guard2 = new Monster( "GUARD", 10, 3 , 
		new Items[]{ key2 } );
	private Monster pirate = new Monster( "PIRATE", 15, 5,
		new Items[]{ sword } );
	private Monster captan = new Monster( "CAPTAiN", 100, 10,
		new Items[]{ key4 } );
	private Monster chest = new Monster( "CHEST", 2, 0, 
		new Items[]{ dagger } );
	
	public game(){
		
		//needs room discription and room dereconse from above
		// discripshon, items, monsters, out, smash
	   store[0][1][3] = new RoomStore( "Welcome to Escape The Black Revenant" +
			"You are startled awake with a" + 
			"violent crash as you're rolled into the moist wooden wall" +
			" of your cell. You appear to be in a cell, but where you are" +
			" is a mystery.\nYou notice the guard is asleep next to a room" +
			" facing east. The guards keys are dangling just close enough" +
			" to reach\nYou can go east", new Items[] { key }, r013 );
	    store[0][1][4] = new RoomStore( "You walk into a dark room with dim" +
			" candle lights, the room is a crude representation of a kitchen" +
			" back home. Home? You don't remember any home" +
			"\nThe room has a block with a rusty dull knife jammed into it" +
			"\nYou notice a grunge of miscellaneous shipping tools and crude" +
			" broken wood.\nYou can go east and west", 
		   new Items[] { knife, ball, rope }, r014, new int[] { 0, 0, 0, 0, 4, 0 } );
	    store[0][1][5] = new RoomStore( "After a loud crash the door flings" +
			" open, a crash loud enough to wake someone up" +
			"\nYou walk into a dark room only lit by light from above, the" +
			" room has a ladder going up and table with a bag of coins" +
			"\nYour victory is short lived, you hear a loud HEYY!! as the" +
			" guard comes rushing into the room\nYou can go west or up", 
			new Items[] { coins }, new Monster[] { guard }, r015 );
		store[1][1][5] = new RoomStore( "As you walk into the room the sweet," +
			" but bitter, sent of the ocean waves your nose" +
			"\nVoices can be heard in the north most room" +
			"\nYou can go north and west and down", r115 );
		store[1][1][4] = new RoomStore( "The smell of the ocean grows" +
			" stronger as you walk into this room" +
			"\nA rusty chest can be seen, it looks like the lock can be" +
			" broken with a sharp object\nYou can north, east, and west", 
			new Monster[] { chest }, r114 );
		store[1][0][4] = new RoomStore( "A rickety staircase rests against" +
			" the back of the room" +
			"\nMoonlight spills over the head of the stairs, the surface of" +
			" the ship rests above you\nYou can go south and up", r104 );
		store[1][1][3] = new RoomStore( "As you enter the room a dim glow of" +
			" the moon can be seen through a locked wallside porthole with a" +
			" large boat symbol on it" +
			"\nA rowboat can be seen strapped far below the porthole reach," +
		   " escape could be possible here\nYou can go north and east", r113 );
		store[1][0][3] = new RoomStore( "You made it out of the ship but the" +
			" rowboat is to low.\nIf only you had somthing to climb down" +
			" with\nYou can go south", r103 );
		store[1][0][2] = new RoomStore( "You made it to the rowboat and are" +
			" sailing away. In the distance you see a shipcoming to save" +
			" you. At last this nightmare is over.\nCongratulations on" +
			" escaping The Black Revenant!\nquiting", r102 );
		store[1][0][5] = new RoomStore( "The voices are far more than voices" +
			" as a large pirate with a jagged blade stares you down" +
			"\nHe is big, a notable weapon would be required to vanquish him" +
			"\nYou can go south", new Monster[] { guard2 }, r105 );
		store[2][0][5] = new RoomStore( "You walk into a room and are met" +
			" by a menacing figure: a man with a jet-black beard, scars" +
			" etched across his face and scattered over places you'd rather" +
			" not imagine. A foe like this demands nothing less than a" +
			" formidable weapon. Only a full-sized sword, wielded with" +
			" precision and strength, could hope to bring him down." +
			"\nYou can go west", new Monster[] { captan }, r205 );
		store[2][0][3] = new RoomStore( "A stout pirate with tangled dark" +
			" hair blocks" +
			" your exit. A quick strike with a reliable blade would get him" +
			" out of your way\nYou can go east", new Items[] { ladder }, 
			new Monster[] { pirate }, r203 );
		store[2][0][4] = new RoomStore( "You are on the center deck of the" +
			" vast ship\nA grungy door blocks the room to the east, you'd" +
			" need a gnarly looking key for this thing. You hear a voice" +
			" muttering to the west. The ships mask sits at" +
			" the center of the room.\nYou can go east, west, up, and down", 
			r204 );
		store[3][0][4] = new RoomStore( "Under the pale moonlight, you see" +
			"nothing but fog and endless ocean\nYou can go down", 
			new Items[] { key3 }, r304 );
	}

	//do not change
	public RoomStore[][][] getGame() { return store; }
	public int[] start() { return gameStart; }
	public int maxWeight() { return playerMaxWeight; }
	public int startHealth() { return health; }
}