import java.time.LocalDate;

// add rating for Screening Class and set/get methods for the field
public class Screening extends EventType{
    private Rating rating;
    public Screening(String name, Location location, LocalDate date, double tickerPrice, int numOfTickets, Rating rating) {
        super(name, location, date, tickerPrice, numOfTickets);
        this.rating = rating;
    }
    public Screening(String name, LocalDate date){
        super(name,date);
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }

    public Rating getRating() {
        return rating;
    }

    @Override
    public double getPrice() {
        return super.getPrice();
    }

    @Override
    public int getNumTickets() {
        return super.getNumTickets();
    }

    @Override
    public LocalDate getDate() {
        return super.getDate();
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public Location getLocation() {
        return super.getLocation();
    }
    @Override
    public void accept(Visitor visitor) {
        visitor.visitScreening(this);
    }
}
