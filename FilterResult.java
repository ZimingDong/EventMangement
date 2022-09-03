import java.util.ArrayList;

// Class for save result of different filter
public class FilterResult {
    private final ArrayList<EventType> aFilteredEvents;


    public FilterResult(ArrayList<EventType> aFilteredEvents) {
        this.aFilteredEvents = aFilteredEvents;
    }

    public ArrayList<EventType> getaFilteredEvents() {
        return new ArrayList<>(aFilteredEvents);
    }
}
