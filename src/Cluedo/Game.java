package Cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	private Board board;
	private Player currentPlayer;
	private int numPlayers;
	private List<Card> remainingCards;
	private List<Player> players;
	private Scanner input;
	private Solution solution;

	public Game(){
		this.board = new Board();
		this.players = new ArrayList<Player>();
		this.remainingCards = new ArrayList<Card>();
		makeCards();
		makeSolution();
		input = new Scanner(System.in);
		System.out.println("How many players?");
		makePlayers(input.nextInt());
	}
	
	/**
	 * Tell the board to move the current player in a direction.
	 * Returns false if player couldn't move in that direction -> ask for a different direction.
	 * Returns true if the player was moved in that direction. 
	 * @param direction The compass direction to move the current player in.
	 * @return true of player was moved, false if player couldn't move in that direction.
	 */
	public boolean move(String direction){
		return board.move(currentPlayer, direction);
	}
	
	/**
	 * Create players based on the number of players entered.
	 * @param numPlayers Number of players to create.
	 */
	private void makePlayers(int numPlayers){
		input = new Scanner(System.in);
		for(int i = 1; i <= numPlayers; i++){
			System.out.println("Enter name for player "+i+":");
			players.add(new Player(input.next()));
		}
		this.numPlayers = numPlayers;
		input.close();
	}

	/**
	 * Create all cards for the game and put them into remainingCards
	 */
	private void makeCards(){
		// Create weapon cards
		for(int i = 0; i < weaponNames.length; i++){
			remainingCards.add(new Weapon(weaponNames[i]));
		}
		// Create character cards
		for(int i = 0; i < characterNames.length; i++){
			remainingCards.add(new Character(characterNames[i]));
		}
		// Create room cards
		for(int i = 0; i < roomNames.length; i++){
			remainingCards.add(new Room(roomNames[i]));
		}
	}

	/**
	 * Create a random solution for this game.
	 */
	private void makeSolution() {
		// To begin with, weapons occupy 0-8 in remainingCards,
		// characters are 9-14, and rooms are 15-24.
		int w = (int)Math.random() * 9;
		int c = 9 + (int)(Math.random() * (14 - 9 + 1));
		int r = 15 + (int)(Math.random() * (24 - 15 + 1));
		// Get cards for solution.
		Weapon sWeapon = (Weapon)remainingCards.get(w);
		Character sCharacter = (Character)remainingCards.get(c);
		Room sRoom = (Room)remainingCards.get(r);
		// Remove cards from remainingCards.
		remainingCards.remove(sWeapon);
		remainingCards.remove(sCharacter);
		remainingCards.remove(sRoom);
		// Create new solution.
		solution = new Solution(sWeapon, sCharacter, sRoom);
		System.out.println(solution);
	}
	
	/**
	 * String arrays for card names.
	 */
	private String[] weaponNames = { "Rope", "Candlestick", "Knife", "Pistol", "Baseball Bat", "Dumbbell", "Trophy", "Poison", "Axe" };
	private String[] characterNames = { "Kasandra Scarlett", "Jack Mustard", "Diane White", "Jacob Green", "Eleanor Peacock", "Victor Plum" };
	private String[] roomNames = { "Spa", "Theatre", "Living Room", "Conservatory", "Patio", "Hall", "Kitchen", "Dining Room", "Guest House", "Pool" };
	
}