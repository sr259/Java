import model.Square;

import org.junit.*;
import static org.junit.Assert.*;

public class SquareTest{
	
	private Square square;

	
	@Before
	public void setUp() throws Exception 
	{

		square = new Square();   
						
	}
	
	@After 
	public void tearDown() {
		square = null;

	}
	
	@Test
	public void testLightUp()
	{
		assertFalse("square should return false", square.getLightStatus());
		square.lightUp();
		assertTrue("square should return true", square.getLightStatus());
	}
	
	@Test
	public void testLightUpStatus()
	{
		square.lightUp();
		square.lightOff();
		assertFalse("square should return false", square.getLightStatus());
	}
	
	@Test
	public void testLightSpeed()
	{

		assertEquals("light up speed should be 1", 1, square.getLightSpeed());
	}
	
	@Test
	public void testSetLightSpeed()
	{
		square.setLightSpeed(2);

		assertEquals("light up speed should be 2", 2, square.getLightSpeed());
	}
	
	@Test
	public void testClicked()
	{
		assertFalse("square should not be clicked at the beginning", square.getClickStatus());
		square.clicked();
		
		assertTrue("square should be clicked now", square.getClickStatus());
	}
	
	@Test
	public void testUnclicked()
	{

		square.clicked();
		square.unClicked();	
		assertFalse("square should be unclicked now", square.getClickStatus());
	}
	
	@Test
	public void testSize()
	{
		assertEquals("beginning size should be 50", 50, square.getSquareSize());

	}
	
	@Test
	public void testSetSize()
	{
		square.setSquareSize(100);
		assertEquals("beginning size should now be 100", 100, square.getSquareSize());

	}


}
