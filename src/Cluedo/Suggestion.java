package Cluedo;

public class Suggestion {

	private Weapon weapon;
	private Character character;
	private Room room;
	
	public Suggestion(Weapon weapon, Character character, Room room){
		this.weapon = weapon;
		this.character = character;
		this.room = room;
	}
	
	public Weapon getWeapon(){
		return this.weapon;
	}
	
	public Character getCharacter(){
		return this.character;
	}
	
	public Room getRoom(){
		return this.room;
	}
	
}
