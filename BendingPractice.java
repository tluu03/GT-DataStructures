/**
*I worked on the homework assignment alone, using only course materials.
*@author Tony Luu
*@version 1.0
*/
public class BendingPractice {
    /**
     * main
     * @param args args
     */
    public static void main(String[] args) {
        WaterBender katara = new WaterBender("Katara", 80, 100, true);
        WaterBender mermaidMan = new WaterBender("Mermaid Man");

        FireBender ace = new FireBender("Ace", 120, 20);
        FireBender mushu = new FireBender("Mushu");

        EarthBender whiteBeard = new EarthBender("Whitebeard", 100, 80, true);

        System.out.println(katara);
        System.out.println(mushu);
        System.out.println(whiteBeard);

        ace.attack(mermaidMan);
        whiteBeard.attack(mermaidMan);
        katara.heal(mermaidMan);
        whiteBeard.buildArmor();
        mermaidMan.attack(mushu);
        Bender[] group = {whiteBeard, katara};

        mushu.flameCircle(group);
        katara.recover(5);

        System.out.println(katara);
        System.out.println(mushu);
        System.out.println(whiteBeard);

        System.out.println("Earth: " + EarthBender.getEarthPoints());
        System.out.println("Water: " + WaterBender.getWaterPoints());
        System.out.println("Fire: " + FireBender.getFirePoints());
    }
}
