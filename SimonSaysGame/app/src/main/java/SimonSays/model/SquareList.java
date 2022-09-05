package model;

import model.*;
import java.util.ArrayList;
import java.util.Random;
public class SquareList
{
   
   public ArrayList<SquarePanel> possibleSquares = new ArrayList<SquarePanel>();
   
   public void addSquare(SquarePanel square){
      this.possibleSquares.add(square);
   }
   
   public ArrayList<SquarePanel> getList(){
      return this.possibleSquares;
   }
   
   public void clearList()
   {
	   this.possibleSquares.clear();
   }
}
