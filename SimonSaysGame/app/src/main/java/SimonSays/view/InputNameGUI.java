package view;

import model.*;
import controller.*;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.*;

public class InputNameGUI implements InputNameUserInterface
{
   private JFrame  mainFrame;
   private JLabel  title;
   private JPanel  gameScore;
   private JLabel text;
   private JButton submit;
   private JTextField name;
   
   public InputNameGUI()
   {
      mainFrame = new JFrame();
      mainFrame.setPreferredSize(new Dimension(500, 500));
   
      mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
      title = new JLabel("Game Over");
      title.setFont(new Font("Serif", Font.PLAIN, 30));
      title.setForeground(Color.BLUE);
      title.setHorizontalAlignment(JLabel.CENTER);
      title.setVerticalAlignment(JLabel.TOP);
        
      JPanel nameEntry = new JPanel();
      name = new JTextField();
      name.setPreferredSize(new Dimension(100, 30));
      nameEntry.add(name, BorderLayout.WEST);
      
      submit = new JButton("Submit Initials");
      submit.setForeground(Color.BLUE);
      nameEntry.add(submit, BorderLayout.EAST);
      nameEntry.setBounds(200,200,100,100);
      mainFrame.add(nameEntry);
      mainFrame.add(title);
      mainFrame.setVisible(false);
        
      mainFrame.pack();
   }
   
   public void submission(ActionListener l)
   {
      submit.addActionListener(l);
      
   }
   
   public String getSearchTerm()
   {
      return name.getText();
   }
   
   public JFrame getFrame()
   {
          return mainFrame;
   }
      
   public void setScore(int finalScore){
      JPanel gameScore = new JPanel();
      text = new JLabel("Your Score: "+ finalScore);
      text.setFont(new Font("Serif", Font.PLAIN, 24));
      text.setForeground(Color.BLUE);
      gameScore.setBounds(150,90,200,200);
      gameScore.add(text);
     
      mainFrame.add(gameScore);
      mainFrame.add(new JLabel());
   }
}
