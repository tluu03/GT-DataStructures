/**
 * firebender class
 * @author Tony Luu
 * @version 1.0
 */
public class FireBender extends Bender {
    private static int firePoints;

    /**
     *constructor
     * @param name name
     * @param strengthLevel strengthLevel
     * @param health health
     */
    public FireBender(String name, int strengthLevel, int health) {
        super(name, strengthLevel, health);
    }

    /**
     * 1 arg constructor
     * @param name name of the Bender
     */
    public FireBender(String name) {
        this(name, 60, 50);
    }

    /**
     * static getter method
     * @return firePoints
     */
    public static int getFirePoints() {
        return firePoints;
    }

    /**
     * static setter method
     * @param firePoints firePoints
     */
    public static void setFirePoints(int firePoints) {
        FireBender.firePoints = firePoints;
    }

    /**
     * firebender attack
     * @param b b
     */
    public void attack(Bender b) {
        int sum;
        sum = b.getStrengthLevel();
        int bHealth = b.getHealth();

        if (!(this.getHealth() > 5)) {
            return;
        }
        bHealth -= this.getStrengthLevel();
        b.setHealth(bHealth);
        if (b.getHealth() <= 0) {
            b.setHealth(0);
            b.setStrengthLevel(0);
        }
        if (b.getHealth() < 20) {
            firePoints += sum;
        }
    }

    /**
     * fire bender attack 2
     * @param b b
     */
    public void flameCircle(Bender[] b) {
        for (Bender bend : b) {
            int bHealth = bend.getHealth();
            bHealth -= 10;
            bend.setHealth(bHealth);
            if (bend.getHealth() < 0) {
                bend.setHealth(0);
            }
            firePoints += 5;
        }
    }
}
