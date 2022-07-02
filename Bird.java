public abstract class Bird {
    private String name;
    private int hunger;
    private int happiness;

    public Bird(String name, int hunger, int happiness){
        this.name = name;
        this.hunger = hunger;
        this.setHappiness(happiness);
    }
    
    public int getHappiness() {
        return happiness;
    }

    public void setHappiness(int happiness) {
        if(happiness == 20 || happiness == 50){
            this.happiness += happiness;
        }
        else if(happiness == 10){
            this.happiness -= 10;
        }
        else{
            this.happiness = happiness;
        }
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getHunger(){
        return hunger;
    }
    public void setHunger(int hunger){
        this.hunger = hunger;
    }
    public abstract String speak();
    public abstract String receivePets();
    public abstract String eatFood();
    public boolean equals(Object o){
        if (o instanceof Bird) {
            Bird b2 = (Bird) o;
            return this.getName().equals(b2.getName()) && this.getHunger() == b2.getHunger()
                    && this.getHappiness() == b2.getHappiness();
        } else {
            return false;
        }
    }
}
