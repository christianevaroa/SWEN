package Cluedo;

public class Suggestion {

	private Character character;
	private Room room;
	private Weapon weapon;
	
	public Suggestion(Character character, Room room, Weapon weapon){
		this.character = character;
		this.room = room;
		this.weapon = weapon;
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
