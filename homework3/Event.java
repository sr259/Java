import java.util.Calendar;
import java.util.GregorianCalendar;
public abstract class Event
{
    protected GregorianCalendar startTime = null;
    protected GregorianCalendar endTime = null;
    protected Contact organizer = new Contact();
    protected String description;

    public abstract void schedule(GregorianCalendar dateTime);
    
    public boolean overlaps(Event event)
    {
        Event first, second;
        boolean overlap_found = true;
        if (this.startTime.compareTo(event.startTime) < 0)
        {
            first = this;
            second = event;
        }
        else
        {
            first = event;
            second = this;
        }
        if (first.endTime.compareTo(second.startTime) <= 0)
        {
            overlap_found = false;
        }
        return overlap_found;
    }
    public String toString()
    {
        String val;
        if (this.startTime != null || this.endTime != null)
        {
            String startYear = String.valueOf(this.startTime.get(Calendar.YEAR));
            String startMonth = String.valueOf(this.startTime.get(Calendar.MONTH)+1);
            String startDay = String.valueOf(this.startTime.get(Calendar.DAY_OF_MONTH));
            String startHour = String.valueOf(this.startTime.get(Calendar.HOUR_OF_DAY));
            String startMinute = String.valueOf(this.startTime.get(Calendar.MINUTE));
            
            String endYear = String.valueOf(this.endTime.get(Calendar.YEAR));
            String endMonth = String.valueOf(this.endTime.get(Calendar.MONTH)+1);
            String endDay = String.valueOf(this.endTime.get(Calendar.DAY_OF_MONTH));
            String endHour = String.valueOf(this.endTime.get(Calendar.HOUR_OF_DAY));
            String endMinute = String.valueOf(this.endTime.get(Calendar.MINUTE));
            
            
            val = description + " starts " + startYear + "/" +startMonth +"/" +startDay+ " " +startHour +":"+startMinute +" end "+ endYear + "/"+ endMonth +"/" +endDay+ " " +endHour +":"+ endMinute; 
        }
        else
        {
            val = description + ", not scheduled";
        }
        return val;
    }
    public int getDay()
    {
       return this.startTime.get(Calendar.DAY_OF_MONTH);
    }
}
    

