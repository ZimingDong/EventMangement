// visitor for getting price among events
public class PriceVisitor extends AbstractVisitor{
    private double price;

    @Override
    public void visitConcert(Concert c) {
        price+=c.getPrice();
    }

    @Override
    public void visitWorkshop(Workshop w) {
        price+=w.getPrice();
    }

    @Override
    public void visitGala(Gala g) {
        price+=g.getPrice();
    }

    @Override
    public void visitScreening(Screening s) {
        price+=s.getPrice();
    }

    @Override
    public void visitEvents(Festival f) {
        super.visitEvents(f);
    }

    public double getPrice() {
        return price*0.2;
    }
}
