import java.util.ArrayList;

// interface for representing visitor
public interface Visitor {
    void visitConcert(Concert c);
    void visitWorkshop(Workshop w);
    void visitGala(Gala g);
    void visitScreening(Screening s);
    void visitEvents(Festival f);
}
