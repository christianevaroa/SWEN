package board;

import Cluedo.*;

public class RoomTile extends Tile {
	private boolean[] directions;
	private String room;
	private Weapon weapon;
	private RoomTile secretPassage;

	public RoomTile(){
		
	}


	public RoomTile(boolean[] d, String roomname, Weapon w) {
		room = roomname;
		weapon = w;
		// TODO Auto-generated constructor stub Need to add in
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
