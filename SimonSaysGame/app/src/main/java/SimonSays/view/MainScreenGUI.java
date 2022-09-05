package view;

import model.*;
import controller.*;


import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

import java.awt.event.*;
import java.io.*;


public class MainScreenGUI implements MainScreenUserInterface
{
   private JFrame  mainFrame;
   private JLabel  title;
   private JLabel  highs;
   private JLabel  scoreE;
   private JLabel  scoreM;
   private JLabel  scoreH;

   private difficultyButton easy= new difficultyButton(75,50,"Easy");
   private difficultyButton medium= new difficultyButton(200,50,"Hedium");
   private difficultyButton hard= new difficultyButton(325,50,"Hard");
   private JButton easyScores;
   private JPanel easySBoard;
   private JButton mediumScores;
   private JPanel mediumSBoard;
   private JButton hardScores;
   private JPanel hardSBoard;


   public MainScreenGUI() 
   {
      mainFrame = new JFrame();
      mainFrame.setPreferredSize(new Dimension(500, 500));
   
   
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      title = new JLabel("Simon Says");
      title.setFont(new Font("Serif", Font.PLAIN, 30));
      title.setForeground(Color.BLUE);
      title.setHorizontalAlignment(JLabel.CENTER);
      title.setVerticalAlignment(JLabel.TOP);
      
      easyScores = new JButton("E-Score");
      easySBoard = new JPanel();
      easyScores.setForeground(Color.GREEN);
      easySBoard.add(easyScores);
      easySBoard.setBounds(75, 200, 80, 80);
      
      mediumScores = new JButton("M-Score");
      mediumSBoard = new JPanel();
      mediumScores.setForeground(Color.YELLOW);
      mediumSBoard.add(mediumScores);
      mediumSBoard.setBounds(200, 200, 80, 80);
      
      hardScores = new JButton("H-Score");
      hardSBoard = new JPanel();
      hardScores.setForeground(Color.RED);
      hardSBoard.add(hardScores);
      hardSBoard.setBounds(325, 200, 80, 80);
      
      JPanel boardButtonPanel = new JPanel();
      boardButtonPanel.setBounds(200,150,350,100);
      boardButtonPanel.add(easySBoard);
      boardButtonPanel.add(mediumSBoard);
      boardButtonPanel.add(hardSBoard);
      boardButtonPanel.setLocation(65,180);
      
      easy.changeColor(Color.GREEN);
      medium.changeColor(Color.YELLOW);
      hard.changeColor(Color.RED);
        
      highs = new JLabel("High Scores");
      highs.setFont(new Font("Serif", Font.PLAIN, 20));
      highs.setForeground(Color.BLUE);
      highs.setBounds(190,90,150,150);
      mainFrame.add(highs);
      mainFrame.add(easy.getPanel());
      mainFrame.add(medium.getPanel());
      mainFrame.add(hard.getPanel());
      mainFrame.add(boardButtonPanel);
      mainFrame.add(title);
      mainFrame.setVisible(true);
      mainFrame.pack();
   }
   
   
   
   public void setEasy(ActionListener l)
   {
      easy.getButton().addActionListener(l);
      
   }
   
   public void setEasyScore(ActionListener l)
   {
      easyScores.addActionListener(l);
      
   }
   
   public void setMediumScore(ActionListener l)
   {
      mediumScores.addActionListener(l);
      
   }
   
   public void setHardScore(ActionListener l)
   {
      hardScores.addActionListener(l);
      
   }
 
   public void setMedium(ActionListener l)
   {
      medium.getButton().addActionListener(l);
      
   }
   
   public void setHard(ActionListener l)
   {
      hard.getButton().addActionListener(l);
   }
   
   
   public JFrame getFrame(){
      return mainFrame;
   }
   

}
