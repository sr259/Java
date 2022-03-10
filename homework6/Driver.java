import java.awt.Color;
import java.io.IOException;

public class Driver
{
    public static void main(String []args)
    {
        // code imported from homework instructions
        Random2D r = new Random2D(-6,0);
        Constant2D c = new Constant2D(5);
        double []coeff = {1};
        int []exponent = {2};
        Polynomial p = new Polynomial(coeff, exponent);
        Plot2D myPlot = new Plot2D();
        
        //plotting functions with colors
        myPlot.plot(p);
        myPlot.plot(c, Color.BLUE);
        myPlot.plot(r, Color.GREEN);
        
        //try and catch statement with saving image and closing myPlot
        try
        {
            myPlot.saveImage("functions.png");

        }
        catch(IOException e)
        {
            System.out.println(e);
        }
        myPlot.close();
    }
    
}
