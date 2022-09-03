import java.time.LocalDate;
import java.util.ArrayList;

// add artist and vips for Concert Class and set/get methods for the field
public class Concert extends EventType{
    private String artist;
    private ArrayList<VIP> VIPs;
    public Concert(String name, Location location, LocalDate date, double tickerPrice, int numOfTickets, String artist, ArrayList<VIP> VIPs) {
        super(name, location, date, tickerPrice, numOfTickets);
        this.artist = artist;
        this.VIPs = VIPs;
    }
    public Concert(String name, LocalDate date){
        super(name,date);
    }
    public int numOfVIPs(){
        return this.VIPs.size();
    }

    public ArrayList<VIP> getVIPs() {
        return new ArrayList<VIP>(this.VIPs);
    }

    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist){
        this.artist = artist;
    }
    public void setVIPs(ArrayList<VIP> VIPs) {
        this.VIPs = VIPs;
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
        visitor.visitConcert(this);
    }



}
