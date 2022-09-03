// visitor for get numbers of VIP
public class VIPsVisitor extends AbstractVisitor{
    private int num = 0;

    @Override
    public void visitConcert(Concert c) {
        num+=c.numOfVIPs();
    }

    @Override
    public void visitWorkshop(Workshop w) {
        return;
    }

    @Override
    public void visitGala(Gala g) {
        num+=g.numOfVIPs();
    }

    @Override
    public void visitScreening(Screening s) {
        return;
    }

    @Override
    public void visitEvents(Festival f) {
        for(EventType e:f.getEvents()){
            e.accept(this);
        }
    }

    public int getNum() {
        return num;
    }
}
