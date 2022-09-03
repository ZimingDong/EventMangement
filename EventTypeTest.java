import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import java.lang.reflect.Method;
import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;


public class EventTypeTest {
    private VIP v1 = new VIP();
    private VIP v2 = new VIP();
    private ArrayList<VIP> vips = new ArrayList<>();
    private ArrayList<Workshop> workshops = new ArrayList<>();
    private ArrayList<EventType> eventTypes = new ArrayList<>();
    private Concert c1 = new Concert("c1",Location.BellCentre, LocalDate.of(2022,3,30),100.0,100,"Billie",vips);
    private Workshop w1 = new Workshop("w1",Location.OlympicStadium,LocalDate.of(2022,3,29),50.0,50,workshops);
    private Gala g1 = new Gala("g1",Location.ParcJeanDrapeau,LocalDate.of(2022,3,29),30.0,30,vips);
    private Screening s1 = new Screening("s1",Location.BellCentre,LocalDate.of(2022,3,28),50,30,Rating.R);
    private Festival f1;
    private EventManagement eventManagement = new EventManagement();

    private boolean invokeCheck(LocalDate localDate,Location location){
        try{
            Method check = eventManagement.getClass().getDeclaredMethod("Check", LocalDate.class, Location.class);
            check.setAccessible(true);
            return (boolean) check.invoke(eventManagement,localDate,location);
        } catch (ReflectiveOperationException e){
            e.printStackTrace();
            fail();
            return false;
        }

    }
    @BeforeEach
    public void setFestival(){
        eventTypes.add(c1);
        eventTypes.add(w1);
        eventTypes.add(g1);
        eventTypes.add(s1);
        f1 = new Festival("f1",eventTypes);
    }
    @BeforeEach
    public void setEventManagement(){
        eventManagement.addConcertEvent("c1",Location.BellCentre, LocalDate.of(2022,3,30),100.0,100,"Billie",vips);
        eventManagement.addWorkshopEvent("w1",Location.OlympicStadium,LocalDate.of(2022,3,29),50.0,50,workshops);
        eventManagement.addGalaEvent("g1",Location.ParcJeanDrapeau,LocalDate.of(2022,3,29),30.0,30,vips);
        eventManagement.addScreeningEvent("s1",Location.BellCentre,LocalDate.of(2022,3,28),50,30,Rating.R);
    }
    @Test
    public void testName_Events(){
        assertEquals("c1",c1.getName());
        assertEquals("w1",w1.getName());
        assertEquals("g1",g1.getName());
        assertEquals("s1",s1.getName());
    }

    @Test
    public void testDate_Events(){
        assertEquals(LocalDate.of(2022,3,30),c1.getDate());
        assertEquals(LocalDate.of(2022,3,29),w1.getDate());
        assertEquals(LocalDate.of(2022,3,29),g1.getDate());
        assertEquals(LocalDate.of(2022,3,28),s1.getDate());
    }

    @Test
    public void testPrice_Events(){
        assertEquals(100.0,c1.getPrice());
        assertEquals(50.0,w1.getPrice());
        assertEquals(30.0,g1.getPrice());
        assertEquals(50.0,s1.getPrice());
    }

    @Test
    public void testNum_Events(){
        assertEquals(100,c1.getNumTickets());
        assertEquals(50,w1.getNumTickets());
        assertEquals(30,g1.getNumTickets());
        assertEquals(30,s1.getNumTickets());
    }

    @Test
    public void testLocation_Events(){
        assertEquals(Location.BellCentre,c1.getLocation());
        assertEquals(Location.OlympicStadium,w1.getLocation());
        assertEquals(Location.ParcJeanDrapeau,g1.getLocation());
        assertEquals(Location.BellCentre,s1.getLocation());
    }

    @Test
    public void testArtist_Concert(){
        c1.setArtist("test");
        assertEquals("test",c1.getArtist());
    }

    @Test
    public void testRating_Screening(){
        s1.setRating(Rating.G);
        assertEquals(Rating.G,s1.getRating());
    }

    @Test
    public void testPrice_Festival(){
        assertEquals(46.0,f1.getPrice());
    }

    @Test
    public void testNum_Festival(){
        assertEquals(30,f1.getNumTickets());
    }

    @Test
    public void testDate_Festival(){
        assertEquals(LocalDate.of(2022,3,28),f1.getDate());
    }

    @Test
    public void testLocation_Festival(){
        assertEquals(Location.Multiple,f1.getLocation());
    }

    @Test
    public void testEvents_Festival(){
        assertEquals(eventTypes,f1.getEvents());
    }

    @Test
    public void testFilterResultLocation_EventMangement(){
        FilterResult fr1 = eventManagement.getFilterResultLocation(Location.BellCentre);
        ArrayList<EventType> events = new ArrayList<>();
        events.add(c1);
        events.add(s1);
        assertEquals(events.get(0).getLocation(),fr1.getaFilteredEvents().get(0).getLocation());
        assertEquals(events.get(1).getLocation(),fr1.getaFilteredEvents().get(1).getLocation());
        assertEquals(events.size(),fr1.getaFilteredEvents().size());
    }

    @Test
    public void testFilterResultPrice_EventManagement(){
        FilterResult fr2 = eventManagement.getFilterResultPrice(40,70);
        assertEquals(w1.getPrice(),fr2.getaFilteredEvents().get(0).getPrice());
        assertEquals(s1.getPrice(),fr2.getaFilteredEvents().get(1).getPrice());
    }

    @Test
    public void testProfit_EventManagement1(){
        FilterResult fr3 = new FilterResult(eventTypes);
        double profit = eventManagement.getProfit(50,30,20,40,fr3);
        assertEquals(6530,profit);
    }

    @Test
    public void testProfit_EventManagement2(){
        ArrayList<EventType> events = new ArrayList<>();
        events.add(f1);
        FilterResult fr3 = new FilterResult(events);
        double profit = eventManagement.getProfit(50,30,20,40,fr3);
        assertEquals(6530,profit);
    }

    @Test
    public void testVIPs_EventManagement1(){
        vips.add(v1);
        vips.add(v2);
        c1.setVIPs(vips);
        g1.setVIPs(vips);
        FilterResult fr4 = new FilterResult(eventTypes);
        int num = eventManagement.getNumOfVIPs(fr4);
        assertEquals(4,num);
    }

    @Test
    public void testVIPs_EventManagement2(){
        vips.add(v1);
        vips.add(v2);
        c1.setVIPs(vips);
        g1.setVIPs(vips);
        f1 = new Festival("f1",eventTypes);
        ArrayList<EventType> events = new ArrayList<>();
        events.add(f1);
        FilterResult fr4 = new FilterResult(events);
        int num = eventManagement.getNumOfVIPs(fr4);
        assertEquals(4,num);
    }

    @Test
    public void testComingsoon_Event(){
        Concert concert_cs = new Concert("Coming soon",LocalDate.of(2023,3,30));
        concert_cs.getNumTickets();
        concert_cs.getLocation();
        concert_cs.getPrice();
    }

    @Test
    public void testSameLocationAndDate_Event(){
        int size_before = eventManagement.getHostedEvents().size();
        eventManagement.addGalaEvent("no",Location.BellCentre,LocalDate.of(2022,3,30),100,100,vips);
        int size_after = eventManagement.getHostedEvents().size();
        assertEquals(size_after,size_before);
    }

    @Test
    public void testInvaldInput(){
        assertThrows(AssertionError.class,()->eventManagement.addConcertEvent("null",Location.BellCentre,null,100,10,null,null));
        assertThrows(AssertionError.class,()->eventManagement.addWorkshopEvent("null",Location.BellCentre,null,100,10,workshops));
    }

    @Test
    public void testCheck1(){
        assertTrue(invokeCheck(LocalDate.of(2022,3,31),Location.BellCentre));
    }

    @Test
    public void testCheck2(){
        assertFalse(invokeCheck(LocalDate.of(2022,3,30),Location.BellCentre));
    }


}
