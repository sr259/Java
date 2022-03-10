import java.util.ArrayList;

public class Catalog{
	private int idNum = 0;
	ArrayList<CatalogItem> catalog = new ArrayList<CatalogItem>();
	public Catalog()
	{
		this.catalog = catalog;
	}
	public String add(Book book)
	{
		idNum +=1;
		String sId = String.valueOf(idNum);
		CatalogItem item = new CatalogItem(book,sId,true);
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
		for (CatalogItem i: catalog)
		{
			Book book = new Book();
			book = i.getBook();
			if (book.getAuthorFirstName() == searchTerm)
			{
				results.add(i.getId());
			}
			if (book.getAuthorLastName() == searchTerm)
			{
				results.add(i.getId());
			}
			if (book.getTitle() == searchTerm)
			{
				results.add(i.getId());
			}
		}
		return results;
	}
	public Book getBook(String id)
	{
		for (CatalogItem i: catalog)
		{
			if(i.getId() == id)
			{
				return i.getBook();
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
