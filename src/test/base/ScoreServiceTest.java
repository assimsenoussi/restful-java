package base;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ScoreServiceTest {
	
	@Spy
	ScoreService service;
	
	@Test
	public void testGetLosses() {
		assertEquals(0, service.getLosses());
		assertEquals(0, service.increaseLosses());
		assertEquals(1, service.getLosses());
	}
	
	@Test
	public void testGetWins() {
		assertEquals(0, service.getWins());
		assertEquals(0, service.increaseWins());
		assertEquals(1, service.getWins());
	}
	
	@Test
	public void testGetTies() {
		assertEquals(0, service.getTies());
		assertEquals(0, service.increaseTies());
		assertEquals(1, service.getTies());
	}
	
	
	
	@Test
	public void testUpdate() {
		Random rdm = new Random();
		int wins = rdm.nextInt() , losses = rdm.nextInt(), ties = rdm.nextInt();
		service.update(wins, losses, ties);
		
		assertEquals(losses, service.getLosses());
		assertEquals(wins, service.getWins());
		assertEquals(ties, service.getTies());
	}


}
