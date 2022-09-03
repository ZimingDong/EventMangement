import java.time.LocalDate;
import java.util.ArrayList;

// Class to represent an event
public class EventType implements Event {
    private String name;
    private Location location = Location.NotSet;
    private LocalDate date;
    private double tickerPrice=-99.9;
    private int numOfTickets=-99;

    public EventType(String name, Location location, LocalDate date, double tickerPrice, int numOfTickets) {
        this.name = name;
        this.location = location;
        this.date = date;
        this.tickerPrice = tickerPrice;
        this.numOfTickets = numOfTickets;
    }

    protected EventType(String name, ArrayList<EventType> events){
    }
    public EventType(String name,LocalDate date){
        this.name = name;
        this.date = date;
    }



    public void setLocation(Location location) {
        if(this.location == Location.NotSet){
            this.location = location;
        }else{return;}
    }


    public void setNumOfTickets(int numOfTickets) {
        if(this.numOfTickets==-99){
            this.numOfTickets = numOfTickets;
        }else{return;}
    }

    public void setTickerPrice(double tickerPrice) {
        if(this.tickerPrice==-99.9){
            this.tickerPrice = tickerPrice;
        }else{return;}
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

    }


}
