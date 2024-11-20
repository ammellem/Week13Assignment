import java.util.*;

public class run{
	public static void main ( String[] args ) {
		System.out.print("\033[H\033[2J"); // clear terminal
		Parse p = new Parse();
		Scanner in = new Scanner( System.in );
		p.send( "look" );
		System.out.println( p.receive() + "\n" );
		while (!p.receive().equals("quiting")){
			
			p.send( in.nextLine() );
			System.out.println();
			System.out.println( p.receive() );
			System.out.println();
			
			
		}
	}
}