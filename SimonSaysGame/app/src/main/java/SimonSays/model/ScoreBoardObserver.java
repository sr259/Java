package model;


import java.util.Iterator;

public interface ScoreBoardObserver
{
   public void update(Iterator<HighScore> ScoreBoardIterator);
}
