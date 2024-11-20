import java.util.Arrays;

public class Parse{
	private String in = "";
	private String[] comand = new String[ 5 ];
	String output = "";
	
	
	private game g = new game();
	private int[] S = g.start();
	private Player player = new Player( S );
	private RoomStore[][][] store = null;
	private Items itemOutput = null;

	private Room room = new Room();
	
	public Parse() {//change
		
		store = g.getGame();
		room.upDataD( store[ S[ 0 ] ][ S[ 1 ] ][ S[ 2 ] ].discripshonOut() );
		room.upDataI( store[ S[ 0 ] ][ S[ 1 ] ][ S[ 2 ] ].itemsOut() );
		room.upDataM( store[ S[ 0 ] ][ S[ 1 ] ][ S[ 2 ] ].monstersOut() );
		room.upDataOut( store[ S[ 0 ] ][ S[ 1 ] ][ S[ 2 ] ].outOut() );
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
			case  "get": //test
				if ( count != 2 ) break;
				if ( player.full() ) output = "inventory full";//fix
				else itemOutput = room.get( comand[ 1 ] );
				if ( itemOutput != null && 
					itemOutput.returnName().equalsIgnoreCase( comand[ 1 ] ) ) {
						
					player.get( itemOutput );
					output = itemOutput.returnName() + " Taken";
				}
				else output = ( "No " + comand[ 1 ] + " found" );
				error = false; break;
				
			case  "drop": //test
				if ( count != 2 ) break;
				itemOutput = player.drop( comand[ 1 ] );
				if ( itemOutput != null ) {
					room.add( itemOutput );
					output = itemOutput.returnName() + " Droped";
				}
				else output = "Not in inventory:(";
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
				output = "quiting";
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