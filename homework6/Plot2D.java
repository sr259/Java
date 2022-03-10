import javax.swing.*;
import javax.imageio.ImageIO;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.GeneralPath;
import java.awt.image.BufferedImage;


import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Plot2D extends JPanel
{ 
    private double minX, minY, maxX, maxY;
    private double stepSize;
    private int scale;
    private GeneralPath path;
    private GeneralPath xCoord;
    private GeneralPath yCoord;
    private ArrayList<GeneralPath> paths = new ArrayList<GeneralPath>();
    private ArrayList<Color> colors = new ArrayList<Color>();

    private JFrame frame;  

    public Plot2D()
    {
       this.minX=-10;
       this.minY=-10;
       this.maxX=10;
       this.maxY=10;
       this.stepSize = 0.01;
       this.scale = 40;
       setPanelSize();

       // initialize the coordinates
       setCoordinates();

       // creating a top-level container
       frame =new JFrame(); 
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       // 'this' object is Plot2D, which extends JPanel, which 
       // eventually extends Component. Therefere, we can add 'this'
       // to the frame
       frame.add(this);

       frame.pack(); 
       // make the top-level container visible
       frame.setVisible(true);
    }

    private void setPanelSize()
    {
        int x_dim = (int)(maxX-minX)*this.scale;
        int y_dim = (int)(maxY-minY)*this.scale;
        this.setPreferredSize(new Dimension(x_dim, y_dim));
    }

    /**
     * Creates the xCoord and yCoord objects, which
     * will be drawn on the plot as the x and y coordinates
     */
    private void setCoordinates()
    {
        xCoord = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 2);
        xCoord.moveTo(0, scale*maxY);
        xCoord.lineTo(scale *(maxX-minX), scale*maxY);

        yCoord = new GeneralPath(GeneralPath.WIND_EVEN_ODD, 2);
        yCoord.moveTo(scale*(0-minX), 0);
        yCoord.lineTo(scale*(0-minX), scale*(maxY-minY));
    }

    /**
     * Create the path object that corresponds the the Function2D passed
     * as the argument. The path starts at this.minX and end at this.maxX
     */
    public void plot(Function2D f)
    {
       int numPoints = (int)((maxX-minX)/stepSize);
       this.path = new GeneralPath(GeneralPath.WIND_EVEN_ODD, numPoints);
       path.moveTo(scale*0, scale*(maxY-f.eval(minX)));
       this.paths.add(this.path);
       this.colors.add(Color.RED);
       
       double current = minX;
       while (current <= maxX)
       {
          current = current + stepSize;
          double yValue = f.eval(current);
          path.lineTo(scale*(current-minX), scale*(maxY-yValue));
       }
       // re-draw the picture
       this.repaint();
    }
    
    // Plot function with color parameter
    public void plot(Function2D f, Color color)
    {
       int numPoints = (int)((maxX-minX)/stepSize);
       this.path = new GeneralPath(GeneralPath.WIND_EVEN_ODD, numPoints);
       path.moveTo(scale*0, scale*(maxY-f.eval(minX)));
       this.paths.add(this.path);
       this.colors.add(color);

       double current = minX;
       while (current <= maxX)
       {
          current = current + stepSize;
          double yValue = f.eval(current);
          path.lineTo(scale*(current-minX), scale*(maxY-yValue));
       }
       // re-draw the picture
       this.repaint();
    }

    @Override
    public void paint(Graphics g)
    {
       super.paint(g);
       Graphics2D g2 = (Graphics2D)g;

       // draw the coordinates in black
       g.setColor(Color.BLACK);
       g2.draw(this.xCoord);
       g2.draw(this.yCoord);

       // draws each function with the corresponding color
       for(int i = 0; i< colors.size(); i++)
       {
           g.setColor(this.colors.get(i));
           g2.draw(this.paths.get(i));
       }
    
    }

    /**
     * Saves the current contents of the top-level container to a file
     * in png format
     */
    public void saveImage(String fileName) throws IOException
    {
       Container cont = frame.getContentPane();
       BufferedImage image = new BufferedImage(
          cont.getWidth(), 
          cont.getHeight(), 
          BufferedImage.TYPE_INT_RGB);
       Graphics2D graphics2D = image.createGraphics();
       frame.paint(graphics2D);
       ImageIO.write(image, "png", new File(fileName));
    }

    /**
     * Closes the frame window
     */
    public void close()
    {
       frame.setVisible(false);
       frame.dispose();
    }

}
  
