package Cluedo;

public class Accusation {
	private Person murderer;
	private Room room;
	private Weapon weapon;
	
	public Accusation(Person murderer, Room room, Weapon weapon) {
		this.murderer = murderer;
		this.room = room;
		this.weapon = weapon;
	}
	
	public Person getMurderer() {
		return this.murderer;
	}
	
	public Room getRoom() {
		return this.room;
	}
	
	public Weapon getWeapon() {
		return this.weapon;
	}
}
