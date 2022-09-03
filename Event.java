import java.time.LocalDate;

/*
Representation of a type of Event that can exist
 */
public interface Event {
    public String getName();
    public Location getLocation();
    public LocalDate getDate();
    public double getPrice();
    public int getNumTickets();

    public void accept(Visitor visitor);
}
