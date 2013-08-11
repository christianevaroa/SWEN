package board;

import Cluedo.*;

public class RoomTile extends Tile {
	private String room;
	private Weapon weapon;
	
	public RoomTile(){
		
	}


	public RoomTile( String roomname, Weapon w) {
		room = roomname;
		weapon = w;
	}
	
	
	public String getName(){
		return room;
	}

	public String toString(){
		
		return room + ", Weapon:  " + weapon;
	}
	
	public boolean canMove(){
		return false;
	}
	
	
	public Weapon contains(){
		return weapon;
	}

}
