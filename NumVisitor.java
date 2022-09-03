// visitor for getting numbers of tickets among events
public class NumVisitor extends AbstractVisitor{
    private int num = Integer.MAX_VALUE;
    @Override
    public void visitConcert(Concert c) {
        if(c.getNumTickets()<num){
            num = c.getNumTickets();
        }
    }

    @Override
    public void visitWorkshop(Workshop w) {
        if(w.getNumTickets()<num){
            num = w.getNumTickets();
        }
    }

    @Override
    public void visitGala(Gala g) {
        if(g.getNumTickets()<num){
            num = g.getNumTickets();
        }
    }

    @Override
    public void visitScreening(Screening s) {
        if(s.getNumTickets()<num){
            num = s.getNumTickets();
        }
    }

    @Override
    public void visitEvents(Festival f) {
        super.visitEvents(f);
    }

    public int getNum() {
        return num;
    }
}
