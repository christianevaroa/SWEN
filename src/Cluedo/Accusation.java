package Cluedo;

public class Accusation {
	private Character murderer;
	private Room room;
	private Weapon weapon;
	
	public Accusation(Character murderer, Room room, Weapon weapon) {
		this.murderer = murderer;
		this.room = room;
		this.weapon = weapon;
	}
	
	public Character getMurderer() {
		return this.murderer;
	}
	
	public Room getRoom() {
		return this.room;
	}
	
	public Weapon getWeapon() {
		return this.weapon;
	}
}
