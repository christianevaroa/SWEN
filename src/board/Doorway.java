package board;

public class Doorway extends Tile {

	Board board;
	RoomTile room;
	String roomname;
	int x;
	int y;


	/**
	 * Door way is a special type of tile. It represents the entrance to a room. The player can choose to move onto
	 * the doorway tile and then is transported in the room. The player can only move into a room and move out of
	 * a room It cannot look around.
	 *
	 * @param dirs
	 * @param roomname
	 * @param b
	 * @param r
	 */
	public Doorway(String roomname, Board b, RoomTile r, int x , int y) {
		//super(dirs, roomname);
		roomname = roomname;
		board= b;
		this.x = x;
		this.y = y;
		room = r;
	

		// TODO Auto-generated constructor stub
	}
	
	public Doorway(){
		
	}
	
	public String getRoom(){
		return room.getName();
	}
	
	public RoomTile getRoomm(){
		return room;
	}
	
	
	
	
	public boolean canMove(){
		return true;
	}
	

}
