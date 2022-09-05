package view;
import model.*;

import javax.swing.*;
import java.awt.Dimension;
import java.util.Iterator;

public class Board implements ScoreBoardObserver
{
   private JFrame frame;
   private JPanel mainPanel;

   public Board()
   {
      frame = new JFrame("HighScore");
      frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
      frame.setPreferredSize(new Dimension(500, 200));
      mainPanel = new JPanel();
      mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
      frame.add(mainPanel);
      frame.pack();
      frame.setVisible(false);
   }
   
   public JFrame getFrame()
   {
      return this.frame;
   }

   @Override
   public void update(Iterator<HighScore> ScoreBoardIterator)
   {
      mainPanel.removeAll();
      int i = 1;
      while(ScoreBoardIterator.hasNext())
      {
         HighScore hs = ScoreBoardIterator.next();
         JLabel score = new JLabel(i + ". " + hs.getName()+"  "+ hs.getScore());
         mainPanel.add(score);
         i+= 1;
         if (i == 6)
         {
            break;
         }
      }

      mainPanel.revalidate();
      mainPanel.repaint();
   }
}
