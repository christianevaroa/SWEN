package Cluedo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	private Player currentPlayer;
	public int numPlayers;
	private List<Card> remainingCards;
	public List<Player> players;
	private Scanner input;
	private Solution solution;

	public Game(){
		makeCards();
		this.players = new ArrayList<Player>();
		input = new Scanner(System.in);
		System.out.println("How many players?");
		makePlayers(input.nextInt());
		makeSolution();
	}

	private void makePlayers(int numPlayers){
		input = new Scanner(System.in);
		for(int i = 1; i <= numPlayers; i++){
			System.out.println("Enter name for player "+i+":");
			players.add(new Player(input.next()));
		}
		this.numPlayers = numPlayers;
		input.close();
	}

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
		for(int i = 0; i < characterNames.length; i++){
			remainingCards.add(new Room(roomNames[i]));
		}
	}

	private void makeSolution() {
		// To begin with, weapons occupy 0-8 in remainingCards,
		// characters are 9-14, and rooms are 15-24.
		int w = (int)Math.random() * 8;
		int c = 9 + (int)(Math.random() * 14);
		int r = 15 + (int)(Math.random() * 24);
		Weapon sWeapon = (Weapon)remainingCards.get(w);
		Character sCharacter = (Character)remainingCards.get(c);
		Room sRoom = (Room)remainingCards.get(r);
		
		solution = new Solution(sWeapon, sCharacter, sRoom);
	}

	private String[] weaponNames = { "Rope", "Candlestick", "Knife", "Pistol", "Baseball Bat", "Dumbbell", "Trophy", "Poison", "Axe" };
	private String[] characterNames = { "Kasandra Scarlett", "Jack Mustard", "Diane White", "Jacob Green", "Eleanor Peacock", "Victor Plum" };
	private String[] roomNames = { "Spa", "Theatre", "Living Room", "Conservatory", "Patio", "Hall", "Kitchen", "Dining Room", "Guest House", "Pool" };
}