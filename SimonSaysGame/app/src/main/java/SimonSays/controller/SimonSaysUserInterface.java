package controller;
import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;
public interface SimonSaysUserInterface
{
   public SquareList difficultySelect(double buttons);
   public void changeScore(int scoreFinal);
   public void displayRandomPattern(RandomPattern ranPat);
   public SquareList getList();
   public JFrame getFrame();
}
