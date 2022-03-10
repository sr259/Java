public class LibraryItem{
    public String title;
    public int year;
    
    public LibraryItem()
    {
        this.title = "N/A";
        this.year = 0;
    }
        
    public LibraryItem(String title, int year){
        this.title = title;
        this.year = year;
    }
    public String getTitle(){
        return this.title;
    }
    public int getYear(){
        return this.year;
    }
    boolean matches(String keyword)
    {
        String sYear = String.valueOf(this.year);
        if (keyword.equals(this.title) || keyword.equals(sYear))
        {
            return true;
        }else
        {
            return false;
        }
    }
}
