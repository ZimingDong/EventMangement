import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class VisitorTest {
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
    private StubVisitor stubVisitor;

    private class StubVisitor extends AbstractVisitor{
        private boolean visited = false;

        public boolean isVisited() {
            return visited;
        }

        @Override
        public void visitConcert(Concert c) {
            this.visited = true;
        }

        @Override
        public void visitWorkshop(Workshop w) {
            this.visited = true;
        }

        @Override
        public void visitGala(Gala g) {
            this.visited = true;
        }

        @Override
        public void visitScreening(Screening s) {
            this.visited = true;
        }

        @Override
        public void visitEvents(Festival f) {
            for(EventType e: f.getEvents()){
                e.accept(this);
            }
            this.visited = true;
        }



    }
    @BeforeEach
    public void setStubVisited(){
        stubVisitor = new StubVisitor();
    }

    @BeforeEach
    public void setFestival(){
        eventTypes.add(c1);
        eventTypes.add(w1);
        eventTypes.add(g1);
        eventTypes.add(s1);
        f1 = new Festival("f1",eventTypes);
    }

    @Test
    public void testVisited_Concert(){
        stubVisitor.visitConcert(c1);
        assertTrue(stubVisitor.isVisited());
    }

    @Test
    public void testVisited_Workshop(){
        stubVisitor.visitWorkshop(w1);
        assertTrue(stubVisitor.isVisited());
    }

    @Test
    public void testVisited_Gala(){
        stubVisitor.visitGala(g1);
        assertTrue(stubVisitor.isVisited());
    }

    @Test
    public void testVisited_Screening(){
        stubVisitor.visitScreening(s1);
        assertTrue(stubVisitor.isVisited());
    }

    @Test
    public void testVisited_Festival(){
        stubVisitor.visitEvents(f1);
        assertTrue(stubVisitor.isVisited());
    }
}
