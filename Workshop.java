import java.time.LocalDate;
import java.util.ArrayList;
// add prerequisties for Workshop Class and set/get methods for the field
public class Workshop extends EventType{
    private ArrayList<Workshop> prerequisties;
    public Workshop(String name, Location location, LocalDate date, double tickerPrice, int numOfTickets, ArrayList<Workshop> prerequisties) {
        super(name, location, date, tickerPrice, numOfTickets);
        this.prerequisties = prerequisties;
    }

    public Workshop(String name, LocalDate date){
        super(name,date);
    }

    public void setPrerequisties(ArrayList<Workshop> prerequisties) {
        this.prerequisties = prerequisties;
    }

    public ArrayList<Workshop> getPrerequisties() {
        return prerequisties;
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
        visitor.visitWorkshop(this);
    }
}
