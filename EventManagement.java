import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/*
Controller to manage events hosted on EventBrite.
 */
public class EventManagement {
    private List<EventType> aHostedEvents = new ArrayList<EventType>();

    /*
    Method to host a new concert event
     */
    public void addConcertEvent(String name, Location location, LocalDate date, double tickerPrice, int numOfTickets,String artist,ArrayList<VIP> VIPs){
        assert name!=null;
        assert date!=null;
        assert location!=null;
        assert artist!=null;
        assert VIPs!=null;
        if(this.Check(date,location)){
            Concert c = new Concert(name,location,date,tickerPrice,numOfTickets,artist,VIPs);
            this.aHostedEvents.add(c);
        }else{
            return;
        }
    }

    /*
    Method to host a new Gala event
     */
    public void addGalaEvent(String name, Location location, LocalDate date, double tickerPrice, int numOfTickets,ArrayList<VIP> VIPs){
        assert name!=null;
        assert date!=null;
        assert location!=null;
        assert VIPs!=null;
        if(this.Check(date,location)){
            Gala g = new Gala(name,location,date,tickerPrice,numOfTickets,VIPs);
            this.aHostedEvents.add(g);
        }else{
            return;
        }

    }

    /*
    Method to host a new Screening event
     */
    public void addScreeningEvent(String name, Location location, LocalDate date, double tickerPrice, int numOfTickets,Rating rating){
        assert name!=null;
        assert date!=null;
        assert location!=null;
        assert rating!=null;
        if(this.Check(date,location)){
            Screening s = new Screening(name,location,date,tickerPrice,numOfTickets,rating);
            this.aHostedEvents.add(s);
        }else{
            return;
        }

    }

    /*
    Method to host a new Workshop event
     */
    public void addWorkshopEvent(String name, Location location, LocalDate date, double tickerPrice, int numOfTickets,ArrayList<Workshop> workshops){
        assert name!=null;
        assert date!=null;
        assert location!=null;
        assert workshops!=null;
        if(this.Check(date,location)){
            Workshop w = new Workshop(name,location,date,tickerPrice,numOfTickets,workshops);
            this.aHostedEvents.add(w);
        }else{
            return;
        }

    }

    /*
    Return the list of hosted events on EventBrite.
    This method assumes that Events are immutable.
     */

    public ArrayList<EventType> getHostedEvents(){
        return new ArrayList<EventType>(aHostedEvents);
    }

    // input lower price and higher price to get filter result from events we have
    public FilterResult getFilterResultPrice(double low,double high){
        assert low<high;
        ArrayList<EventType> result = new ArrayList<>();
        Predicate<EventType> PriceFilter =
                (EventType e) -> e.getPrice()>low && e.getPrice()<high;
        for(EventType t:this.aHostedEvents){
            if(PriceFilter.test(t)){
                result.add(t);
            }
        }
        return new FilterResult(result);
    }
    // input location to get filter result from events we have
    public FilterResult getFilterResultLocation(Location location){
        ArrayList<EventType> result = new ArrayList<>();
        Predicate<EventType> LocationFilter =
                (EventType e) -> e.getLocation()==location;
        for(EventType t:this.aHostedEvents){
            if(LocationFilter.test(t)){
                result.add(t);
            }
        }
        return new FilterResult(result);
    }
    // input percentage for 4 types of event and get profit of there events
    public double getProfit(double PercentageConcert,double PercentageWorkshop,double PercentageGala,double PercentageScreening,FilterResult filterResult){
        ProfitVisitor profitVisitor = new ProfitVisitor(PercentageConcert,PercentageWorkshop,PercentageGala,PercentageScreening);
        Festival test = new Festival("test", filterResult.getaFilteredEvents());
        profitVisitor.visitEvents(test);
        return profitVisitor.getProfit();
    }

    // get number of VIPS for the events
    public int getNumOfVIPs(FilterResult filterResult){
        VIPsVisitor viPsVisitor = new VIPsVisitor();
        Festival festival = new Festival("test",filterResult.getaFilteredEvents());
        viPsVisitor.visitEvents(festival);
        return viPsVisitor.getNum();
    }

    private boolean Check(LocalDate date,Location location){
        for (EventType e:this.aHostedEvents){
            if(e.getDate().isEqual(date)&&e.getLocation().equals(location)){
                return false;
            }
        }
        return true;
    }
    // add Festival to hostevents
    public void addFestivalEvent(String name){
        Festival festival = new Festival(name,getHostedEvents());
        this.aHostedEvents.add(festival);
    }

}
