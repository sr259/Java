package controller;

import model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.Font;

public interface InputNameUserInterface
{
   public void submission(ActionListener l);
   public String getSearchTerm();
   public JFrame getFrame();
   public void setScore(int finalScore);
}
