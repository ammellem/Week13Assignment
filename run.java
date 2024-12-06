import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class run{
	public static void main ( String[] args ) {
		System.out.print("\033[H\033[2J"); // clear terminal
		Parse p = new Parse();
		Scanner in = new Scanner( System.in );
		p.send( "look" );
		String save = "";
		String text;
		String name;
		System.out.println( p.receive() + "\n" );
		while ( !p.receive().endsWith( "quiting" ) ){
			
			text = in.nextLine();
			
			if ( text.length() > 4 && text.substring( 0, 4 ).equalsIgnoreCase( "save" ) ) {
				try {
					name = text.substring( 5, text.length() );
					if ( !name.endsWith( ".txt" ) ) name += ".txt";
					
					PrintWriter writer = new PrintWriter( name );
					writer.println( save );
					writer.close();
					System.out.println( "game saved\n" );
				}
				catch(  FileNotFoundException e ){
					System.out.println( "Error: File Not Found" );
				}
				
			}
			else if ( text.length() > 4 && text.substring( 0, 4 ).equalsIgnoreCase( "load" ) ) {
				try{
					name = text.substring( 5, text.length() );
					if ( !name.endsWith( ".txt" ) ) name += ".txt";
					BufferedReader buff = new BufferedReader( new FileReader( name ) );
					p = new Parse();
					save = "";
					while ( ( text = buff.readLine() ) != null ) {
						p.send( text );
						save += ( text + "\n" );
					}
					System.out.println( name + " loaded successfully\n" );
					p.send( "look" );
					System.out.println( p.receive() );
					System.out.println();
				}
				catch(  FileNotFoundException e ){
					System.out.println( "Error: File Not Found\n" );
				}
				catch ( IOException e ) {
					e.printStackTrace();
				}
			} else {
				
				p.send( text );
				save += ( text + "\n" );
				System.out.println();
				System.out.println( p.receive() );
				System.out.println();
			}
			
		}
	}
}