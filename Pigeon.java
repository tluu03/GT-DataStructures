public class Pigeon extends Bird {
    private String homeCity;

    public Pigeon(String name, int hunger, int happiness, String homeCity){
        super(name, hunger, happiness);
        this.homeCity = homeCity;
    }
    public Pigeon(String name){
        this(name, 90, 90, "New York");
    }
    public void setHomeCity(String homeCity){
        this.homeCity = homeCity;
    }
    public String getHomeCity(){
        return homeCity;
    }
    public String speak(){
        String temp = "coo coo coo";
        if(this.getHunger() > 40){
            return(temp.toUpperCase());
        }
        return("");
    }
    public String receivePets(){
        return(this.getName() + " was displeased and flew away when I tried to pet it.");
    }
    public String eatFood(){
        this.setHunger(0);
        this.setHappiness(50);
        if(this.getHappiness() > 100){
            this.setHappiness(100);
        }
        return(this.getName() + " happily pecked up the bread.");
    }
    public boolean equals(Object o){
        if (o instanceof Pigeon) {
            Pigeon b2 = (Pigeon) o;
            return this.getName().equals(b2.getName()) && this.getHunger() == b2.getHunger()
                    && this.getHappiness() == b2.getHappiness() && this.homeCity == b2.homeCity;
        } else {
            return false;
        }
    }
}
