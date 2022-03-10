import java.util.ArrayList;
import java.lang.IllegalArgumentException;
public class Catalog{
    private int idNum = 0;
    ArrayList<CatalogItem> catalog = new ArrayList<CatalogItem>();
    public Catalog()
    {
        this.catalog = catalog;
    }
    public Catalog(ArrayList<CatalogItem> items) throws IllegalArgumentException
    {
        this.catalog = items;
        ArrayList<String> temp = new ArrayList<String>();
        for(CatalogItem i : items)
        {
            if(temp.contains(i.getId()))
            {
                throw new IllegalArgumentException("Ids are not unique");
            }
            temp.add(i.getId());
        }
    }
    public String add(LibraryItem libraryItem)
    {
        idNum +=1;
        String sId = String.valueOf(idNum);
        CatalogItem item = new CatalogItem(libraryItem,sId,true);
        this.catalog.add(item);
        return sId;
    }
    
    public boolean checkout(String id)
    {
        for (CatalogItem i : catalog)
        {
            if(i.getId() == id)
            {
                if (i.isAvailable() == true)
                {
                    i.setUnavailable();
                    return true;
                }
            }
        }
        return false;
    }
    public boolean checkin(String id)
    {
        for (CatalogItem i: catalog)
        {
            if(i.getId() == id)
            {
                if (i.isAvailable() == false)
                {
                    i.setAvailable();
                    return true;
                }
    
            }
        }
        return false;
    }

    public ArrayList<String> search(String searchTerm)
        {
        ArrayList<String> results = new ArrayList<String>();
        for (CatalogItem item: this.catalog)
        { 
            LibraryItem libItem = item.getLibraryItem();
    
            if(libItem.matches(searchTerm))
            {
                results.add(item.getId());
            }
        }
    
        return results;
        }

    public LibraryItem getLibraryItem(String id)
    {
        for (CatalogItem i: catalog)
        
        {
            if(i.getId() == id)
            {
                return i.getLibraryItem();
            }
                
        }
        return null;
    }
    public boolean remove(String id)
    {
        int counter = 0;
        for (CatalogItem i: catalog)
        {
            if(i.getId() == id)
            {
                if(i.isAvailable() == true)
                {
                    catalog.remove(counter);
                    return true;
                }
                }
            }
            counter +=1;
    return false;
    }
}
