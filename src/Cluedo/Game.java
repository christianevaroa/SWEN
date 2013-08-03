package Cluedo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

	private Board board;
	private Player currentPlayer;
	private int numPlayers;
	private int numDice;
	private Random rand;
	private List<Card> remainingCards;
	private List<Player> players;
	private Scanner input;
	private Solution solution;
	private boolean playing;

	public Game(){
		// Initialise fields
		this.board = new Board();
		rand = new Random();
		this.players = new ArrayList<Player>();
		this.remainingCards = new ArrayList<Card>();
		
		play();	
	}
	
	/**
	 * Set up the game and start main loop
	 */
	public void play(){
		makeCards();
		makeSolution();
		input = new Scanner(System.in);
		System.out.println("How many players?");
		makePlayers(input.nextInt());
		deal();
		printHands();
		
		this.playing = true;
		currentPlayer = players.get(0);
		
		// Main loop
		while(playing){
			printOptions();
			String choice = input.next();
			input.nextLine(); // throw away the end of line character
		}
	}
	
	public void printOptions(){
		System.out.println(currentPlayer+"'s turn. Options:");
		System.out.println("8: move North, 6: move East, 2: move South, 4: move West");
		System.out.println("V: view hand, S: make suggestion, A: make Accusation");
	}
	
	public int roll(){
		int dice = 0;
		for(int i = 0; i < this.numDice; i++){
			dice += rand.nextInt(7);
		}
		return dice;
	}

	/**
	 * Shuffle the cards and deal them one by one to each player.
	 */
	public void deal(){
		Collections.shuffle(remainingCards);
		int p = 0;
		for(Card c : remainingCards){
			players.get(p).giveCard(c);
			if(p == numPlayers-1){
				p = 0;
			}else{ 
				p++; 
			}
		}
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
	 * TEST METHODS - DELETE BEFORE SUBMITTING***************
	 */
	public void printHands(){
		for(Player p : players){
			System.out.println(p.getName()+": "+p.handToString());
		}
	}

	/**
	 * Private methods for setting up the game below here
	 */

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
		int w = rand.nextInt(9);
		int c = 9 + rand.nextInt(7);
		int r = 15 + rand.nextInt(10);
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
		System.out.println(solution); // TEST - DELETE THIS****************
	}

	/**
	 * String arrays for card names.
	 */
	private String[] weaponNames = { "Rope", "Candlestick", "Knife", "Pistol", "Baseball Bat", "Dumbbell", "Trophy", "Poison", "Axe" };
	private String[] characterNames = { "Kasandra Scarlett", "Jack Mustard", "Diane White", "Jacob Green", "Eleanor Peacock", "Victor Plum" };
	private String[] roomNames = { "Spa", "Theatre", "Living Room", "Conservatory", "Patio", "Hall", "Kitchen", "Dining Room", "Guest House", "Pool" };

}