/**
 *I worked on the homework assignment alone, using only course materials.
 *@author Tony Luu
 *@version 1.0
 */
public class Pond {
    /**
     * main method
     * @param args args
     */
    public static void main(String[] args) {
        Frog peepo = new Frog("Peepo");
        Frog pepe = new Frog("Pepe", 10, 15);
        Frog peepaw = new Frog("Peepaw", 4.6, 5);
        Frog jason = new Frog("Jason", 12, 25);

        Fly flyGuy = new Fly(1, 3);
        Fly flyGal = new Fly(6);
        Fly flyCappa = new Fly(5, 1);
        Fly flyperson = new Fly(4, 3);

        peepo.setSpecies("1331 Frogs");
        peepo.setSpecies("Giant peepo frog");
        System.out.println(peepo.toString());
        peepo.eat(flyGal);
        System.out.println(flyGal.toString());
        peepo.grow(8);
        System.out.println(flyGal.toString());
        System.out.println(peepo.toString());
        System.out.println(jason.toString());
        peepaw.grow(4);
        System.out.println(peepaw.toString());
        System.out.println(pepe.toString());
    }
}