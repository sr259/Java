import org.junit.*;
import static org.junit.Assert.*;
import java.util.ArrayList;


public class CatalogTest
{
    Book book1 = new Book("BookTitle",2022,"fName","lName","Publisher","Isbn");
    Book book2 = new Book("BookTitle",2022,"fName","lName","Publisher","Isbn");
    ArrayList<CatalogItem> catalogItems = new ArrayList<CatalogItem>();
    CatalogItem catalogBook1, catalogBook2;
    Catalog test;
    boolean removed, checked;
    LibraryItem libItem;
    

    //Testing the add method
    @Test
    public void doesAdd()
    {
        test = new Catalog();
        test.add(book1);
        ArrayList<String> search = test.search("fName"); //since search method works, I used it to determine the amount in the test catalog
        assertTrue("failure - add method didn't add book", search.size() == 1);
    }
    
    @Test
    public void addingTwoSimilarItems()
    {
        test = new Catalog();
        test.add(book1);
        test.add(book1);
        ArrayList<String> search = test.search("fName");
        assertTrue("failure - didn't add same book", search.size() == 2);
        
    }
    
    //remove method tested
    @Test
    public void doesRemove()
    {
        catalogBook1 = new CatalogItem(book1,"0",true);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        removed = test.remove("0");
        assertTrue("failure - does not remove item", removed);
    }
    
    @Test
    public void removingTwice()
    {
        catalogBook1 = new CatalogItem(book1,"0",true);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        test.remove("0");
        removed = test.remove("0");
        assertFalse("failure - the item should not of been removed twice", removed);
    }
    @Test
    public void removingWithWrongId()
    {
        catalogBook1 = new CatalogItem(book1,"0",true);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        removed = test.remove("99");
        assertFalse("failure - removes item with wrong ID", removed);
    }
    
    @Test
    public void removingAfterCheckin()
    {
        catalogBook1 = new CatalogItem(book1,"0",false);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        test.checkin("0");
        removed = test.remove("0");
        assertTrue("failure - item should have been removed after being checked in", removed);
            
    }
    
    @Test
    public void removingAfterCheckOut()
    {
        catalogBook1 = new CatalogItem(book1,"0",true);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        test.checkout("0");
        removed = test.remove("0");
        assertFalse("failure - item should not have been removed after being checked out", removed);
    
    }
    
    //Search method tests
    @Test
    public void doesSearchWithFirstName()
    {
        catalogBook1 = new CatalogItem(book1,"0",true);
        catalogBook2 = new CatalogItem(book2,"1",true);
        catalogItems.add(catalogBook1);
        catalogItems.add(catalogBook2);
        test = new Catalog(catalogItems);
        ArrayList<String> search = test.search("fName");
        assertTrue("failure - did not return given results with similar first names", search.size()==2);
    }
        
    @Test
    public void doesSearchWithLastName()
    {
        catalogBook1 = new CatalogItem(book1,"0",true);
        catalogBook2 = new CatalogItem(book2,"1",true);
        catalogItems.add(catalogBook1);
        catalogItems.add(catalogBook2);
        test = new Catalog(catalogItems);
        ArrayList<String> search = test.search("lName");
        assertTrue("failure - did not return correct results with similar last names", search.size()== 2);
    }
    
    @Test
    public void doesSearchWithPublisher()
    {
        catalogBook1 = new CatalogItem(book1,"0",true);
        catalogBook2 = new CatalogItem(book2,"1",true);
        catalogItems.add(catalogBook1);
        catalogItems.add(catalogBook2);
        test = new Catalog(catalogItems);
        ArrayList<String> search = test.search("Publisher");
        
        assertTrue("failure - did not return correct results with similar Publisher names, returned " +  String.valueOf(search.size()) + " items." , search.size()== 2);
    }
        
    //tests the search methods unique id exception
    @Test
    public void isUniqueExceptionTest()
    {
        try
        {
        catalogBook1 = new CatalogItem(book1,"0",true);
        catalogBook2 = new CatalogItem(book2,"0",true);
        catalogItems.add(catalogBook1);
        catalogItems.add(catalogBook2);
        test = new Catalog(catalogItems);
        fail("IllegalArgumentException not thrown when two catalogItems with similar ids are inputted");
        }
        catch(IllegalArgumentException e)
        {
            assertEquals("IDs must be unique", e.getMessage());
        }
        
    }
    
    //Checkin and Checkout tests
    @Test
    public void doesCheckoutUncheckedItem()
    {
        catalogBook1 = new CatalogItem(book1,"0",true);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        checked = test.checkout("0");
        assertTrue("failure - does not check out unchecked out book", checked);
    }
    
    @Test
    public void checkingAnItemOutTwice()
    {
        catalogBook1 = new CatalogItem(book1,"0",true);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        test.checkout("0");
        checked = test.checkout("0");
        assertFalse("failure - checks out the same item out twice", checked);
    }
    
    @Test
    public void doesntCheckoutCheckedOutItem()
    {
        catalogBook1 = new CatalogItem(book1,"0",false);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        checked = test.checkout("0");
        assertFalse("failure - checks out an already checked out item", checked);
    }
    
    @Test
    public void doesCheckinCheckedOutItem()
    {
        catalogBook1 = new CatalogItem(book1,"0",false);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        checked = test.checkin("0");
        assertTrue("failure - doesn't checkin a checkedout item", checked);
        
    }
    
    @Test
    public void doesntCheckinCheckedInItem()
    {
        catalogBook1 = new CatalogItem(book1,"0",true);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        checked = test.checkin("0");
        assertFalse("failure - checks in a already checkin item", checked);
    }
    
    @Test
    public void checkingAnItemInTwice()
    {
        catalogBook1 = new CatalogItem(book1,"0",true);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        test.checkin("0");
        checked = test.checkin("0");
        assertFalse("failure - checks in the same item out twice", checked);
    }
    
    @Test
    public void checkingInAnEmptyCatalog()
    {
		test = new Catalog();
		checked = test.checkin("0");
		assertFalse("failure - checked in a non existing item", checked);
	}
	
	@Test
	public void checkingOutInAnEmptyCatalog()
	{
		test = new Catalog();
		checked = test.checkout("0");
		assertFalse("failure - checked out a non existing item", checked);
	}
    
    //tests for getLibraryItem
    @Test
    public void getsCorrectItem()
    {
		catalogBook1 = new CatalogItem(book1,"0",true);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        LibraryItem libItem = test.getLibraryItem("0");
        assertEquals("failure - does not return the correct item", book1, libItem);
    }
    
    @Test
    public void gettingItemFromEmptyCatalog()
    {
		test = new Catalog();
		libItem = test.getLibraryItem("0");
		assertEquals("failure - something was returned when catalog was empty", null, libItem);
	}
       
    @Test
    public void gettingCheckedoutItem()
    {
		catalogBook1 = new CatalogItem(book1,"0",true);
        catalogItems.add(catalogBook1);
        test = new Catalog(catalogItems);
        test.checkout("0");
        libItem = test.getLibraryItem("0");
        assertEquals("failure - did not return item when item was checked out", book1, libItem);
	}
        
	
}
