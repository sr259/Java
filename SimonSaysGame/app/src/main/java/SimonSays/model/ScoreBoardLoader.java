package model;

import java.util.ArrayList;

public class ScoreBoardLoader
{
   protected ArrayList<HighScore> scores;

   public ScoreBoardLoader()
   {
      this.scores = new ArrayList<HighScore>();
   }

   public ArrayList<HighScore> getScores()
   {
      return this.scores;
   }
}

