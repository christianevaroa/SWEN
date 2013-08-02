package Cluedo;

public class Solution {
	private Character murderer;
	private Room room;
	private Weapon weapon;
	
	public Solution(Weapon sWeapon, Character sCharacter, Room sRoom) {
		this.weapon = sWeapon;
		this.murderer = sCharacter;
		this.room = sRoom;
	}
	
	public boolean checkAccusation(Accusation a) {
		return this.murderer.equals(a.getMurderer()) &&
				this.room.equals(a.getRoom()) &&
				this.weapon.equals(a.getWeapon());
	}
}
