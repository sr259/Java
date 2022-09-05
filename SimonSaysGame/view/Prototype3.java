import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
public class Prototype3
{
   private JFrame  mainFrame;
   private JLabel  score;
   private Graphics2D g;
   private JButton sq1;
   private JButton sq2;
   private JButton sq3;
   private JButton sq4;
   
    public Prototype3()
    {
     mainFrame = new JFrame();
     mainFrame.setPreferredSize(new Dimension(500, 500));


     mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     score = new JLabel("Score: 0  ");
     score.setFont(new Font("Serif", Font.PLAIN, 30));
     score.setForeground(Color.BLUE);
     score.setHorizontalAlignment(JLabel.RIGHT);
     score.setVerticalAlignment(JLabel.TOP);
     
     
     JPanel square1 = new JPanel();
     sq1 = new JButton("BLUE");
     sq1.setForeground(Color.BLUE);
     square1.add(sq1,BorderLayout.SOUTH);
     square1.setBounds(125,325,100,100);

     mainFrame.add(square1);
     
     JPanel square2 = new JPanel();
     sq2 = new JButton("RED");
     sq2.setForeground(Color.RED);
     square2.add(sq2,BorderLayout.WEST);
     square2.setBounds(125,225,100,100);

     mainFrame.add(square2);
     
     JPanel square3 = new JPanel();
     sq3 = new JButton("YELLOW");
     sq3.setForeground(Color.YELLOW);
     square3.add(sq3,BorderLayout.EAST);
     square3.setBounds(225,225,100,100);

     mainFrame.add(square3);
     
     JPanel square4 = new JPanel();
     sq4 = new JButton("GREEN");
     sq4.setForeground(Color.GREEN);
     square4.add(sq4,BorderLayout.NORTH);
     square4.setBounds(225,325,100,100);

     mainFrame.add(square4);
     
     
      mainFrame.add(score);
      mainFrame.setVisible(true);
      mainFrame.pack();
    }
}
