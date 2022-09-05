package model;
import java.util.ArrayList;

public class ObservableScoreBoard extends ScoreBoard
{
   protected ArrayList<ScoreBoardObserver> observers;

   public ObservableScoreBoard()
   {
      super();
      this.observers = new ArrayList<ScoreBoardObserver>();
   }

   public ObservableScoreBoard(ArrayList<HighScore> items)
   {
      super(items);
      this.observers = new ArrayList<ScoreBoardObserver>();
      System.out.println("this board contains the following, size is " + items.size());
      for(HighScore hs: items)
      {
         System.out.println(hs.getName() + " " + hs.getScore());
      }
   }
   
   public void addScoreBoardObserver(ScoreBoardObserver observer)
   {
      this.observers.add(observer);
      observer.update(this.iterator());
   }
    
   public void notifyObservers()
   {
      for (ScoreBoardObserver observer: this.observers)
      {
         observer.update(this.iterator());
      }
   }
 
   @Override
   public void addScore(HighScore score)
   {
      super.addScore(score);
      sortScore();
      notifyObservers();
   }
}
      
