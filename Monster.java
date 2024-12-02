/*
* Monster object class
* Version 1.0 
* @author Austin Deegan
*/

public class Monster{

	private String name;
	private int health;
	private int damage;


	public Monster( String in1, int in2, int in3 ){
		name = in1;
		health = in2;
		damage = in3;	
	}

	public int Health() { return health; }
	
	public String Name() { return name; }
	
	public int Damage() { return damage; }

	public int hit( int in ) {
		health =- in;
		return health;
	}
}