import java.util.ArrayList;

// visitor for different using
public abstract class AbstractVisitor implements Visitor{
    @Override
    public void visitConcert(Concert c) {}

    @Override
    public void visitWorkshop(Workshop w) {}

    @Override
    public void visitGala(Gala g) {}

    @Override
    public void visitScreening(Screening s) {}

    @Override
    public void visitEvents(Festival f) {
        for (EventType e: f.getEvents()){
            e.accept(this);
        }
    }
}
