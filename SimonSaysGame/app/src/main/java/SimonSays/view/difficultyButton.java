package view;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionListener;
public class difficultyButton{
   
   
   protected int squares;
   protected JPanel panel;
   protected JButton button;
   
   public difficultyButton(int x, int y, String name)
   {
      this.button = new JButton(name);
      this.panel = new JPanel();
      panel.add(button);
      panel.setBounds(x, y, 80, 80);
   }
   
   public void changeColor(Color color){
       this.button.setForeground(color);
    }
    
   
   public JPanel getPanel()
   {
      return this.panel;
   }
   
   public JButton getButton(){
      return this.button;
   }
}
