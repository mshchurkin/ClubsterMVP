package ms.clubstermvp;

import java.io.Serializable;

public class Club implements Serializable {

    String Name;
    Event[] eventArray;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public Event[] getEventArray() {
        return eventArray;
    }

    public void setEventArray(Event[] eventArray) {
        this.eventArray = eventArray;
    }
}
