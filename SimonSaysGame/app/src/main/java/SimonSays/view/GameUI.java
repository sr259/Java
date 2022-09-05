package view;

import model.*;
import controller.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.util.Timer;
import java.util.TimerTask;


public class GameUI implements SimonSaysUserInterface
{
   private JFrame  mainFrame;
   private JLabel  score;
   private Graphics2D g;
   private Color colorList[]= new Color[]{Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW,Color.CYAN,
      Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW,Color.CYAN,
      Color.MAGENTA,Color.ORANGE,Color.PINK};
   private int colorIndex=0;
   private int sqclear=0;
   public SquareList squareList = new SquareList();
   private int i=0;
   
   
      public GameUI()
      {
         mainFrame = new JFrame("Score: 0");
         mainFrame.setPreferredSize(new Dimension(500, 500));
         mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         mainFrame.setVisible(true);
         mainFrame.pack();
      }
      
      public void changeScore(int scoreFinal)
      {
         mainFrame.setTitle("Score: " + scoreFinal);
      }
      
      public void addPanel(SquarePanel panel){
         mainFrame.add(panel.getPanel());
         mainFrame.add(new JPanel()); // DO NOT REMOVE
         mainFrame.invalidate();
         mainFrame.validate();
         mainFrame.repaint();
         mainFrame.pack();
      }

      public SquareList difficultySelect(double buttons){
         for(int sqclear=0; sqclear<squareList.getList().size();sqclear++){
            squareList.getList().remove(0);
         }
         int colorIndex=0;
         double rows=Math.sqrt(buttons);
         JPanel buttonPanel = new JPanel();
         JPanel panel = new JPanel();
         panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
         buttonPanel.setLayout(new GridLayout((int)rows,(int)rows));
         
         for (int index = 0; index < buttons; index++)
         {
             SquarePanel square = new SquarePanel();
             square.changeColor(colorList[colorIndex]);
             colorIndex++;
             JButton button=square.getButton();
             buttonPanel.add(button);
             square.setSize(400/buttons,400/buttons);
             this.squareList.addSquare(square);
         }
         panel.add(buttonPanel);
         getFrame().add(panel);
         return squareList;
      }
  
      public void displayRandomPattern(RandomPattern ranPat){
      
      for(SquarePanel panel:squareList.getList()){
         panel.unClickable();
      }
      System.out.println("ranPat list has " + ranPat.getCurrentPattern().size() + " items. (displayRandomPattern)");
      Timer timer= new Timer();
      JFrame temp = this.mainFrame;
      TimerTask patternGenerator= new TimerTask() {
         public void run()
         {
             
             if (i == ranPat.getCurrentPattern().size()-1)
             {
                 timer.cancel();
             }
             ranPat.getCurrentPattern().get(i).flash();
             ranPat.getCurrentPattern().get(i).unFlash();
             i++;
             if (i == ranPat.getCurrentPattern().size())
             {
                 i = 0;
             }
             System.out.println("flash");
         }
      };
      timer.scheduleAtFixedRate(patternGenerator,2000,1000);
      
      Timer timerDel= new Timer();
      TimerTask squareDelay= new TimerTask() {
         public void run(){
            for(SquarePanel panel:squareList.getList()){
               panel.clickable();
            }
         }
      };
      timerDel.schedule(squareDelay,2000+(1000*ranPat.getCurrentPattern().size()));
      }
      

      public JFrame getFrame()
      {
          return mainFrame;
      }
      
      public SquareList getList()
      {
        return squareList;
      }
      
      public void clearList(){
         squareList.clearList();
      }
      
      public void addAL(JButton button, ActionListener l)
      {
         button.addActionListener(l);
      }
}
