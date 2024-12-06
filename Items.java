/*
* Item object class
* Version 1.0 
* @author Aaron Mellenma
*/

public class Items {

private int dmg;
private int durr;
private int weight;
private String name;
private String special;

/*
* Constructors
*/

public Items(String name, int dmg, int durr, int weight, String special) {

	this.name = name;
	this.dmg = dmg;
	this.durr = durr;
	this.weight = weight;
	this.special = special;

}

public Items(String name, int dmg, int durr, int weight) {

	this.name = name;
	this.dmg = dmg;
	this.durr = durr;
	this.weight = weight;

}

public Items (String name, int weight, String special) {

	this.name = name;
	this.special = special;
	this.weight = weight;

}

/*
* Return Methods
*/

public int returnDmg() { return dmg; }

public int returnDurr() { return durr; }

public int returnWeight() { return weight; }

public String returnName() { return name; }

public String returnSpecial() { return special; }

public String returnParam() {
	
	String r = "Name: " + name;
	r += dmg > 0 ? "\nDamage: " + dmg : "";
	r += durr > 0 ? "\nStructure Damage: " + durr : "";
	r += weight > 0 ? "\nWeight: " + weight : "";
	r += special == null ? "" : "\nSpecial ability: " + special;

	return r;
	
}



}
