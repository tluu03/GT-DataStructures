public class Goose extends Bird {
    private int honkPower;

    public Goose(String name, int hunger, int happiness, int honkPower){
        // super(name, hunger, happiness);
        super(name, hunger, happiness);
        this.honkPower = honkPower;
    }
    public Goose(String name){
        this(name, 70, 20, 8);
    }

    public String speak(){
        String temp = "honk ";
        String temp2 = "";
        for(int i = 0; i < honkPower; i++){
            temp2 += temp;
        }
        if(this.getHappiness() < 30){
            temp2.toUpperCase();
            return(temp2);
        }
        else{
            return(temp2);
        }
    }
    public String receivePets(){
        if(this.getHappiness() >= 80){
            return(this.getName() + " waddles off and hands me a flower after being pet.");
        }
        this.setHappiness(20);
        if(this.getHappiness() >= 100){
            this.setHappiness(100);
        }
        else{
            return(this.getName() + " honks at me for more pets.");
        }
        return("");
    }
    public String eatFood(){
        if(this.getHunger() == 0){
            this.setHappiness(10);
            if(this.getHappiness() <= 0){
                this.setHappiness(0);
                return(this.getName() + " was not hungry but ate a little food anyways.");
            }
        }
        else{
            this.setHappiness(0);
            return(this.getName() + " thoroughly enjoyed the meal.");
        }
        return("");
    }
    public int getHonkPower(){
        return honkPower;
    }
    public void setHonkPower(int honkPower){
        this.honkPower = honkPower;
    }
    public boolean equals(Object o){
        if (o instanceof Goose) {
            Goose b2 = (Goose) o;
            return this.getName().equals(b2.getName()) && this.getHunger() == b2.getHunger()
                    && this.getHappiness() == b2.getHappiness() && this.honkPower == b2.honkPower;
        } else {
            return false;
        }
    }
}
