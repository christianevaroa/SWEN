package Cluedo;

import java.util.ArrayList;
import java.util.List;

public class Player {
	private String name;
	private List<Card> hand;
	
	public Player(String name){
		this.name = name;
		this.hand = new ArrayList<Card>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public void giveCard(Card c){
		hand.add(c);
	}
	
	public boolean holds(Card c){
		if(c == null){ return false; }
		return hand.contains(c);
	}
	
}
