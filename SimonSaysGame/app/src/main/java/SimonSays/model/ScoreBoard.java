package model;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
public class ScoreBoard implements Iterable<HighScore>
{

    public ArrayList<HighScore> highScores = new ArrayList<HighScore>();
    public ArrayList<String> highScoreNames = new ArrayList<String>();
    public ScoreBoard(){
       this.highScores=highScores;
    }

    public ScoreBoard(ArrayList<HighScore> list){
       this.highScores=list;
    }
    
    public void addScore(HighScore score)
    {
        this.highScores.add(score);
    }
    
    public ArrayList<HighScore> getScores()
    {
        return this.highScores;
    }

    public void sortScore() //sort the score board from greatest to smallest
    {
      ArrayList<HighScore> sortedScores = new ArrayList<HighScore>();
      sortedScores = this.highScores;
      boolean done = false;
      HighScore temp, hs;
      while(!done)
      {
         done = true;
         for (int i = 0; i < this.highScores.size(); i++)
         {
            hs = sortedScores.get(i);
            int id = i;
            for (int j = i+1; j < sortedScores.size();j++)
            {
               if(sortedScores.get(j).getScore() < hs.getScore())
               {
                  hs = sortedScores.get(j);
                  id = j;
               }
            }
            temp = sortedScores.get(i);
            sortedScores.set(i, hs);
            sortedScores.set(id,temp);
         }
          
         Collections.reverse(sortedScores);
      
      }
        this.highScores = sortedScores;
   }
    
   @Override 
   public Iterator<HighScore> iterator()
   {
      return highScores.iterator();
   }
}
