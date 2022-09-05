import model.Square;
import model.Pattern;

import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;

public class SquarePatternTest{
	
	private Square square1;
	private Square square2;
	private Pattern pattern;

	
	@Before
	public void setUp() throws Exception 
	{

		square1 = new Square();
		square2 = new Square();  
		pattern = new Pattern(); 
						
	}
	
	@After 
	public void tearDown() {
		square1 = null;
		square2 = null;
		pattern = null;

	}
	
	@Test
	public void testaddSquare()
	{
		pattern.add(square1);
		assertNotNull("pattern should not be null", pattern);
	}
	
	@Test
	public void testSquareInPattern()
	{
		square1.setLightSpeed(10);
		square2.setLightSpeed(10);
		
		pattern.add(square1);
		pattern.add(square2);
		pattern.getPattern();
		ArrayList<Square> squares = pattern.getPattern();
		for (Square s: squares)
		{
			assertEquals("squares should have light speed of 10", 10, s.getLightSpeed());
		}

	}
	



}
