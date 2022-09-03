import java.time.LocalDate;
import java.util.ArrayList;

public class Driver {
    public static void main(String[]args){

        VIP v1 = new VIP();
        VIP v2 = new VIP();
        ArrayList<VIP> vips = new ArrayList<>();
        vips.add(v1);
        vips.add(v2);
        ArrayList<Workshop> workshops = new ArrayList<>();
        ArrayList<EventType> eventTypes = new ArrayList<>();
        EventManagement eventManagement = new EventManagement();
        eventManagement.addConcertEvent("c1",Location.BellCentre, LocalDate.of(2022,3,30),100.0,100,"Billie",vips);
        eventManagement.addWorkshopEvent("w1",Location.OlympicStadium,LocalDate.of(2022,3,29),50.0,50,workshops);
        eventManagement.addGalaEvent("g1",Location.ParcJeanDrapeau,LocalDate.of(2022,3,29),30.0,30,vips);
        eventManagement.addScreeningEvent("s1",Location.BellCentre,LocalDate.of(2022,3,28),50,30,Rating.R);
        Festival f1 = new Festival("f1",eventManagement.getHostedEvents());
        FilterResult fr1 = eventManagement.getFilterResultLocation(Location.BellCentre);
        FilterResult fr2 = eventManagement.getFilterResultPrice(10,110);
        eventManagement.getNumOfVIPs(fr1);
        eventManagement.getProfit(60,50,40,30,fr2);

    }
}
