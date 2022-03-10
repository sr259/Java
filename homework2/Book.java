public class Book extends LibraryItem{
    private String authorFirstName;
    private String authorLastName;
    private String publisher;
    private String isbn;


    public Book(){
        super();
        this.authorFirstName = "N/A";
        this.authorLastName = "N/A";
        this.publisher = "N/A";
        this.isbn = "N/A";
        
    }
    
    public Book(String title, int year, String firstName, String lastName, String publisher, String isbn){
        super(title,year);
        this.authorFirstName = firstName;
        this.authorLastName = lastName;
        this.publisher = publisher;
        this.isbn = isbn;
    }

    boolean matches(String keyword)
    {
        

        if(super.matches(keyword) || keyword.equals(this.authorFirstName) || keyword.equals(this.authorLastName) || keyword.equals(this.publisher) || keyword.equals(this.isbn))
        {
            return true;
        }
        else
        {
            return false;   
        }
    }
    
    public String getTitle()
    {
        return this.title;
    }
        
    public String getAuthorFirstName()
    {
        return this.authorFirstName;
    }
        
    public String getAuthorLastName()
    {
        return this.authorLastName;
    }
        
    public String getPublisher()
    {
        return this.publisher;
    }
    
    public String getIsbn()
    {
        return this.isbn;
    }
    public String toString()
    {
		String val = this.title + ", " + String.valueOf(this.year) + ", " + this.authorFirstName + ", " + this.authorLastName + ", " + this.publisher + ", " + this.isbn;
		return val;
    }
}
