public class Movie extends LibraryItem
{
    private String producerFirstName;
    private String producerLastName;
    private String rating;
    
    public Movie(String title, int year, String firstName, String lastName, String rating)
    {
        super(title, year);
        this.producerFirstName = firstName;
        this.producerLastName = lastName;
        this.rating = rating;
    }
    boolean matches(String keyword)
    {
        
        if(super.matches(keyword) || keyword.equals(this.producerFirstName) || keyword.equals(this.producerLastName) || keyword.equals(this.rating))
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
    public String getPublisherFirstName()
    {
        return this.producerFirstName;
    }
    public String getPublisherLastName()
    {
        return this.producerLastName;
    }
    public String getRating(){
        return this.rating;
    }
    public String toString()
    {
    String val = this.title + ", " + String.valueOf(this.year) + ", " + this.producerFirstName + ", " + this.producerLastName + ", " + this.rating;
    return val;
    }

}
