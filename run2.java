import java.util.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class run2{
	
		Parse p = new Parse();
		Scanner in = new Scanner( System.in );
		
		String save = "";
		String text;
		String name;
		String out = "";
	
	
	public run2() {
		p.send( "look" );
		out = p.receive() + "\n";
	}
	
	
	public void send( String in ) {
		text = in;
	
		
		
		
		if ( text.length() > 4 && 
			text.substring( 0, 4 ).equalsIgnoreCase( "save" ) ) {
			try {
				name = text.substring( 5, text.length() );
				if ( !name.endsWith( ".txt" ) ) name += ".txt";
				
				PrintWriter writer = new PrintWriter( name );
				writer.println( save );
				writer.close();
				out =  "game saved\n";
			}
			catch(  FileNotFoundException e ){
				System.out.println( "Error: File Not Found" );
			}
			
		}
		else if ( text.length() > 4 && 
			text.substring( 0, 4 ).equalsIgnoreCase( "load" ) ) {
			try{
				name = text.substring( 5, text.length() );
				if ( !name.endsWith( ".txt" ) ) name += ".txt";
				BufferedReader buff = 
					new BufferedReader( new FileReader( name ) );
				p = new Parse();
				save = "";
				while ( ( text = buff.readLine() ) != null ) {
					p.send( text );
					save += ( text + "\n" );
				}
				out = name + " loaded successfully\n";
				p.send( "look" );
				out += ( p.receive() + "\n" );
				
			}
			catch(  FileNotFoundException e ){
				out = "Error: File Not Found\n";
			}
			catch ( IOException e ) {
				e.printStackTrace();
			}
		} else {
			
			p.send( text );
			save += ( text + "\n" );
			out = p.receive() + "\n";
		}	
		
	}
	
	public String back() {
		return out;
	}
}