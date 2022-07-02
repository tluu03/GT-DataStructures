/**
*I worked on the homework assignment alone, using only course materials.
*@author Tony Luu
*@version 1.0
*/
public class Fly {
    private double mass;
    private double speed;
/**
 * Fly constructor
 * @param mass mass
 * @param speed speed
 */
    public Fly(double mass, double speed) {
        this.mass = mass;
        this.speed = speed;
    }
    /**
     * Fly constructor
     */
    public Fly() {
        this(5);
    }
    /**
     * Fly constructor
     * @param mass mass
     */
    public Fly(double mass) {
        this(mass, 10);
    }
    /**
     * default settings
     */
    public void defaultSetter() {
        mass = 5;
        speed = 10;
    }
    /**
     * Mass setter
     * @param mass mass
     */
    public void setMass(double mass) {
        this.mass = mass;
    }
    /**
     * speed setter
     * @param speed speed
     */
    public void setSpeed(double speed) {
        this.speed = speed;
    }
    /**
     * mass getter
     * @return mass
     */
    public double getMass() {
        return this.mass;
    }
    /**
     * speed getter
     * @return speed
     */
    public double getSpeed() {
        return this.speed;
    }
/**
 * grow method
 * @param addedMass added mass
 */
    public void grow(int addedMass) {
        if (this.mass < 20) {
            if (this.mass + addedMass >= 20) {
                this.speed += 20 - this.mass;
                this.speed -= 0.5 * (this.mass + addedMass - 20);
            }
            this.speed += addedMass;
        } else {
            this.speed -= 0.5 * addedMass;
        }
        mass += addedMass;
    }
    /**
     * is dead method
     * @return boolean
     */
    public boolean isDead() {
        if (getMass() == 0) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * String method
     * @return string
     */
    public String toString() {
        if (mass == 0) {
            return String.format("I'm dead, but I used to be a fly with a speed of "
                + String.format("%.2f", this.speed));
        } else {
            return ("I'm a speedy fly with " + String.format("%.2f", this.speed)
                + " speed and " + String.format("%.2f", this.mass) + " mass.");
        }
    }
}