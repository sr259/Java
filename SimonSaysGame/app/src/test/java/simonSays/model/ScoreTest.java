import model.Score;

import org.junit.*;
import static org.junit.Assert.*;

public class ScoreTest{
	
	private Score score;

	
	@Before
	public void setUp() throws Exception 
	{

		score = new Score();   
						
	}
	
	@After 
	public void tearDown() {
		score = null;

	}
	
	@Test
	public void testScoreStartAtZero()
	{
		assertEquals("score should be 0 at start", 0, score.getScore());
	}
	
	@Test
	public void testScoreAdding()
	{
		score.addToScore();
		assertEquals("score should be at 1", 1, score.getScore());
	}
	
	@Test
	public void testScoreClearing()
	{
		score.addToScore();
		score.addToScore();
		score.addToScore();
		score.setToZero();
		assertEquals("score should be at 0", 0, score.getScore());
	}
	


}
