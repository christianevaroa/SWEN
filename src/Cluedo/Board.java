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

	
	/**
	 * These methods are just so I can test the game class, not actually going to use this
	 */
	
	public boolean canSuggest(Player currentPlayer) {
		// TODO Auto-generated method stub
		return true;
	}

	public boolean canAccuse(Player currentPlayer) {
		// TODO Auto-generated method stub
		return true;
	}

	public void evaluateSuggestion(Suggestion suggestion, Player currentPlayer) {
		// TODO Auto-generated method stub
		
	}

	public boolean move(Player currentPlayer, String direction) {
		if(direction.equals("n") || direction.equals("e") || direction.equals("s") || direction.equals("w"))
			return true;
		return false;
	}
	
	

}
