/**
 * Polynomial class using dense representation
 */

public class Polynomial implements Function2D
{
   private double []coeff;

   /**
    * The length of coeff and exponents array must be the same
    */
   public Polynomial(double []coeff, int []exponents)
   {
       int maxDegree = findMax(exponents);
       this.coeff = new double[maxDegree+1];
       for (int i = 0; i <= maxDegree; i++)
       {
           this.coeff[i] = 0;
       }

       for (int i = 0; i < coeff.length; i++)
       {
           this.coeff[exponents[i]] = coeff[i];
       }
   }

   /**
    * Finds the largest value in the exponents array
    * @return the largest value in exponents array
    */
   private int findMax(int []exponents)
   {
       int maxDegree = 0;
       for (int i = 0; i < exponents.length; i++)
       {
           if (exponents[i] > maxDegree)
           {
               maxDegree = exponents[i];
           }
       }
       return maxDegree;
   }

   /**
    * Returns the largest degree of this polynomail
    */
   public int getMaxDegree()
   {
       return coeff.length-1;
   }

   /**
    * Returns the coefficeint of the given degree
    */
   public double getCoefficient(int d)
   {
       double c = 0;
       if (d <= coeff.length)
       {
           c = coeff[d];
       }
       return c;
   }

   @Override
   public double eval(double x)
   {
      double result = 0;
      for (int i = 0; i < coeff.length; i++)
      {
         if (coeff[i] != 0)
         {
            result+= coeff[i] * Math.pow(x,i);
         }
      }
      return result;
   }
}

