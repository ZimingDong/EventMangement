// visitor for getting location among events
public class LocationVisitor extends AbstractVisitor{
    private Location location;
    private int num = 0;

    @Override
    public void visitConcert(Concert c) {
        if(num==0){
            this.location = c.getLocation();
            num+=1;
        }else{
            if(this.location==c.getLocation()){
                return;
            }else{
                this.location = Location.Multiple;
            }
        }
    }

    @Override
    public void visitWorkshop(Workshop w) {
        if(num==0){
            this.location = w.getLocation();
            num+=1;
        }else{
            if(this.location==w.getLocation()){
                return;
            }else{
                this.location = Location.Multiple;
            }
        }
    }

    @Override
    public void visitGala(Gala g) {
        if(num==0){
            this.location = g.getLocation();
            num+=1;
        }else{
            if(this.location==g.getLocation()){
                return;
            }else{
                this.location = Location.Multiple;
            }
        }
    }

    @Override
    public void visitScreening(Screening s) {
        if(num==0){
            this.location = s.getLocation();
            num+=1;
        }else{
            if(this.location==s.getLocation()){
                return;
            }else{
                this.location = Location.Multiple;
            }
        }
    }

    @Override
    public void visitEvents(Festival f) {
        super.visitEvents(f);
    }

    public Location getLocation() {
        return location;
    }
}
