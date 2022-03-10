import org.junit.*;
import static org.junit.Assert.*;

public class PolynomialTest
{
    double coef1[] = {2,3,4};
    int exp1[] = {0,2,3};
    double coef2[] = {2,3,4};
    int exp2[] = {0,2,2};
    
    Polynomial test1 = new Polynomial(coef1,exp1);
    Polynomial test2 = new Polynomial(coef2,exp2);
    
    //Testing Eval functions
    @Test
    public void doesWork()
    {   
        double val = test1.eval(2);
        assertTrue( "failure - not working", 46.0 == val);
    }
    @Test
    public void doesWorkWithNegativeXVal()
    {   
        double val = test1.eval(-2);
        assertTrue( "failure - not working", -18.0 == val);
    }
    @Test
    public void worksWithNegativeCoef()
    {
		double coefNeg[] = {-1,-2,-3};
		Polynomial testNeg = new Polynomial(coefNeg, exp1);
		double val = testNeg.eval(2);
		assertTrue("failure - eval() doesnt work with negative coefficients", testNeg.eval(2) == -33.0);
	}
	@Test
    public void worksWithNegativeExp()
    {
		int expNeg[] = {-1,-2,-3};
		Polynomial testNeg = new Polynomial(coef1, expNeg);
		assertTrue("failure - eval() doesnt work with negative coefficients", testNeg.eval(2) == 2.25);
	}
    @Test
    public void worksWhichEverWay()
    {
		double coefA[] = {1,2,3};
		double coefB[] = {3,2,1};
		int expA[] = {1,2,3};
		int expB[] = {3,2,1};
		Polynomial testA = new Polynomial(coefA, expA);
		Polynomial testB = new Polynomial(coefB, expB);
		assertTrue("failure - eval() didnt work when inverting order of exponents and coefficients", testA.eval(2) == testB.eval(2));
	}
    
    //Testing Constructor
    @Test
    public void testsArrayLengthException()
    {
        try
        {
            double unequalCoef[] = {0,2};
            int unequalExp[] = {0,2,3};
            Polynomial test2 = new Polynomial(unequalCoef, unequalExp);
            fail("IllegalArgumentException was not caught when two array parameter lengths are not equal");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("Array lengths need to be equal", e.getMessage());
        }
    }
    
    //Tests for getCoefficient()
    @Test
    public void testingGetCoeff()
    {
        double val = test1.getCoefficient(3);
        assertTrue("failure - getCoefficient returned wrong value", val == 4);
    }
    @Test
    public void CoeffTestwithNonExistentDegree()
    {
        double val = test1.getCoefficient(99);
        assertTrue("failure - returned wrong value when degree not in array is inputted", val == 0);
    }
    @Test
    public void CoeffTestWithSimilarDegrees()
    {
        double val = test2.getCoefficient(2);
        assertTrue("failure - getCoefficient didn't account for exponents with similar", val == 7);
    }
    
    //Tests for getMaxDegree()
    @Test
    public void testingGetMaxDegree()
    {
        int val = test1.getMaxDegree();
        assertTrue("failure - getMaxDegree() returned wrong value", 3 == val);
    }
    @Test
    public void MaxDegreeTestWithSimilarExponents()
    {
        int val = test2.getMaxDegree();
        assertTrue("failure - getMaxDegree() didn't account for similar polynomial w/ similar exponents", 2 == val);
        
    }
    
}
