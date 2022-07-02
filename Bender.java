//I worked on the homework assignment alone, using only course materials.

/**
 * Abstract Class
 * @author Tony Luu
 * @version 1.0
 */
public abstract class Bender {
    private String name;
    private int strengthLevel;
    private int health;

    /**
     * constructor
     * @param name name
     * @param strengthLevel SL
     * @param health health
     */
    public Bender(String name, int strengthLevel, int health) {
        this.name = name;
        this.strengthLevel = strengthLevel;
        this.health = health;
    }

    /**
     * name getter method
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * SL get method
     * @return strengthLevel
     */
    public int getStrengthLevel() {
        return strengthLevel;
    }

    /**
     * SL set method
     * @param strengthLevel strength level of the bender
     */
    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }

    /**
     * the getter method for health
     * @return health
     */
    public int getHealth() {
        return health;
    }

    /**
     * set health
     * @param health health of the bender
     */
    public void setHealth(int health) {
        this.health = health;
    }

    /**
     * recover method
     * @param i i
     */
    public void recover(int i) {
        if (health > 0) {
            health += i;
        } else if (health == 0) {
            return;
        }
    }

    /**
     * abstract attack method
     * @param b b
     */
    public abstract void attack(Bender b);

    /**
     * equals method
     * @param o obj
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        if (o instanceof Bender) {
            Bender b1 = (Bender) o;
            return this.name.equals(b1.name) && this.strengthLevel == b1.strengthLevel
                    && this.health == b1.health;
        } else {
            return false;
        }
    }

    /**
     * toString method
     * @return String
     */
    public String toString() {
        return ("My name is " + name + ". I am a bender. My strength level is " + strengthLevel
                +
                " and my current health is " + getHealth() + ".");
    }
}
