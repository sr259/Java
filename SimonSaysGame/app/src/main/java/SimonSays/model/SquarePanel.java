package model;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Timer;
import java.util.TimerTask;
import model.*;


public class SquarePanel 
{
    public JPanel squarePanel;
    public JButton sq;
    public Timer flashOff = new Timer();
    public Timer flashOn = new Timer();
    public boolean clickable;
    public Color prevColor;
    public boolean light = false;
    
    public SquarePanel()
    {
        this.squarePanel = new JPanel();
        this.sq = new JButton();
        this.sq.setOpaque(true);
        this.squarePanel.add(sq);
        this.clickable=false;
        
    }
    public void lightUp()
    {
        System.out.println("Lighting up square");
        if (this.light == false)
        {
            this.light = true;
        }
    }
    
    public void lightOff()
    {
        System.out.println("Square flashes off");
        if(this.light == true)
        {
            this.light = false;
        }
    }
    
    public Color getPrevColor()
    {
        return this.prevColor;
    }
    
    public void clickable()
    {
        this.clickable = true;
        
    }

    public void unClickable()
    {
        this.clickable = false;
    }
    
    public boolean getStatus(){
       return this.clickable;
    }
    
    public JButton getButton(){
       return this.sq;
    }
    
    public JPanel getPanel()
    {
       return this.squarePanel;
    }
    
    public void changeColor(Color color)
    {
       this.sq.setBackground(color);
    }
    
    public void squareMeasurements(double x, double y, double width, double height)
    {
       this.squarePanel.setBounds((int)x,(int)y,(int)width,(int)height);
    }
    public void setSize(double w, double h)
    {
       this.sq.setPreferredSize(new Dimension((int)w,(int)h));
    }
    
    public void flash()
    {
       this.prevColor = sq.getBackground();
       this.lightUp();
       this.sq.setBackground(Color.WHITE);
    }
    
    public void unFlash()
    {
      if (this.prevColor != null)
      {
         this.lightOff();
         JButton temp = this.sq;
         Color tempColor = this.prevColor;
         System.out.println("this.prevColor: " + this.prevColor.toString());
         System.out.println("temp color: " + tempColor.toString());
         TimerTask whiteOff = new TimerTask()
         {
            public void run()
            {
               temp.setBackground(tempColor);
            }
             
         };
         flashOff.schedule(whiteOff,500); 
               
       }
    } 
}


    
    
    


