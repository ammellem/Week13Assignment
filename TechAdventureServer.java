

public class TechAdventureServer implements ConnectionListener {
	AdventureServer adventureServer = null;
	private run2 run = new run2();
	
	public TechAdventureServer ( ) {
		adventureServer = new AdventureServer ( );
		adventureServer.setOnTransmission ( this );
		
	}

	public void start( int port ) {
		adventureServer.startServer ( port );
	}

	@Override
	public void handle ( ConnectionEvent e ) {
		System.out.println( "EVENT RECEIVED - YOU MUST PARSE THE DATA AND RESPOND APPROPRIATELY" );
		System.out.println( String.format ( "connectionId=%d, data=%s", e.getConnectionID (), e.getData() ) );
		try {
			switch ( e.getCode ( ) ) {
				case CONNECTION_ESTABLISHED:
					run = new run2();
					adventureServer.sendMessage ( e.getConnectionID ( ), run.back() );
					
					break;
				case TRANSMISSION_RECEIVED:
					run.send( e.getData() );
					//System.out.println( run.back() );
					adventureServer.sendMessage ( e.getConnectionID ( ), run.back() );
					// BEWARE - if you keep this, any user can shutdown the server
					if ( e.getData ( ).equals ( "SHUTDOWN" ) ) {
						adventureServer.stopServer ( );
					}
					break;
				case CONNECTION_TERMINATED:
					// Cleanup when the connection is terminated.
					break;
				default:
					
			}
		} catch ( UnknownConnectionException unknownConnectionException ) {
			unknownConnectionException.printStackTrace ( );
		}
	}

	public static void main ( String[] args ) {
		TechAdventureServerDemo techAdventureServerDemo = new TechAdventureServerDemo ();
		techAdventureServerDemo.start ( 2112 );
	}

}
