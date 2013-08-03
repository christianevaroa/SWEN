package board;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import Cluedo.*;

public class Board {
	private int width = 25;
	private int height = 25;
	private Tile[][] board;
	private Map<Player, Point> playerMap;
	private List<Player> players;
	private List<Room> rooms;

	
	public Board(){
		board = new Tile[height][width];
	}

	public Board(List<Player> p) {
		players =p;
		board = new Tile[height][width];

	}

	public Room getRoom(Player player) {
		Point p = playerMap.get(player);

		return null;
	}




	/**
	 * Moves player one step in the given direction returns true if possible, false if otherwise
	 * @param p
	 * @param direction
	 * @return
	 */

	public boolean move(Player p, String direction){

		if(direction.equalsIgnoreCase("north")){
			int[] move = {0,-1};
			Point current = playerMap.get(p);
			
			
			
		
		}
		if(direction.equalsIgnoreCase("south")){
			int[] move = {0,1};
			Point current = playerMap.get(p);
		}
		if(direction.equalsIgnoreCase("east")){
			int[] move = {1,0};
			Point current = playerMap.get(p);
		}
		if(direction.equalsIgnoreCase("west")){
			int[] move = {-1,0};
			Point current = playerMap.get(p);
		}




		return false;
	}



	/**
	 * Moves the player and weapon to the room in the suggestion
	 *
	 * @param p
	 * @param s
	 */

	public void evaluateSuggestions(Player p , Suggestion s){
		// move


	}

	
	/**
	 *  reads in the board from the 'board' file which is an ascii representation
	 *  of the board. 
	 *  	'#' is represents a wall
	 *  	'd' represents a doorway 
	 *   	' ' is a hallway tile
	 * 
	 */
	
	public void createBoard(){
		
		try{
			// read in the board from board file
			BufferedReader br = new BufferedReader(new FileReader("board"));
		
			for(int i =0; i<25; i++){
				// turns each line into an array
				String line = br.readLine();
				char[] temp = line.toCharArray();
				// then hands over to the readBoardLine method which chops it up into
				// an array of tiles and adds to the 2d array of tiles
				board[i] = readBoardLine(temp);

			}
			
			br.close();
			//just to check if it works, will delete this	
			System.out.println(this.toString());
			
			
			
		}catch (IOException e){
			System.out.println(e.getStackTrace());
		}
	}
	
	/**
	 * Builds a string of characters representing the board
	 */
		
	@Override
	public String toString(){
		if(board==null){
			return "null";
		}else{
			StringBuilder sb = new StringBuilder();
				
			for(int i = 0; i<board[0].length;i++){
				for(int j = 0;j<board[i].length; j++){
					if(board[i][j] instanceof Wall){
						sb.append('#');
					}
					if(board[i][j] instanceof HallTile){
						sb.append(' ');
					}
					if(board[i][j] instanceof Doorway){
						sb.append('d');
					}
				}
				sb.append('\n');
			}	
			return sb.toString();
		}
	}
	
	
	
	/**
	 * helper method that converts a char array into a an array of tiles which represent one row on the board
	 * @param info
	 * @return
	 */
	
	
	private Tile[] readBoardLine(char[] info){
		Tile[] tiles = new Tile[25];
		int chartile;
		
		for(int i = 0; i< info.length ;i++){

			
			chartile = info[i];
			switch(chartile){
				case '#': 
					Tile t = new Wall();
					tiles[i] = t;
					break;
				case 'd':
					Tile d = new Doorway();
					tiles[i] = d;
					break;
				case ' ':
					Tile h = new HallTile();
					tiles[i]= h;
					break;
				case 'f':
					Tile w = new Wall();
					tiles[i] = w;
					break;
				default:
					break;
			}
			

		}
		return tiles;
	}

	
	private void checkValidMove(){
		
		
	}



	private void createDoors(){


	}

	
	/**
	 * Manually creates the Rooms on the board
	 * @param weapons
	 */
	
	private void createRooms(List<Weapon> weapons){
		// probably gonna have to manually add rooms
		Collections.shuffle(weapons);
		int index = 0;

		boolean dirs[] = {true, false, false, false};
		// create kitchen
		RoomTile r = new RoomTile(dirs, "Kitchen",weapons.get(index++));
		
		
		
	}




	private void assignPlayers(){
		Point location;
		for(Player p : players){
			if(p.getName().equals("Kasandra Scarlett")){
				location = new Point(19, 24);
				playerMap.put(p, location);
			}
			if(p.getName().equals("Jack Mustard")){
				location = new Point(8,24);
				playerMap.put(p, location);
			}
			if(p.getName().equals("Diane White")){
				location = new Point(0,14);
				playerMap.put(p, location);
			}
			if(p.getName().equals("Jacob Green")){
				location = new Point(0, 10);
				playerMap.put(p, location);
			}
			if(p.getName().equals("Eleanor Peacock")){
				location = new Point(7, 0);
				playerMap.put(p, location);
			}
			if(p.getName().equals("Victor Plum")){
				location = new Point(21, 0);
				playerMap.put(p, location);
			}
		}
	}


	public static void main(String args[]) throws IOException{
		Board b = new Board();
		b.createBoard();
		

	}


}
