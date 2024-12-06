/*
* book reader class
* Version 1.0 
* @author Austin Deegan
*/
import java.io.File;
import java.io.FileNotFoundException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Read{
	
	private BufferedReader buff;
	private String store, line;

	public Read(){
		
		
	}

	public String read( String in ) {
		store = "";
		try{
			buff = new BufferedReader( new FileReader( in + ".txt" ) );
			while ( ( line = buff.readLine() ) != null ) {
				store += ( line + "\n" );
			}
		}
		catch(  FileNotFoundException e ){
			System.out.println( "Error: File Not Found" );
		}
		catch ( IOException e ) {
				e.printStackTrace();
			}
		return store;
	}


}