import java.lang.Math;
public class Polynomial implements Function2D
{
    
    public int degrees[];
    public double coeff[];
    
    public Polynomial(double [] coefficients, int []exponents) throws IllegalArgumentException
    {

        if (coefficients.length != exponents.length)
        {
            throw new IllegalArgumentException("Array lengths need to be equal");
        }
        this.degrees = exponents;
        this.coeff = coefficients;  

    }
    
    @Override
    public double eval(double x)
    {
        double sum = 0;
        for (int i = 0; i< degrees.length; i++)
        {
            sum += coeff[i] * Math.pow(x,degrees[i]);
        }
        return sum;
    }
    
    public double getCoefficient(int degree)
    {
        double val = 0;
        for(int i = 0; i < degrees.length; i++)
        {
            if(degree == degrees[i])
            {
                val += coeff[i];
            }
        }
        return val;
    }
    
    public int getMaxDegree()
    {
        int max = 0;
        for(int i = 0; i < degrees.length; i++)
        {
            if (degrees[i] > max)
            {
                max = degrees[i];
            }
        }
        return max;
    }
}
