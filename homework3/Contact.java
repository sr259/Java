public class Contact
{
	public String name = "";
	public int phoneNumber = 0;
	public Contact()
	{
		this.name= null;
		this.phoneNumber = 0;
	}
	public Contact(String name, int phoneNumber)
	{
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public int getPhone()
	{
		return this.phoneNumber;
	}
}
