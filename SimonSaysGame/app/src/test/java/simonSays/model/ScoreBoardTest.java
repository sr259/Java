import model.HighScore;
import model.ScoreBoard;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class ScoreBoardTest{
	
	private HighScore highScore1;
	private HighScore highScore2;
	private HighScore highScore3;
	private HighScore highScore4;
	private ScoreBoard board;

	
	@Before
	public void setUp() throws Exception 
	{

		highScore1 = new HighScore("bob", 10);   
		highScore2 = new HighScore("User 123", 17);  
		highScore3 = new HighScore("Cat", 3); 
		highScore4 = new HighScore("Doge", 1); 
		board = new ScoreBoard();
		board.addScore(highScore1);
		board.addScore(highScore2);
		board.addScore(highScore3);
		board.addScore(highScore4);
						
	}
	
	@After 
	public void tearDown() {
		board = null;
		highScore1 = null;
		highScore2 = null;
		highScore3 = null;
		highScore4 = null;

	}
	
	@Test
	public void testAddingHighScore()
	{
		assertNotNull("scoreboard should not be null", board);
	}
	
	@Test
	public void testGettingScore()
	{
		ArrayList<HighScore> scoreBoard = board.getScores();
		assertEquals("scoreBoard[0] should contain highscore with score 10", 10, scoreBoard.get(0).getScore());
		assertEquals("scoreBoard[1] should contain highscore with name USer 123", "User 123", scoreBoard.get(1).getName());
	}
	
	@Test
	public void testSortingBoard()
	{
		ArrayList<HighScore> sortedBoard = board.sortScore();;
		assertEquals("scoreBoard[0] should contain highscore with score 17", 17, sortedBoard.get(0).getScore());
		assertEquals("scoreBoard[0] should contain name User 123", "User 123", sortedBoard.get(0).getName());
		assertEquals("scoreBoard[1] should contain highscore with score 10", 10, sortedBoard.get(1).getScore());
		assertEquals("scoreBoard[1] should contain name bob", "bob", sortedBoard.get(1).getName());
		assertEquals("scoreBoard[2] should contain highscore with score 3", 3, sortedBoard.get(2).getScore());
		assertEquals("scoreBoard[1] should contain name Cat", "Cat", sortedBoard.get(2).getName());
		assertEquals("scoreBoard[3] should contain highscore with score 1", 1, sortedBoard.get(3).getScore());
		assertEquals("scoreBoard[1] should contain name Doge", "Doge", sortedBoard.get(3).getName());
	}
	
	
	

	


}

