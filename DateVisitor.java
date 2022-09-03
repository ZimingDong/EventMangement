import java.time.LocalDate;
// visitor for getting date among events
public class DateVisitor extends AbstractVisitor{
    private LocalDate localDate = LocalDate.MAX;

    @Override
    public void visitConcert(Concert c) {
        if(c.getDate().isBefore(localDate)){
            this.localDate = c.getDate();
        }
    }

    @Override
    public void visitWorkshop(Workshop w) {
        if(w.getDate().isBefore(localDate)){
            this.localDate = w.getDate();
        }
    }

    @Override
    public void visitGala(Gala g) {
        if(g.getDate().isBefore(localDate)){
            this.localDate = g.getDate();
        }
    }

    @Override
    public void visitScreening(Screening s) {
        if(s.getDate().isBefore(localDate)){
            this.localDate = s.getDate();
        }
    }

    @Override
    public void visitEvents(Festival f) {
        super.visitEvents(f);
    }

    public LocalDate getLocalDate() {
        return localDate;
    }
}
