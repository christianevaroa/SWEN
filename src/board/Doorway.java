package board;

public class Doorway extends Tile {

	Board board;
	RoomTile room;


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
	public Doorway(boolean[] dirs, String roomname, Board b, RoomTile r) {
		//super(dirs, roomname);



		board= b;
		room = r;

		// TODO Auto-generated constructor stub
	}
	
	public Doorway(){
		
	}
	

}
