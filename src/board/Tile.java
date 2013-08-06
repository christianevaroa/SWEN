package board;

import java.util.Arrays;

public abstract class Tile {
	private boolean[] directions;
	private String room;
	
	public Tile(){
		
		
	}
	
	/*public Tile(boolean[] dirs, String room) {
		this.directions = Arrays.copyOf(dirs, dirs.length);
		this.room = room;
	}*/
	
	/**
	 * Directions:
	 * 0: North
	 * 1: East
	 * 2: South
	 * 3: West
	 * @param dir Int representing the direction to check.
	 * @return directions[dir] or false if dir is invalid (out of bounds)
	 */
	/*
	 * public boolean canMove(int dir) {
		if(dir < 0 || dir > 3){ return false; }
		return directions[dir];
	}
	*/
	
	// can move into this square?
	
	public boolean canMove(){
		return false;
		
	}
	
	public String getRoom() {
		return room;
	}

}
