package Cluedo;

import java.lang.reflect.Method;

import org.junit.Test;
import static org.junit.Assert.*;

import junit.framework.TestCase;

public class JUnitTests extends TestCase {

	/**
	 * Game class tests
	 */
	
	@Test
	public void testCreatePlayers(){
		Game g = new Game();
		//assertEquals(g.numPlayers, 3);
		//assertEquals(g.players.size(), 3);
	}
	
	/**
	 * Player class tests 
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

}
