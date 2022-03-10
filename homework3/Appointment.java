import java.util.Calendar;
import java.util.GregorianCalendar;
public class Appointment extends Event
{
	public int startBuffer;
	public Appointment(Contact contact, String description)
	{
		super.organizer =contact;
		super.description = description;
	}
	public void schedule(GregorianCalendar dateTime)
	{
		if(dateTime != null)
		{
		GregorianCalendar temp = new GregorianCalendar(
		dateTime.get(Calendar.YEAR), dateTime.get(Calendar.MONTH),
		dateTime.get(Calendar.DAY_OF_MONTH),dateTime.get(Calendar.HOUR_OF_DAY),
		dateTime.get(Calendar.MINUTE));
		
		dateTime.add(Calendar.MINUTE, -this.startBuffer);
		super.startTime = dateTime;
		temp.add(Calendar.HOUR_OF_DAY,1);
		super.endTime = temp;
		}
		else
		{
			super.startTime = null;
			super.endTime = null;
		}

	}
	public void setStartBuffer(int num)
	{
		this.startBuffer = num;
	}
	
	
}

