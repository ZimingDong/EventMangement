import java.time.LocalDate;
import java.util.ArrayList;
// add vips for Concert Class and set/get methods for the field
public class Gala extends EventType{
    private ArrayList<VIP> VIPs;
    public Gala(String name, Location location, LocalDate date, double tickerPrice, int numOfTickets, ArrayList<VIP> VIPs) {
        super(name, location, date, tickerPrice, numOfTickets);
        this.VIPs = VIPs;
    }
    public Gala(String name, LocalDate date){
        super(name,date);
    }

    public int numOfVIPs(){
        return this.VIPs.size();
    }

    public void setVIPs(ArrayList<VIP> VIPs) {
        this.VIPs = VIPs;
    }

    public ArrayList<VIP> getVIPs() {
        return VIPs;
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
        visitor.visitGala(this);
    }
}
