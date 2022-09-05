package SimonSays;

import java.awt.event.*;

import model.*;
import controller.*;
import view.*;

import java.util.Timer;
import java.util.TimerTask;
import java.awt.event.*;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.io.IOException;


public class Driver
{
    public static void main(String []args)
    {
      
      MainScreenGUI main = new MainScreenGUI();
         
      RandomPattern generatedPattern= new RandomPattern();
      SquareList sqList= new SquareList();
      int finalScore=0;
      
      ScoreBoardLoaderCSV loaderBoardEasy = new ScoreBoardLoaderCSV("ScoresEasy.csv");
      ScoreBoardLoaderCSV loaderBoardMedium = new ScoreBoardLoaderCSV("ScoresMedium.csv");
      ScoreBoardLoaderCSV loaderBoardHard = new ScoreBoardLoaderCSV("ScoresHard.csv");
      
      try{
         loaderBoardEasy.loadItems();
         loaderBoardMedium.loadItems();
         loaderBoardHard.loadItems();
      }
      
      catch (IOException error)
         {
            System.out.println("Could not load the file");
            return;
         }
         ObservableScoreBoard eHighs = new ObservableScoreBoard(loaderBoardEasy.getScores());
         ObservableScoreBoard mHighs = new ObservableScoreBoard(loaderBoardMedium.getScores());
         ObservableScoreBoard hHighs = new ObservableScoreBoard(loaderBoardHard.getScores());
      
      main.setEasyScore(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            Board easyBoard = new Board();
            eHighs.addScoreBoardObserver(easyBoard);
            easyBoard.getFrame().setVisible(true);
         }
      });
   
      main.setMediumScore(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            Board mediumBoard = new Board();
            mHighs.addScoreBoardObserver(mediumBoard);
            mediumBoard.getFrame().setVisible(true); 
         }
      });
   
      main.setHardScore(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            Board hardBoard = new Board();
            hHighs.addScoreBoardObserver(hardBoard);
            hardBoard.getFrame().setVisible(true);
         }
      });
   
   
         
      
      main.setEasy(new ActionListener(){
        
         public void actionPerformed(ActionEvent e){
            GameUI game= new GameUI(); 
            InputNameGUI name = new InputNameGUI();
            GameController gameController = new GameController(name, main, game, sqList, generatedPattern, finalScore, eHighs);  
            gameController.startGame(4.0);
            main.getFrame().setVisible(false);
            main.getFrame().dispose();
         }
      });
      
      main.setMedium(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            ScoreBoardLoaderCSV loaderBoard = new ScoreBoardLoaderCSV("ScoresMedium.csv");
            System.out.println(2);
            GameUI game= new GameUI(); 
            InputNameGUI name = new InputNameGUI();
            GameController gameController = new GameController(name, main, game, sqList, generatedPattern, finalScore, mHighs);  
            gameController.startGame(9.0);
         }
      });
      
      main.setHard(new ActionListener(){
         public void actionPerformed(ActionEvent e){
            ScoreBoardLoaderCSV loaderBoard = new ScoreBoardLoaderCSV("ScoresHard.csv");
            System.out.println(3);
            GameUI game= new GameUI(); 
            InputNameGUI name = new InputNameGUI();
            GameController gameController = new GameController(name, main, game, sqList, generatedPattern, finalScore, hHighs);  
            gameController.startGame(16.0);
         }
      });
      
   }
   
   
}
