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

	public Game(){
		this.players = new ArrayList<Player>();
		input = new Scanner(System.in);
		System.out.println("How many players?");
		createPlayers(input.nextInt());
	}
	
	private void createPlayers(int numPlayers){
		input = new Scanner(System.in);
		for(int i = 1; i <= numPlayers; i++){
			System.out.println("Enter name for player "+i+":");
			players.add(new Player(input.next()));
		}
		this.numPlayers = numPlayers;
		input.close();
	}
}