import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.lang.ArrayIndexOutOfBoundsException;
import java.util.ArrayList;

public class Driver{
    public static void main(String []args){
        //if there is no argument given, then the text will print and the program will terminate
        try{
        if (args.length < 1)
        {
            System.out.println("Rerun program with filename on commandline");
            return;
        }
        
        String file = new String(); //make file variable equal inputted variable
        file = args[0];
        CatalogItemLoaderCSV catalogLoader = new CatalogItemLoaderCSV();//catalog loader
        ArrayList<CatalogItem> items = new ArrayList<CatalogItem>();
        ArrayList<String> ids = new ArrayList<String>();
        
        catalogLoader.loadItems(file); //catalogLoader receives the input from the file
        items = catalogLoader.getItems(); //items stores this input
        Catalog catalog = new Catalog(items);//catalog catalogs these items
        ids = catalog.search("Mike");//ids that correlate with the search term "Mike" are stored in ids
        System.out.println("Items with Mike"); 
        for (String id: ids) //prints correlating 
        {
            System.out.println(catalog.getLibraryItem(id));
        }}
        catch(IllegalArgumentException e)
        {
			System.out.println("Put a legal argument");
		}

    }
}
