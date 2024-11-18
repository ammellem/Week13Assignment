import java.util.Arrays;

public class Parse{
	private String in = "";
	private String[] comand = new String[ 5 ];
	String output = "";
	
	private Player player = new Player();
	
	private RoomStore[][][] store = new RoomStore[ 1 ][ 3 ][ 3 ];//change
	String[] roomO1 = {"cant","cant","cant",null,null,"cant"};
	String[] roomO2 = {"cant","cant","cant",null,"cant",null};
	String[] roomO3 = {"cant","cant","cant",null,"cant","cant"};
	String[] roomO4 = {"cant","cant",null,null,"cant","cant"};
	String[] roomO5 = {"cant","cant",null,null,null,"cant"};
	String[] roomO6 = {"cant","cant",null,null,"cant",null};
	String[] roomO7 = {"cant","cant",null,"cant",null,"cant"};
	String[] roomO8 = {"cant","cant",null,"cant","cant",null};
	String[] roomO9 = {"cant","cant",null,"cant","cant","cant"};

	private Room room = new Room ("room 1\nYou can go south or east", null,null, roomO1);
	
	public Parse() {//change
		store[0][0][0] = new RoomStore("room 1\nYou can go south or east", null, null, roomO1 );
		store[0][0][1] = new RoomStore("room 2\nYou can go south or west", null, null, roomO2 );
		store[0][0][2] = new RoomStore("room 3\nYou can go south", new String[] { "sword" }, null, roomO3 );
		store[0][1][0] = new RoomStore("room 4\nYou can go south or north", null, null, roomO4 );
		store[0][1][1] = new RoomStore("room 5\nYou can go north, south or east", null, null, roomO5 );
		store[0][1][2] = new RoomStore("room 6\nYou can go south or north", null, null, roomO6 );
		store[0][2][0] = new RoomStore("room 7\nYou can go north or east", null, null, roomO7 );
		store[0][2][1] = new RoomStore("room 8\nYou can go north or west", null, null, roomO8 );
		store[0][2][2] = new RoomStore("room 9\nYou can go north", null, null, roomO9 );
		
		
	}

	public void send( String input ){
		boolean error = false;
		in = input.toLowerCase();
		Arrays.fill( comand , null); 
		int i = 0, old = 0, count = 0;
		while ( i < in.length() - 1 && count < 5 ) {
			while ( in.charAt( i ) != ' ' && i < in.length() - 1 ) i++;
			if ( i != ( in.length() - 1 ) ) 
				comand[ count ] = in.substring( old, i );
			else comand[ count ] = in.substring( old, i + 1 );
			old = i + 1;
			i++;
			count++;
		}
		error = true;
		switch ( comand[ 0 ] ) {
			case  "get": 
				if ( count != 2 ) break;
				if ( player.full() ) output = "inventory full";
				else output = room.get( comand[ 1 ] );
				if ( output.equals( comand[ 1 ] ) ) {
					player.get( comand[ 1 ] );
					output += " Taken";
				}
				error = false; break;
				
			case  "drop": 
				if ( count != 2 ) break;
				output = player.drop( comand[ 1 ] );
				if ( !output.equals( "not in inventory:(" ) ) {
					room.add( output );
					output = output + " Droped";
				}
				error = false; break;
				
			case  "go": 
				if ( count != 2 ) break;
				move( comand[ 1 ] );
				error = false; break;
				
			case  "look": 
				if ( count != 1 ) break;
				output = room.look();
				error = false; break;
				
			case  "inventory": 
				if ( count != 1 ) break;
				output = player.myStuff();
				error = false; break;
			case  "stuff": 
				if ( count != 1 ) break;
				output = player.myStuff();
				error = false; break;
			case  "save": 
				error = true; break;
			case  "restore": 
				error = true; break;
			case  "quit": //finish
				output = "quit";
				error = false; break;
			default:
			
		}
		if ( error ) output = "I dont understand";//fix ladrer
		
	}

	public String receive() {
		return output;
	}

	private void move( String dorection ) {
		output = null;
		switch ( dorection.trim() ) {
			case  "up": 
				if ( room.go( 0 ) == null ) player.up();
				else output = room.go( 0 );
				break;
			case  "down": 
				if ( room.go( 1 ) == null ) player.down();
				else output = room.go( 1 );
				break;
			case  "north": 
				if ( room.go( 2 ) == null ) player.north();
				else output = room.go( 2 );
				break;
			case  "south": 
				if ( room.go( 3 ) == null ) player.south();
				else output = room.go( 3 );
				break;
			case  "east": 
				if ( room.go( 4 ) == null ) player.east();
				else output = room.go( 4 );
				break;
			case  "west": 
				if ( room.go( 5 ) == null ) player.west();
				else output = room.go( 5 );
				break;
			default:
				output = "Not a direction";
		}
		if ( output == null ) changeRoom();
	}

	private void changeRoom() {
		int[] L = player.position();
		int[] O = player.OL();
		store[ O[ 0 ] ][ O[ 1 ] ][ O[ 2 ] ].discripshonIn( room.upDataD( 
			store[ L[ 0 ] ][ L[ 1 ] ][ L[ 2 ] ].discripshonOut() ) );
		store[ O[ 0 ] ][ O[ 1 ] ][ O[ 2 ] ].itemsIn( room.upDataI( 
			store[ L[ 0 ] ][ L[ 1 ] ][ L[ 2 ] ].itemsOut() ) );
		store[ O[ 0 ] ][ O[ 1 ] ][ O[ 2 ] ].monstersIn( room.upDataM( 
			store[ L[ 0 ] ][ L[ 1 ] ][ L[ 2 ] ].monstersOut() ) );
		store[ O[ 0 ] ][ O[ 1 ] ][ O[ 2 ] ].outIn( room.upDataOut( 
			store[ L[ 0 ] ][ L[ 1 ] ][ L[ 2 ] ].outOut() ) );
		
		output = room.look();
	}




}