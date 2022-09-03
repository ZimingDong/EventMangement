//Rating for Screening
public enum Rating{
    G("G"),PG("PG"),PG13("PG-13"),R("R");
    private final String name;
    private Rating(String name) {
        this.name = name;
    }
    public String getName(){
        return this.name;
    }

}
