package Cluedo;

public class Solution {
	private Person murderer;
	private Room room;
	private Weapon weapon;
	
	public Solution(Person murderer, Room room, Weapon weapon) {
		this.murderer = murderer;
		this.room = room;
		this.weapon = weapon;
	}
	
	public boolean checkAccusation(Accusation a) {
		return this.murderer.equals(a.getMurderer()) &&
				this.room.equals(a.getRoom()) &&
				this.weapon.equals(a.getWeapon());
	}
}
