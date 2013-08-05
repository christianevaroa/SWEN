package Cluedo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Player {

	private String name;
	private List<Card> hand;
	private boolean out = false;
	
	public Player(String name){
		this.name = name;
		this.hand = new ArrayList<Card>();
	}
	
	public String getName(){
		return this.name;
	}
	
	public void giveCard(Card c){
		this.hand.add(c);
	}
	
	public boolean holds(Card c){
		if(c == null){ return false; }
		return this.hand.contains(c);
	}
	
	public String handToString(){
		StringBuilder handString = new StringBuilder();
		for(Card c : this.hand){
			handString.append(c.getName() + ", ");
		}
		return handString.toString();
	}
	
	public boolean isOut(){
		return this.out;
	}
	
	public void lose(){
		this.out = true;
	}
	
	public void sort(){
		Collections.sort(this.hand, new CardComparator());
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
}
