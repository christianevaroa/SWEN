package Cluedo;

import org.junit.Test;
import static org.junit.Assert.*;

import junit.framework.TestCase;

public class JUnitTests extends TestCase {
	
	/**
	 * Player tests 
	 */
	
	@Test
	public void testGiveAndHolds_1(){
		Player p = new Player("Bob");
		Weapon pistol = new Weapon("Pistol");
		Room spa = new Room("Spa");
		p.giveCard(new Weapon("Pistol"));
		p.giveCard(new Room("Spa"));
		assertTrue(p.holds(pistol));
		assertTrue(p.holds(spa));
	}
	@Test
	public void testGiveAndHolds_2(){
		Player p = new Player("Bob");
		Weapon pistol = new Weapon("Pistol");
		Room spa = new Room("Spa");
		p.giveCard(new Weapon("Pistol"));
		assertTrue(p.holds(pistol));
		assertFalse(p.holds(spa));
	}
	
	@Test
	public void testEmptyHandHolds(){
		Player p = new Player("Bob");
		assertFalse(p.holds(new Weapon("Pistol")));
	} 

	/**
	 * Solution, accusation and suggestion tests
	 */
	
	@Test
	public void testCorrectAccusation(){
		Weapon weap = new Weapon("Axe");
		Character chara = new Character("Kasandra Scarlett");
		Room room = new Room("Patio");
		Solution sol = new Solution(weap, chara, room);
		Accusation acc = new Accusation(chara, room, weap);
		assertTrue(sol.checkAccusation(acc));
	}
	
	@Test
	public void testIncorrectAccusation(){
		Weapon weap = new Weapon("Axe");
		Character chara = new Character("Kasandra Scarlett");
		Room room = new Room("Patio");
		Solution sol = new Solution(weap, chara, room);
		Accusation acc = new Accusation(chara, room, new Weapon("Rubber Chicken"));
		assertFalse(sol.checkAccusation(acc));
	}
	
	@Test
	public void testSuggestionReturns(){
		Weapon weap = new Weapon("Axe");
		Character chara = new Character("Kasandra Scarlett");
		Room room = new Room("Patio");
		Suggestion sug = new Suggestion(chara, room, weap);
		assertEquals(new Weapon("Axe"), sug.getWeapon());
		assertEquals(new Character("Kasandra Scarlett"), sug.getCharacter());
		assertEquals(new Room("Patio"), sug.getRoom());
	}
	
}
