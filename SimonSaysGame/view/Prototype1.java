import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Prototype1
{
   private JFrame  mainFrame;
   private JLabel  title;
   private JLabel  highs;
   private JLabel  scoreE;
   private JLabel  scoreM;
   private JLabel  scoreH;
   private JButton easy;
   private JButton medium;
   private JButton hard;

    public Prototype1()
    {
     mainFrame = new JFrame();
     mainFrame.setPreferredSize(new Dimension(500, 500));


     mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     title = new JLabel("Simon Says");
     title.setFont(new Font("Serif", Font.PLAIN, 30));
     title.setForeground(Color.BLUE);
     title.setHorizontalAlignment(JLabel.CENTER);
     title.setVerticalAlignment(JLabel.TOP);
     
     JPanel easyPanel = new JPanel();
     JPanel mediumPanel = new JPanel();
     JPanel hardPanel = new JPanel();
     
     easy = new JButton("Easy");
     easy.setForeground(Color.GREEN);
     easyPanel.add(easy);
     easyPanel.setBounds(75,50,80,80);
     
     medium = new JButton("Medium");
     medium.setForeground(Color.YELLOW);
     mediumPanel.add(medium);
     mediumPanel.setBounds(200,50,80,80);
     
     hard = new JButton("Hard");
     hard.setForeground(Color.RED);
     hardPanel.add(hard);
     hardPanel.setBounds(325,50,80,80);
     
     highs = new JLabel("High Scores");
     highs.setFont(new Font("Serif", Font.PLAIN, 16));
     highs.setBounds(200,70,80,80);
     
     for(int i=0; i<5;i++){
        scoreE = new JLabel("Name 0");
        scoreE.setBounds(95,90+25*i,100,100);
        mainFrame.add(scoreE);
     }
     
     for(int i=0; i<5;i++){
        scoreM = new JLabel("Name 0");
        scoreM.setBounds(220,90+25*i,100,100);
        mainFrame.add(scoreM);
     }
     
     for(int i=0; i<5;i++){
        scoreH = new JLabel("Name 0");
        scoreH.setBounds(345,90+25*i,100,100);
        mainFrame.add(scoreH);
     }
     
     mainFrame.add(highs);
     mainFrame.add(easyPanel);
     mainFrame.add(mediumPanel);
     mainFrame.add(hardPanel);
     mainFrame.add(title);
     mainFrame.setVisible(true);
     
     mainFrame.pack();


   }
}
