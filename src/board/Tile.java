package board;

import java.util.Arrays;

public abstract class Tile {
	private boolean[] directions;
	private String room;
	
	public Tile(){
		
		
	}
	

	
	// can move into this square?
	public boolean canMove(){
		return false;
	}
	
	public String getRoom() {
		return room;
	}

}
