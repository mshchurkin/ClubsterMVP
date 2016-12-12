package ms.clubstermvp;

import java.io.Serializable;
import java.util.Date;

public class Event implements Serializable{
    public String eventName;
    public Date eventDate;

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }
}
