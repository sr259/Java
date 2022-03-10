public class CatalogItem{
	private Book book = new Book();
	private String id;
	private boolean availability;

	public CatalogItem(Book book, String id, boolean availability){
		this.book = book;
		this.id= id;
		this.availability = availability;}
	public Book getBook(){
		return this.book;

			}
	public String getId(){
		return this.id;
	}
	public boolean isAvailable(){
		return this.availability;
		}
	public void setAvailable(){
		this.availability = true;
	}

	public void setUnavailable(){
		this.availability = false;

	}

}
