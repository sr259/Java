package model;

import model.*;
import java.util.ArrayList;
import java.util.Random;
public class RandomPattern extends SquareList
{
   
   private int max;
   public ArrayList<SquarePanel> currentPattern = new ArrayList<SquarePanel>();
   private Random rand;
   private int i=0;
   private ArrayList<SquarePanel> possibilities;

   
   public void startingPattern(SquareList squareList){
      System.out.println("size of squareList is" + squareList.getList().size());
      ArrayList<SquarePanel> possibilities= squareList.getList();
      Random rand = new Random();
      int ranNum=rand.nextInt(possibilities.size());
      this.currentPattern.add(possibilities.get(ranNum));
   }
   
   public ArrayList<SquarePanel> getCurrentPattern()
   {
       return this.currentPattern;
    }

}
