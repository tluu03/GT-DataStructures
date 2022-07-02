/**
 * earth bender class
 * @author Tony Luu
 * @version 1.0
 */
public class EarthBender extends Bender {
    private static int earthPoints;
    private boolean earthArmor;

    /**
     * 4 arg constructor
     * @param name name
     * @param strengthLevel strengthLevel
     * @param health health
     * @param earthArmor armor
     */
    public EarthBender(String name, int strengthLevel, int health, boolean earthArmor) {
        super(name, strengthLevel, health);
        this.earthArmor = earthArmor;
    }

    /**
     * constructor
     * @param name name
     */
    public EarthBender(String name) {
        this(name, 40, 100, false);
    }

    /**
     * static getter method
     * @return earthPoints
     */
    public static int getEarthPoints() {
        return earthPoints;
    }

    /**
     * static setter method
     * @param earthPoints earthPoints
     */
    public static void setEarthPoints(int earthPoints) {
        EarthBender.earthPoints = earthPoints;
    }

    /**
     * getter method
     * @return earthArmor
     */
    public boolean getEarthArmor() {
        return earthArmor;
    }

    /**
     * setter method
     * @param earthArmor earthArmor
     */
    public void setEarthArmor(boolean earthArmor) {
        this.earthArmor = earthArmor;
    }

    /**
     * earth bender attack
     * @param b b obj
     */
    public void attack(Bender b) {
        int sum;
        sum = b.getStrengthLevel();
        int bHealth = b.getHealth();

        if (!(this.getHealth() > 0)) {
            return;
        }
        if (b instanceof EarthBender) {
            return;
        }
        bHealth -= this.getStrengthLevel();
        b.setHealth(bHealth);
        if (earthArmor) {
            bHealth -= 20;
            b.setHealth(bHealth);
        }
        if (b.getHealth() <= 0) {
            b.setHealth(0);
            b.setStrengthLevel(0);
        }
        if (b.getHealth() < 20) {
            earthPoints += sum;
        }
        earthArmor = false;
    }

    /**
     * build armor
     */
    public void buildArmor() {
        earthArmor = true;
    }
}
