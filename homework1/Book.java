public class Book{
	private String title;
	private String firstName;
	private String lastName;
	private int m   year;
	private String publisher;
	private String isbn;


	public Book(){
		this.title = "N/A";
		this.firstName = "N/A";
		this.lastName = "N/A";
	}
	public Book(String title, String firstName, String lastName){
		this.title = title;
		this.firstName = firstName;
		this.lastName = lastName;
		}
	public Book(String title, int year, String firstName, String lastName, String publisher, String isbn){
		this.title = title;
		this.year = year;
		this.firstName = firstName;
		this.lastName = lastName;
		this.publisher = publisher;
		this.isbn = isbn;
	}
	
	public String getTitle(){
		return this.title;
		}
	public String getAuthorFirstName(){
		return this.firstName;
		}
	public String getAuthorLastName(){
		return this.lastName;
		}
	public String toString(){
	String val = this.title + ", " + this.lastName + ", " + this.firstName;
	return val;
	}
}
