public class CatalogItem{
    private LibraryItem libraryItem = new LibraryItem();
    private String id;
    private boolean availability;

    public CatalogItem(LibraryItem libraryItem, String id, boolean availability)
    {
        this.libraryItem = libraryItem;
        this.id= id;
        this.availability = availability;
    }
        
    public LibraryItem getLibraryItem()
    {
        return this.libraryItem;
    }
    
    public String getId()
    {
        return this.id;
    }
    
    public boolean isAvailable()
    {
        return this.availability;
    }
    
    public void setAvailable()
    {
        this.availability = true;
    }

    public void setUnavailable()
    {
        this.availability = false;

    }

}
