import java.time.LocalDate;
import java.util.ArrayList;

// Class to represent festival and use different visitors to get fields
public class Festival extends EventType{
    private final String name;
    private final Location location;
    private final LocalDate date;
    private final double tickerPrice;
    private final int numOfTickets;
    private final ArrayList<EventType> events;

    public Festival(String name, ArrayList<EventType> events) {
        super(name,events);
        this.name = name;
        this.events = events;

        LocationVisitor locationVisitor = new LocationVisitor();
        locationVisitor.visitEvents(this);
        this.location = locationVisitor.getLocation();

        DateVisitor dateVisitor = new DateVisitor();
        dateVisitor.visitEvents(this);
        this.date = dateVisitor.getLocalDate();

        PriceVisitor priceVisitor = new PriceVisitor();
        priceVisitor.visitEvents(this);
        this.tickerPrice = priceVisitor.getPrice();

        NumVisitor numVisitor = new NumVisitor();
        numVisitor.visitEvents(this);
        this.numOfTickets = numVisitor.getNum();


    }

    public ArrayList<EventType> getEvents() {
        return new ArrayList<>(this.events);
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public Location getLocation() {
        return this.location;
    }

    @Override
    public LocalDate getDate() {
        return this.date;
    }

    @Override
    public double getPrice() {
        return this.tickerPrice;
    }

    @Override
    public int getNumTickets() {
        return this.numOfTickets;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visitEvents(this);
    }
    public static void main(String[] args){
        ArrayList<VIP> vs = new ArrayList<>();
        Concert c1 = new Concert("!",Location.BellCentre,LocalDate.now(),12.0,4,"2",vs);
        Concert c2 = new Concert("!",Location.BellCentre,LocalDate.now(),88.0,3,"2",vs);
        ArrayList<EventType> eventTypes = new ArrayList<>();
        eventTypes.add(c1);
        eventTypes.add(c2);
        Festival f1 = new Festival("o",eventTypes);
        System.out.println(f1.getNumTickets());
        System.out.println(f1.getLocation());
    }
}
