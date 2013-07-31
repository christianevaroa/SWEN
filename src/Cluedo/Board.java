package Cluedo;

import java.awt.Point;
import java.util.List;
import java.util.Map;

public class Board {
	private Tile[][] board;
	private Map<Player, Point> playerMap;
	private List<Player> players;
	
	public Board() {
		board = new Tile[25][25];
	}
	
	public Room getRoom(Player player) {
		Point p = playerMap.get(player);
		
		return null;
	}
	
	

}
