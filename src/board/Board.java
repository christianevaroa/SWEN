package board;


import java.awt.Point;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import Cluedo.*;

public class Board {
	private Tile[][] board;
	private Map<Player, Point> playerMap;
	private List<Player> players;
	private List<Room> rooms;

	
	public Board(){
		board = new Tile[25][25];
	}

	public Board(List<Player> p) {
		players =p;
		board = new Tile[25][25];

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
	 * 
	 */
	
	public void createBoard(){
		
		try{
			//String line;
			BufferedReader br = new BufferedReader(new FileReader("board"));
			char[] temp = new char[25];
			//line = br.readLine();
			for(int i =0; i<26; i++){
				br.read(temp);
				readBoardLine(temp);
			}
				
			br.close();
			
		}catch (IOException e){
			System.out.println(e.getStackTrace());
		}
		
	}
	
	private Tile[] readBoardLine(char[] info){
		Tile[] tiles = new Tile[25];
		int chartile;
		
		for(int i = 0; i< info.length ;i++){
			System.out.print(info[i]);
			
			switch
			
			
			if(info[i]=='#'){
				Tile t = new HallTile();
			}
			if(info[i]==)
			
			
			
		}
		return null;
	}




	private void createDoors(){


	}

	private void createRooms(List<Weapon> weapons){

		Collections.shuffle(weapons);
		int index = 0;


		boolean dirs[] = {true, false, false, false};

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


	public static void main(String args[]){
		Board b = new Board();
		try {
			b.createBoard();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}


}
