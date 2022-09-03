// visitor for getting profit among events
public class ProfitVisitor extends AbstractVisitor{
    private double profit = 0.0;
    private final double PercentageConcert;
    private final double PercentageWorkshop;
    private final double PercentageGala;
    private final double PercentageScreening;

    public ProfitVisitor(double percentageConcert, double percentageWorkshop, double percentageGala, double percentageScreening) {
        PercentageConcert = percentageConcert/100;
        PercentageWorkshop = percentageWorkshop/100;
        PercentageGala = percentageGala/100;
        PercentageScreening = percentageScreening/100;
    }

    @Override
    public void visitConcert(Concert c) {
        profit+=c.getPrice()*this.PercentageConcert*c.getNumTickets();
    }

    @Override
    public void visitWorkshop(Workshop w) {
        profit+=w.getPrice()*this.PercentageWorkshop*w.getNumTickets();
    }

    @Override
    public void visitGala(Gala g) {
        profit+=g.getPrice()*this.PercentageGala*g.getNumTickets();
    }

    @Override
    public void visitScreening(Screening s) {
        profit+=s.getPrice()*this.PercentageScreening*s.getNumTickets();
    }

    @Override
    public void visitEvents(Festival f) {
        for(EventType e: f.getEvents()){
            e.accept(this);
        }
    }

    public double getProfit() {
        return profit;
    }
}
