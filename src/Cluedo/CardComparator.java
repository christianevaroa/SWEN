package Cluedo;

import java.util.Comparator;

public class CardComparator implements Comparator<Card> {

	@Override
	public int compare(Card c1, Card c2) {
		if(c1 instanceof Character){
			if(!(c2 instanceof Character))
				return -1;
		}
		else if(c1 instanceof Room){
			if(c2 instanceof Character)
				return 1;
			else if(c2 instanceof Weapon)
				return -1;
		}
		else if(c1 instanceof Weapon){
			if(!(c2 instanceof Weapon))
				return 1;
		}
		return 0;
	}

}
