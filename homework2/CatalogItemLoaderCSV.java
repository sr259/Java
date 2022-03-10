import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;
public class CatalogItemLoaderCSV
{   
    private ArrayList<CatalogItem> catalogItemLoader = new ArrayList<CatalogItem>();
    
    public ArrayList<CatalogItem> getItems()
    {
        return this.catalogItemLoader;
    }

    public void loadItems(String fileName)
    {
        Scanner reader= null;
        try
        {
            reader= new Scanner(new File(fileName));
            while(reader.hasNextLine())
            {
                String line = reader.nextLine();
                String arr[] = line.split(",");
                if(arr.length == 9 && arr[4].equals("book"))
                //there are 9 items in each book line and the fourth needs to be "book" for it to be correctly formatted
                {   
                    Book book=new Book(arr[2],Integer.parseInt(arr[3]),arr[5],arr[6],arr[7],arr[8]);
                    if(arr[1].equals("1"))//checks availability
                    {
                        CatalogItem item= new CatalogItem(book,arr[0],true);
                        this.catalogItemLoader.add(item);
                    }
                    else
                    {
                        CatalogItem item= new CatalogItem(book,arr[0],false);
                        this.catalogItemLoader.add(item);
                    }
                }
                if(arr.length == 8 && arr[4].equals("movie"))
                //a movies line has 8 items and the fourth needs to be "movie" for it to count as a correct format
                {
                    Movie movie=new Movie(arr[2],Integer.parseInt(arr[3]),arr[5],arr[6],arr[7]);
                    if(arr[1].equals("1"))//checks availability
                    {
                        CatalogItem item= new CatalogItem(movie,arr[0],true);
                        this.catalogItemLoader.add(item);
                    }
                    else
                    {
                        CatalogItem item= new CatalogItem(movie,arr[0],false);
                        this.catalogItemLoader.add(item);
                    }
                }
 
            }
            
            reader.close();
        }
        catch(IOException e)
        {
            System.out.println("Error: could not find or read file: "+fileName);
        }
    }

}
