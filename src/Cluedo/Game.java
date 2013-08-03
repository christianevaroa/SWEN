package Cluedo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game {

	private Board board;
	private Player currentPlayer;
	private int currentPlayerInt;
	private int numPlayers;
	private int numDice = 1;
	private Random rand;
	private List<Card> remainingCards;
	private List<Player> players;
	private Scanner input;
	private Solution solution;
	private boolean playing;
	private boolean canSuggest;
	private boolean canAccuse;
	private String charactersString = "1: Kasandra Scarlett, 2: Jack Mustard 3: Diane White, 4: Jacob Green, 5: Eleanor Peacock, 6: Victor Plum";
	private String roomsString = "1: Spa, 2: Theatre, 3: Living Room, 4: Conservatory, 5: Patio, 6: Hall, 7: Kitchen, 8: Dining Room, 9: Guest House, 10: Pool";
	private String weaponsString = "1: Rope, 2: Candlestick, 3: Knife, 4: Pistol, 5: Baseball Bat, 6: Dumbbell, 7: Trophy, 8: Poison, 9:Axe";

	public Game(){
		// Initialise fields
		this.board = new Board();
		this.rand = new Random();
		this.players = new ArrayList<Player>();
		this.remainingCards = new ArrayList<Card>();

		makeCards();
		makeSolution();
		input = new Scanner(System.in);
		System.out.println("How many players?");
		this.numPlayers = input.nextInt();
		makePlayers(this.numPlayers);
		deal();
		printHands();

		currentPlayerInt = 0;
		currentPlayer = players.get(currentPlayerInt);

		play();	
	}

	/**
	 * Set up the game and start main loop
	 */
	public void play(){
		this.playing = true;

		// Main loop
		while(playing){
			boolean done = false;
			// This while loop represents one turn
			while(!done){
				// Movement phase
				int movesLeft = roll();
				System.out.println(currentPlayer+"'s turn to move. "+currentPlayer+" rolled a "+movesLeft);
				while(movesLeft > 0){
					System.out.println("(N)orth, (E)ast, (S)outh, or (W)est? (F) to finish moving. "+movesLeft+" moves left.");
					String dir = input.nextLine().trim().toLowerCase();
					if(dir.equals("f")){ movesLeft = 0; }
					else if(move(dir)){
						movesLeft--;
					}
					else if(!move(dir)){
						System.out.println("Can't move in that direction or invalid input.");
					}
				}
				// Suggest/Accuse/End turn
				System.out.println(printOptions());
				String choice = input.nextLine().trim().toLowerCase();
				if(choice.equals("e")){ 
					endTurn();
					done = true;
				}
				else if(choice.equals("v")){
					System.out.println("Your cards:\n"+currentPlayer.handToString());
				}
				else if(choice.equals("s") && canSuggest){
					makeSuggestion();
					endTurn();
					done = true;
				}
				else if(choice.equals("a") && canAccuse){
					makeAccusation();
					endTurn();
					done = true;
				}
				else{
					System.out.println("Invalid choice.");
				}
			}
		}
	}
	/**
	 * Builds a String of your available options at the end of a turn.
	 * @return
	 */
	public String printOptions(){
		StringBuilder opts = new StringBuilder();
		opts.append("(V)iew hand, ");
		if(board.canSuggest(currentPlayer)){
			opts.append("Make a (S)uggestion, ");
			canSuggest = true;
		}
		if(board.canAccuse(currentPlayer)){
			opts.append("Make an (A)ccusation, ");
			canAccuse = true;
		}
		opts.append("(E)nd turn.");
		return opts.toString();
	}
	/**
	 * Make a suggestion.
	 * Suggestion is then checked against other players' hands and refuted if they have a matching card.
	 */
	public void makeSuggestion(){
		int choice = -1;
		while(choice < 0 || choice > characterNames.length){
			System.out.println("Choose a character:\n"+charactersString);
			choice = input.nextInt()-1;
		}
		Character sugChar = new Character(characterNames[choice]);
		choice = -1;
		while(choice < 0 || choice > roomNames.length){
			System.out.println("Choose a room:\n"+roomsString);
			choice = input.nextInt()-1;
		}
		Room sugRoom = new Room(roomNames[choice]);
		choice = -1;
		while(choice < 0 || choice > weaponNames.length){
			System.out.println("Choose a weapon:\n"+weaponsString);
			choice = input.nextInt()-1;
		}
	}
	/**
	 * Make an accusation.
	 * Accusation is then checked against other player's hands, 
	 * currentPlayer is removed from game if the accusation is refuted.
	 */
	public void makeAccusation(){

	}
	/**
	 * Resets fields for suggesting/accusing and moves to next player
	 */
	public void endTurn(){
		canSuggest = false;
		canAccuse = false;
		if(currentPlayerInt < numPlayers){
			currentPlayer = players.get(++currentPlayerInt);
		}
		else {
			currentPlayerInt = 0;
			currentPlayer = players.get(currentPlayerInt);
		}
	}
	/**
	 * Roll dice * this.numDice
	 * @return value rolled
	 */
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
		int w = rand.nextInt(10);
		int c = 9 + rand.nextInt(7);
		int r = 15 + rand.nextInt(11);
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