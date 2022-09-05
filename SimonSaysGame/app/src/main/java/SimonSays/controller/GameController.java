package controller;

import model.*;
import view.*;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.lang.Math;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.GridLayout;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class GameController 
{
   public int finalScore;
   private Color colorList[]= new Color[]{Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW,Color.CYAN,
      Color.MAGENTA,Color.ORANGE,Color.PINK,Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW,Color.CYAN,
      Color.MAGENTA,Color.ORANGE,Color.PINK};
   private int colorIndex=0;
   private Timer timer;
   private TimerTask patternGenerator;
   public SquareList squareList = new SquareList();
   private int ranPatIndex = 0;
   private RandomPattern randomPattern;
   private HighScore NWS;
   public MainScreenUserInterface mui;
   private SimonSaysUserInterface ui;
   private InputNameUserInterface nui;
   public ObservableScoreBoard board = new ObservableScoreBoard();

   public GameController(InputNameUserInterface nui,MainScreenUserInterface mui,SimonSaysUserInterface ui, SquareList squareList, RandomPattern pattern, int finalScore, ObservableScoreBoard board)
   {
      this.mui=mui;
      this.ui = ui;
      this.finalScore=finalScore;
      this.squareList=squareList;
      this.randomPattern = pattern;
      this.nui = nui;
      this.board = board;
      
   }

   public void startGame(double buttons)
   {
      this.finalScore=0;
      this.ui.changeScore(finalScore);
      this.squareList.clearList();
      SquareList list = this.ui.difficultySelect(buttons);
      this.randomPattern.startingPattern(list);
      Timer timerDis= new Timer();
      TimerTask patternDelay= new TimerTask() {
        public void run(){
          ui.displayRandomPattern(randomPattern);
        }
      };
      timerDis.schedule(patternDelay,2000);
      addAL();
   }

   private void compareSquare(SquarePanel square)  
   {
      System.out.println(this.randomPattern.getCurrentPattern().size());
      if (square == this.randomPattern.getCurrentPattern().get(ranPatIndex))
      {
         ranPatIndex++;
         System.out.println("you succeed, now index is: " + ranPatIndex);
      
      
         if (ranPatIndex == this.randomPattern.getCurrentPattern().size())
         {
            this.randomPattern.startingPattern(this.ui.getList());
            this.ui.displayRandomPattern(randomPattern);
            ranPatIndex = 0;
            this.finalScore++;
            this.ui.changeScore(this.finalScore);
         }

      }
      else {
         System.out.println("you clicked on the wrong button");
         this.ui.getFrame().setVisible(false);
         this.ui.getFrame().dispose();
         int temp = this.finalScore;
         this.randomPattern.getCurrentPattern().clear();
         this.nui.submission(new ActionListener(){
            public void actionPerformed(ActionEvent e){
               if (nui.getSearchTerm().length() < 10)
               {
                    HighScore NWS= new HighScore(nui.getSearchTerm(),temp);
                    scoreEntry(NWS);
               }
               
            }
         });
         this.nui.setScore(this.finalScore);
         this.nui.getFrame().setVisible(true);
      }
   }
   
   private void addAL()
   {
      this.squareList = this.ui.getList();
      for (SquarePanel s: squareList.getList())
      {
         s.getButton().addActionListener(new ActionListener() {
            @Override
               public void actionPerformed(ActionEvent e) {
                  if(s.getStatus()){
                     compareSquare(s);
                  }
                  else{
                     System.out.println("Wait");
                  }
               }
         });
      }
   }

  public void scoreEntry(HighScore score){
      String fileName = "";
      int level = 0;
      ArrayList<HighScore> tempBoard = new ArrayList<HighScore>();
      try{
      if(this.squareList.getList().size() == 4){
         fileName = "ScoresEasy.csv";
         level = 1;

      }
      if(this.squareList.getList().size()==9){
         fileName = "ScoresMedium.csv";
         level = 2;

      }
      if(this.squareList.getList().size()==16){
         fileName = "ScoresHard.csv";
         level = 3;

      }
      
             BufferedWriter writer =new BufferedWriter(new FileWriter(fileName));
             ArrayList<String> contents = new ArrayList<String>();
             board.addScore(score);
             for(int i = 0; i<5;i++)
             {
                 String s = board.getScores().get(i).getName() + "," + board.getScores().get(i).getScore()+ "\r";
                 writer.write(s, 0, s.length());
                 writer.flush();
             }
             writer.close();
             this.nui.getFrame().setVisible(false);
             mui.getFrame().setVisible(true);
             
         }
     catch(Exception e){};
   }
     

   public ArrayList<String> getFileContents()
   {
       try{
           BufferedReader reader = new BufferedReader(new FileReader("Scores.txt"));
           ArrayList<String> contents = new ArrayList<String>();
           int counter = 0;
           while (counter!=30)
           {
              contents.add(reader.readLine());
              counter++;
           }
           reader.close();
           return contents;
       }catch(Exception e){return null;}
   }
}

