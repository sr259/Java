import model.HighScore;
import model.Score;

import org.junit.*;
import static org.junit.Assert.*;

public class HighScoreTest{
	
	private HighScore highScore;
	private Score score;

	
	@Before
	public void setUp() throws Exception 
	{
		score = new Score();
		score.addToScore();
		score.addToScore();
		score.addToScore();

		highScore = new HighScore("bob", score.getScore());   
						
	}
	
	@After 
	public void tearDown() {
		score = null;
		highScore = null;

	}
	
	@Test
	public void testGettingName()
	{
		assertEquals("highScore should return bob", "bob", highScore.getName());
	}
	
	@Test
	public void testAlterName()
	{
		highScore.setName("Bob");
		assertEquals("highScore should return Bob instead of bob", "Bob", highScore.getName());
	}
	
	
	@Test
	public void testSettingScore()
	{
		highScore.setScore(100);
		assertEquals("score returned should be 100", 100, highScore.getScore());
	}
	


}
