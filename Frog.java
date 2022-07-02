/**
*I worked on the homework assignment alone, using only course materials.
*@author Tony Luu
*@version 1.0
*/
public class Frog {
    private String name;
    private int age;
    private double tongueSpeed;
    private boolean isFroglet;
    private static String species = "Rare Pepe";
    /**
     * Frog constructor
     * @param name name
     */
    public Frog(String name) {
        this(name, 5, 5);
    }
    /**
     * Frog constructor
     * @param name name
     * @param age age
     * @param tongueSpeed tongue
     */
    public Frog(String name, int age, double tongueSpeed) {
        this.name = name;
        this.age = age;
        this.tongueSpeed = tongueSpeed;
    }
    /**
     * Frog constructor
     * @param name name
     * @param ageInYears age
     * @param tongueSpeed tonguespeed
     */
    public Frog(String name, double ageInYears, double tongueSpeed) {
        this.name = name;
        age = (int) (ageInYears * 12);
        this.tongueSpeed = tongueSpeed;
    }
    /**
     * species getter
     * @return species
     */
    public static String getSpecies() {
        return species;
    }
    /**
     * species setter
     * @param species species
     */
    public void setSpecies(String species) {
        Frog.species = species;
    }
    /**
     * grow method
     * @param months months
     */
    public void grow(int months) {
        int difference = 12 - age;
        age += months;
        if (age < 12) {
            tongueSpeed += months * 1;
        } else if (age >= 12 && age <= 30) {
            tongueSpeed += difference * 1;
        } else if (age > 30) {
            int diff = age - 30;
            if (tongueSpeed - diff <= 5) {
                tongueSpeed = 5;
            } else {
                tongueSpeed -= diff * 1;
            }
        }
        if (age >= 1 && age <= 7) {
            isFroglet = true;
        } else {
            isFroglet = false;
        }
    }
    /**
     * grow method wihtout parameter
     */
    public void grow() {
        age += 1;
        if (age <= 12) {
            int difference = 12 - age;
            tongueSpeed += difference * 1;
        } else if (age > 30) {
            int diff = age - 30;
            if (tongueSpeed - diff <= 5) {
                tongueSpeed = 5;
            } else {
                tongueSpeed -= diff * 1;
            }
        }
        if (age >= 1 && age <= 7) {
            isFroglet = true;
        } else {
            isFroglet = false;
        }
    }
    /**
     * eat method takes object
     * @param object object
     */
    public void eat(Fly object) {
        if (object.isDead()) {
            return;
        } else if (tongueSpeed > object.getSpeed()) {
            if (object.getMass() >= this.age * 0.5) {
                grow();
            }
            object.setMass(0);
        } else {
            object.grow(1);
        }
    }
    /**
     * String method
     * @return string
     */
    public String toString() {
        if (isFroglet) {
            return ("My name is " + String.format("%.2f", this.name) + " and I'm a rare froglet! I'm "
                + String.format("%.2f", this.age) + " months old and my tongue has a speed of "
                    + String.format("%.2f", this.tongueSpeed));
        } else {
            return ("My name is " + String.format("%.2f", this.name) + " and I'm a rare frog! I'm "
                + String.format("%.2f", this.age) + " months old and my tongue has a speed of "
                    + String.format("%.2f", this.tongueSpeed));
        }
    }
}