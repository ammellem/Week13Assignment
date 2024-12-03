import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;


public class GameRunner {
	public static void main ( String[] args ) {
		if ( args.length == 1 ) 
			args = new String[] { args[ 0 ], "2112" };
		if ( args.length != 2 ) {
			System.out.println( "Command line arguments: server_address port" );
		} else {
			try ( Socket server = new Socket ( args[0], Integer.valueOf ( args[1] ) ) ) {
				System.out.println( "Connected to AdventureServer host " + server.getInetAddress () );
				BufferedReader fromServer = new BufferedReader ( new InputStreamReader ( server.getInputStream () ) );
				PrintWriter toServer = new PrintWriter ( server.getOutputStream (), true );
				BufferedReader keyboardInput = new BufferedReader ( new InputStreamReader ( System.in ) );
				String s = " ";
				System.out.print( "\033[H\033[2J" ); // clear terminal
				while ( !s.equalsIgnoreCase( "quit" ) ) {
					
					while (!s.equals( "" ) ){
						s = fromServer.readLine ();
						System.out.println( s );
						if ( s.endsWith( "quiting" ) ) break;
					}
					System.out.print("> ");
					System.out.flush ();
					if ( s.endsWith( "quiting" ) ) break;
					s=keyboardInput.readLine ();
					toServer.println ( s );
					System.out.println();					
				}
				if ( s.equalsIgnoreCase( "quit" ) ) 
					System.out.println( "quiting\n" );
				fromServer.close ();
				toServer.close ();
				keyboardInput.close ();
			} catch ( UnknownHostException e ) {
				e.printStackTrace ( );
			} catch ( IOException e ) {
				e.printStackTrace ( );
			}
		}
	}
}
