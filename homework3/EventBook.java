import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
public class EventBook
{
	public ArrayList<Event> events = new ArrayList<Event>();
	
	public boolean addEvent(Event event, GregorianCalendar dateTime)
	{
		event.schedule(dateTime);
		if(events.size()!=0)
		{
			for (Event e: events)
			{
				if(e.overlaps(event))
				{
					event.schedule(null);
					return false;
				}
			}
		}
		this.events.add(event);
		return true;
	}
	public ArrayList<Event> getEventsForDate(GregorianCalendar date)
	{
		ArrayList<Event> temp = new ArrayList<Event>();
		for (Event e: events)
		{
			if(e.getDay() ==(date.get(Calendar.DAY_OF_MONTH)))
			{
				temp.add(e);
			}
		}
		return temp;
	}
}

