package board;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.*;

import Cluedo.Game;
import Cluedo.Player;

public class BoardTests {
	

	
	private String[] characterNames = { "Kasandra Scarlett", "Jack Mustard", "Diane White", "Jacob Green", "Eleanor Peacock", "Victor Plum" };
	
	@Test
	public void validMovePlayer(){
		
		List<Player> players = createPlayers(6);
		Board b = new Board(players);
		b.createBoard();
		for(Player p : players){
			if(p.getName().equals("Jack Mustard")){
				assertTrue(b.move(p, "north"));
				assertTrue(b.move(p, "east"));
			}
			if(p.getName().equals("Kasandra Scarlett")){
				assertTrue(b.move(p,"north" ));
				assertTrue(b.move(p,"east" ));
				assertTrue(b.move(p,"west" ));
			}
			if(p.getName().equals("Diane White")){
				assertTrue(b.move(p, "east"));
				assertTrue(b.move(p, "south"));
				
			}
			if(p.getName().equals("Jacob Green")){
				assertTrue(b.move(p,"north" ));
				assertTrue(b.move(p, "east"));
			}
			if(p.getName().equals("Eleanor Peacock")){
				assertTrue(b.move(p, "east"));
				assertTrue(b.move(p, "south"));
			}
			if(p.getName().equals("Victor Plum")){
				assertTrue(b.move(p, "east"));
				assertTrue(b.move(p, "south"));
			}
		}
	}
	
	@Test
	public void invalidMovePlayer(){
		List<Player> players = createPlayers(6);
		Board b = new Board(players);
		b.createBoard();
		for(Player p : players){
			if(p.getName().equals("Jack Mustard")){
				assertFalse(b.move(p, "south"));
				assertFalse(b.move(p, "west"));
			}
			if(p.getName().equals("Kasandra Scarlett")){
				assertFalse(b.move(p, "south"));
				
			}
			if(p.getName().equals("Diane White")){
				assertFalse(b.move(p, "north"));
				assertFalse(b.move(p, "west"));
				
			}
			if(p.getName().equals("Jacob Green")){
				assertFalse(b.move(p, "south"));
				assertFalse(b.move(p, "west"));
			}
			if(p.getName().equals("Eleanor Peacock")){
				assertFalse(b.move(p, "north"));
				assertFalse(b.move(p, "west"));
			}
			if(p.getName().equals("Victor Plum")){
				assertFalse(b.move(p, "west"));
				assertFalse(b.move(p, "north"));	
			}
		}
		
	}
	
	
	@Test
	public void validstartPositions(){
		List<Player> players = createPlayers(4);
	//	Player g = new Player("Kasandra Scarlett");
		Board b =new Board(players);
		b.createBoard();
		
		for(Player p : players){
			if(p.getName().equals("Jack Mustard")){
			//	Point point = b.
		
			}
			if(p.getName().equals("Kasandra Scarlett")){
				System.out.println();
			}
		}
		
		
	}
	
	
	@Test
	public void testRoomNames(){
	//	Player playa = new Player("Eleanor Peacock");
		List<Player> players = new ArrayList<Player>();
		players.add(new Player("Eleanor Peacock"));
		
		Board b =new Board(players);
		b.createBoard();
		Player p = players.get(0);
		
		
		
		b.move(p, "south");
		b.moveTo(p, 4, 6);
		assertTrue(b.getRoom(p).equals("Spa"));
		b.moveTo(p, 10, 7);
		assertTrue(b.getRoom(p).equals("Theatre"));
		b.moveTo(p, 12, 2);
		assertTrue(b.getRoom(p).equals("Theatre"));
		
		b.moveTo(p, 14, 5);
		assertTrue(b.getRoom(p).equals("Living Room"));
		b.moveTo(p, 16, 8);
		assertTrue(b.getRoom(p).equals("Living Room"));
		
		b.moveTo(p, 22, 7);
		assertTrue(b.getRoom(p).equalsIgnoreCase("conservatory"));
		
		
		b.moveTo(p, 5,11);
		assertTrue(b.getRoom(p).equals("Patio"));		
		b.moveTo(p, 7,12);
		assertTrue(b.getRoom(p).equals("Patio"));	
		b.moveTo(p, 7,16);
		assertTrue(b.getRoom(p).equals("Patio"));	
		b.moveTo(p, 5,17);
		assertTrue(b.getRoom(p).equals("Patio"));
		
		b.moveTo(p, 22,11);
		assertTrue(b.getRoom(p).equals("Hall"));
		b.moveTo(p, 19,13);
		assertTrue(b.getRoom(p).equals("Hall"));
		b.moveTo(p, 19,14);
		assertTrue(b.getRoom(p).equals("Hall"));
	
		b.moveTo(p, 6,22);
		assertTrue(b.getRoom(p).equals("Kitchen"));
	
		b.moveTo(p, 12,19);
		assertTrue(b.getRoom(p).equals("Dining Room"));
		b.moveTo(p, 15,21);
		assertTrue(b.getRoom(p).equals("Dining Room"));

		b.moveTo(p, 20,20);
		assertTrue(b.getRoom(p).equals("Guest House"));

		
		b.moveTo(p, 14,11);
		assertTrue(b.getRoom(p).equals("Pool"));
		b.moveTo(p, 11,16);
		assertTrue(b.getRoom(p).equals("Pool"));
		b.moveTo(p, 16,16);
		assertTrue(b.getRoom(p).equals("Pool"));

		

		b.printBoard();
		
		
		
	}
	
	@Test
	public void testSecretPassage(){
		List<Player> players = new ArrayList<Player>();
		players.add(new Player("Eleanor Peacock"));
		
		Board b = new Board(players);
		b.createBoard();
		Player p = players.get(0);
		// move Player to spa
		b.moveTo(p, 4, 6);
		
		assertTrue(b.canUseSecretPassage(p));
		b.useSecretPassage(p);
		assertTrue(b.getRoom(p).equals("Guest House"));
		
		// now try and get back
		assertTrue(b.canUseSecretPassage(p));
		b.useSecretPassage(p);
		assertTrue(b.getRoom(p).equalsIgnoreCase("spa"));
		
		// test kitchen 
		b.moveTo(p, 6, 22);
		assertTrue(b.canUseSecretPassage(p));
		b.useSecretPassage(p);
		assertTrue(b.getRoom(p).equalsIgnoreCase("Conservatory"));
		
		// now move back
		assertTrue(b.canUseSecretPassage(p));
		b.useSecretPassage(p);
		assertTrue(b.getRoom(p).equalsIgnoreCase("kitchen"));
	}
	
	/**
	 * returns a List of random players specified by n
	 * @param n
	 * @return
	 */
	
	private List<Player> createPlayers(int n){
		if(n<3 || n > 6){
			try {
				throw new Exception();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// create list of players 
		List<Player> players = new ArrayList<Player>();
		for(int i= 0; i< characterNames.length; i++){
			players.add(new Player(characterNames[i]));		
		}
		
		// shuffle and return sublist with random players
		Collections.shuffle(players);
		return players.subList(0, n);
	}
	
}
