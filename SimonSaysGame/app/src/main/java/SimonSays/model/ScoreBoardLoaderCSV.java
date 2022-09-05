package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ScoreBoardLoaderCSV extends ScoreBoardLoader
{
   private String fileName;

   public ScoreBoardLoaderCSV(String fileName)
   {
      this.fileName = fileName;
   }

   public void loadItems() throws IOException 
   {
      // Read book definitions from file
      BufferedReader br = new BufferedReader(new FileReader(this.fileName));
      String line;
      while ( (line = br.readLine()) != null)
         {
            System.out.println("line is " + line);
            String[] parts = line.split(",");
            HighScore tempHS = new HighScore(parts[0], Integer.valueOf(parts[1]));
            this.scores.add(tempHS);
            System.out.println("first results size is " + this.scores.size());
            
         } 
      br.close();

   }

}
