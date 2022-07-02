/**
 * water bender class
 * @author Tony Luu
 * @version 1.0
 */

public class WaterBender extends Bender {
    private static int waterPoints;
    private final boolean healer;

    /**
     * 4 arg constructor
     * @param name          name of the WaterBender
     * @param strengthLevel strengthLevel of the Bender
     * @param health        health of the Bender
     * @param healer        the healer ability of the WaterBender
     */
    public WaterBender(String name, int strengthLevel, int health, boolean healer) {
        super(name, strengthLevel, health);
        this.healer = healer;
    }

    /**
     * constructor
     * @param name name of the Water Bender
     */
    public WaterBender(String name) {
        this(name, 40, 80, false);
    }

    /**
     * getter method
     * @return waterPoints
     */
    public static int getWaterPoints() {
        return waterPoints;
    }

    /**
     * getter method
     * @return healer
     */
    public boolean getHealer() {
        return healer;
    }

    /**
     * attack method
     * @param b b
     */
    public void attack(Bender b) {
        int sum;
        sum = b.getStrengthLevel();
        int bHealth = b.getHealth();

        if (!(this.getHealth() > 0)) {
            return;
        }
        bHealth -= this.getStrengthLevel();
        b.setHealth(bHealth);
        if (b.getHealth() <= 0) {
            b.setHealth(0);
            b.setStrengthLevel(0);
        }
        if (b.getHealth() < 20) {
            waterPoints += sum;
        }
    }

    /**
     * heal method
     * @param wb waterBender
     */
    public void heal(WaterBender wb) {
        int wbHealth = wb.getHealth();
        int wbSL = wb.getStrengthLevel();
        if (!healer) {
            return;
        } else {
            wbHealth += 20;
            wbSL += 20;
            wb.setHealth(wbHealth);
            wb.setStrengthLevel(wbSL);
        }
    }

    /**
     * equals method, override
     * @param o obj
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof WaterBender) {
            WaterBender b2 = (WaterBender) o;
            return this.getName().equals(b2.getName()) && this.getStrengthLevel() == b2.getStrengthLevel()
                    && this.getHealth() == b2.getHealth() && this.healer == b2.healer;
        } else {
            return false;
        }
    }

    /**
     * toString method
     * @return String
     */
    @Override
    public String toString() {
        if (!healer) {
            return ("My name is " + this.getName() + ". I am a bender. My strength level is " + this.getStrengthLevel()
                    +
                    " and my current health is " + this.getHealth() + ". With my waterbending, I cannot heal others.");
        } else {
            return ("My name is " + this.getName() + ". I am a bender. My strength level is " + this.getStrengthLevel()
                    +
                    " and my current health is " + this.getHealth() + ". With my waterbending, I can heal others.");
        }
    }

}
