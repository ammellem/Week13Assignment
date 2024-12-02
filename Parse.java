import java.util.Arrays;

public class Parse{
	private String in = "";
	private String[] comand = new String[ 5 ];
	String output = "";
	private int damage = 0;
	
	private game g = new game();
	private int[] S = g.start();
	private Player player = new Player( S, g.maxWeight() );
	private RoomStore[][][] store = null;
	private Items itemOutput = null;

	private Room room = new Room();
	
	public Parse() {
		
		store = g.getGame();
		room.upDataD( store[ S[ 0 ] ][ S[ 1 ] ][ S[ 2 ] ].discripshonOut() );
		room.upDataI( store[ S[ 0 ] ][ S[ 1 ] ][ S[ 2 ] ].itemsOut() );
		room.upDataM( store[ S[ 0 ] ][ S[ 1 ] ][ S[ 2 ] ].monstersOut() );
		room.upDataOut( store[ S[ 0 ] ][ S[ 1 ] ][ S[ 2 ] ].outOut() );
		room.upDataS( store[ S[ 0 ] ][ S[ 1 ] ][ S[ 2 ] ].smashOut() );
	}

	public void send( String input ){
		boolean error = false;
		int second = 0;
		int[] L = player.position();
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
			     itemOutput = room.get( comand[ 1 ] );
				if ( itemOutput != null && 
					itemOutput.returnName().equalsIgnoreCase( comand[ 1 ] ) ) {
					if ( player.full( itemOutput.returnWeight() ) == null ) {	
						player.get( itemOutput );
						output = itemOutput.returnName() + " Taken";
					}
					else {
						room.add( itemOutput );
						output = player.full( itemOutput.returnWeight() );
					}
				}
				else output = ( "No " + comand[ 1 ] + " found" );
				error = false; break;
				
			case  "drop": 
				if ( count != 2 ) break;
				itemOutput = player.drop( comand[ 1 ] );
				if ( itemOutput != null ) {
					room.add( itemOutput );
					output = itemOutput.returnName() + " Droped";
				}
				else output = ( comand[ 1 ] + " not in inventory:(" );
				error = false; break;
			case  "open":
				if ( count == 2 ) {
					output = "Can not be done";
					error = false;
					break;
				}
				if ( count != 4 ) break;
				itemOutput = player.search( comand[ 3 ] );
				if ( itemOutput != null ) {
					second = room.open( itemOutput.returnSpecial() );
					if ( second == -1 ) 
						output = "The " + itemOutput.returnName() + 
						" did not work";
					else {
						if ( second == 0 ) 
							store[ L[ 0 ] + 1 ][ L[ 1 ] ][ L[ 2 ] ]
							.open( second );
						if ( second == 1 ) 
							store[ L[ 0 ] - 1 ][ L[ 1 ] ][ L[ 2 ] ]
							.open( second );
						if ( second == 2 ) 
							store[ L[ 0 ] ][ L[ 1 ] + 1 ][ L[ 2 ] ]
							.open( second );
						if ( second == 3 ) 
							store[ L[ 0 ] ][ L[ 1 ] - 1 ][ L[ 2 ] ]
							.open( second );
						if ( second == 4 ) 
							store[ L[ 0 ] ][ L[ 1 ] ][ L[ 2 ] + 1 ]
							.open( second );
						if ( second == 5 ) 
							store[ L[ 0 ] ][ L[ 1 ] ][ L[ 2 ] - 1 ]
							.open( second );
						output = "your pathway is now clear";
					}
					
				}
				else output = comand[ 3 ] + " not in inventory:(";
				error = false; break;
				
			case  "smash":
				if ( count == 2 ) {
					output = "No effect and your hand hurts";//fix spell
					error = false;
					break;
				}
				if ( count != 4 ) break;
				itemOutput = player.search( comand[ 3 ] );
				if ( itemOutput != null ) {
					second = room.open( itemOutput.returnDurr() );
					if ( second == -1 ) 
						output = "The " + itemOutput.returnName() + 
						" did not work";
					else {
						if ( second == 0 ) 
							store[ L[ 0 ] + 1 ][ L[ 1 ] ][ L[ 2 ] ]
							.open( second );
						if ( second == 1 ) 
							store[ L[ 0 ] - 1 ][ L[ 1 ] ][ L[ 2 ] ]
							.open( second );
						if ( second == 2 ) 
							store[ L[ 0 ] ][ L[ 1 ] + 1 ][ L[ 2 ] ]
							.open( second );
						if ( second == 3 ) 
							store[ L[ 0 ] ][ L[ 1 ] - 1 ][ L[ 2 ] ]
							.open( second );
						if ( second == 4 ) 
							store[ L[ 0 ] ][ L[ 1 ] ][ L[ 2 ] + 1 ]
							.open( second );
						if ( second == 5 ) 
							store[ L[ 0 ] ][ L[ 1 ] ][ L[ 2 ] - 1 ]
							.open( second );
						output = "your pathway is now clear";
					}
					
				}
				else output = comand[ 3 ] + " not in inventory:(";
				error = false; break;
				
			case  "kill": 
				
				if ( count == 2 ) { 
					output = room.kill( comand[ 1 ], 1 );
					error = false;
					break;
				}
				if ( count != 4 ) break;
				itemOutput = player.search( comand[ 3 ] );
				if ( itemOutput != null ) {
					output = room.kill( comand[ 1 ], itemOutput.returnDmg() );
				}
				else output = comand[ 3 ] + " not in inventory:(";
				
				
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
		damage = room.damage();
		if ( !comand[ 0 ].equalsIgnoreCase( "kill" ) ) damage = damage * 2;
		if ( damage != 0 && ( comand[ 0 ].equalsIgnoreCase( "get" ) || 
			comand[ 0 ].equalsIgnoreCase( "drop" ) || 
			comand[ 0 ].equalsIgnoreCase( "smash" ) || 
			comand[ 0 ].equalsIgnoreCase( "open" ) || 
			comand[ 0 ].equalsIgnoreCase( "kill" ) ) ) {
			damage = player.damage( damage );
			if ( damage > 0 )
				output += "\nYou take damage. You have " + damage + 
				"health left";
			else output = "\nYou take damage and have died\nquiting";
		}
		
		
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
		if ( output == null ) {
			damage = room.damage() * 2;
			if ( damage != 0 ) {
				damage = player.damage( damage );
				if ( damage > 0 ) {
					output = "\nYou take damage. You have " + damage + 
					" health left\n";
					changeRoom();
				}
				else output = "\nYou take damage and have died\nquiting";
			} else changeRoom();
		}
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
		store[ O[ 0 ] ][ O[ 1 ] ][ O[ 2 ] ].smashIn( room.upDataS( 
			store[ L[ 0 ] ][ L[ 1 ] ][ L[ 2 ] ].smashOut() ) );
			
		if ( output != null ) output += room.look();
		else output = room.look();
	}




}