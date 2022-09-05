import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Prototype2
{
   private JFrame  mainFrame;
   private JLabel  title;
   private JLabel  gameScore;
   private JButton submit;
   private JTextField name;
   
    public Prototype2()
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
     submit = new JButton("Submit Name");
     submit.setForeground(Color.BLUE);
     nameEntry.add(submit, BorderLayout.EAST);
     nameEntry.setBounds(200,200,100,100);
     mainFrame.add(nameEntry);
     
     gameScore = new JLabel("Your Score: 0");
     gameScore.setFont(new Font("Serif", Font.PLAIN, 16));
     gameScore.setBounds(200,100,100,100);
     
     mainFrame.add(gameScore);
     mainFrame.add(title);
     mainFrame.setVisible(true);
     
     mainFrame.pack();


   }
}
