import java.util.ArrayList;

public class Driver
{
   public static int testAdd()
   {
      Catalog catalog = new Catalog();
      int numErrors = 0;
      boolean status = false;
      Book book = new Book("Introduction to Java", "Kate", "Holdener");
      String bookId = catalog.add(book);
      ArrayList<String> foundBooks = catalog.search("Kate");

      if (foundBooks.size() != 1)
      {
         System.out.println("Error: search method should have found one book");
         numErrors++;
      }
      //test to see if the Ids work correctly when cataloging a book in a catalog
      Book book2 = new Book("Introduction to Java", "Kate", "Holdener");
      catalog.add(book2);
      foundBooks = catalog.search("Kate");
      if (foundBooks.get(0) == foundBooks.get(1))
      {
		  System.out.println("Error: the ids of the books are the same");
          numErrors++;
      }
      
      return numErrors;
   }
   
   public static int testRemove()
   {
	  Catalog catalog = new Catalog();
	  int numErrors = 0;
	  Book book = new Book("x","y","z");
	  String bookId = catalog.add(book);
	  catalog.remove(bookId);
	  if (catalog.getBook(bookId) != null){
		  System.out.println("Error: catalog remove method should return null when the id is inputed in a removed function.");
		  numErrors++;
	  }
	  return numErrors;
   }

   public static int testCheckout()
   {
	   Catalog catalog = new Catalog();
	   int numErrors = 0;
	   Book book = new Book("x","y","z");
	   String bookId = catalog.add(book);
	   if (catalog.checkout(bookId) != true)
	   {
		   System.out.println("Error: checkout method should return true when the book is not checked out.");
		   numErrors++;
	   }
	   //test to try to check out the same book 
	   if (catalog.checkout(bookId) != false)
	   {
		   System.out.println("Error: checkout method should return false when the book is already checked out.");
		   numErrors++;
	   }
	   return numErrors++;
	   }
	   
	public static int testCheckin()
	{
	   Catalog catalog = new Catalog();
	   int numErrors = 0;
	   Book book = new Book("x","y","z");
	   String bookId = catalog.add(book);
	   catalog.checkout(bookId);
	   //test to try checking the book back in
	   if (catalog.checkin(bookId) != true)
	   {
		   System.out.println("Error: checkin method should return true when the book is checked out.");
		   numErrors++;
	   }
	   //trying to checking in a book that is already checked in
	   if (catalog.checkin(bookId) !=false)
	   {
		   System.out.println("Error: checkin method should return false when the book is already checked in.");
		   numErrors++;
	   }
	   return numErrors++;
   }
   
   public static int testSearch()
   {
	   Catalog catalog = new Catalog();
	   int numErrors = 0;
	   Book book = new Book("Test","Simon","Rostkowski");
	   String bookId = catalog.add(book);
	   ArrayList<String> foundBooks = catalog.search("Test");
	   String foundBookId = foundBooks.get(0);
	   //test whether or not search works for title, firstName, and lastName
	   if (catalog.getBook(foundBookId) != book)
	   {
		   System.out.println("Error: using the title of the book, the search method should return the corresponding book.");
		   numErrors++;
	   }
	   foundBooks = catalog.search("Simon");
	   foundBookId = foundBooks.get(0);
	   if (catalog.getBook(foundBookId) != book)
	   {
		   System.out.println("Error: using the authors first name, the search method should return the corresponding book.");
		   numErrors++;
	   }
	   foundBooks = catalog.search("Rostkowski");
	   foundBookId = foundBooks.get(0);
	   if (catalog.getBook(foundBookId) != book)
	   {
		   System.out.println("Error: using the authors last name, the search method should return the corresponding book.");
		   numErrors++;
	   }
	   //test whether or not search will find items that are similar
	   Book book2 = new Book("Test", "Simon", "Rostkowski");
	   String book2Id = catalog.add(book2);
	   foundBooks = catalog.search ("Simon");
	   if (foundBooks.size() !=2)
	   {
		   System.out.println("Error: when there are more than one similar books, the search method should return more than one Id");
		   numErrors++;
		  }
	   
	   return numErrors;
   }
	   
   public static int testgetBook()
   {
	   //testing if Catalog's getBook method works if the Id corresponds to the right book
	  Catalog catalog = new Catalog();
      int numErrors = 0;
      boolean status = false;
      Book book = new Book("x", "y", "z");
      String bookId = catalog.add(book);   
      String wrongId = "19";
      
      if (catalog.getBook(bookId) != book)
      {
         System.out.println("Error: catalog getBook method should return correct book");
         numErrors++;
      }
      //testing getBook method when the wrong Id is inputed
      if (catalog.getBook(wrongId) != null){
		  System.out.println("Error: catalog getBook method should return null when the id doesn't correspond to any book");
		  numErrors++;
	  }
      return numErrors;
   }

   public static void main(String []args)
   { 
      int numErrors = 0;
      numErrors += testAdd();
      numErrors+= testgetBook();
      numErrors+= testRemove();
      numErrors += testCheckin();
      numErrors += testCheckout();
      numErrors += testSearch();

      // TODO: Call more test methods here

      if (numErrors > 0)
      {
         System.out.println("Fix your errors");
      }
      else
      {
         System.out.println("No errors were found");
      }
   }
}
