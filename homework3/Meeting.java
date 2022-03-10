import java.util.Calendar;
import java.util.GregorianCalendar;
public class Meeting extends Event
{
	public int endBuffer;
	public Meeting(Contact contact, String description)
	{
		super.organizer = contact;
		super.description = description;
		
	}
	public void setEndBuffer(int num)
	{
		this.endBuffer = num;
	}
	public void schedule(GregorianCalendar dateTime)
	{
		if(dateTime != null){
			GregorianCalendar temp = new GregorianCalendar(
			dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH),
			dateTime.get(Calendar.DAY_OF_MONTH),dateTime.get(Calendar.HOUR_OF_DAY),
			dateTime.get(Calendar.MINUTE));
			super.startTime = dateTime;
			
			temp.add(Calendar.MINUTE, this.endBuffer);
			temp.add(Calendar.HOUR_OF_DAY, 1);
			
			super.endTime = temp;
			
			}
			else
			{
				super.startTime = null;
				super.endTime = null;
			}
		
		
	}
}
