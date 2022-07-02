import java.io.FileNotFoundException;
public class BirdDriver {
    public static void main(String[] args) {
        BirdSitting b = new BirdSitting("birds.csv");
        try {
            b.startBirdSitting("birdCare1.csv");
            b.birdInventory();
        } catch (FileNotFoundException fne) {
            System.out.println(fne.getMessage());
        } catch (InvalidBirdException ibe) {
            System.out.println(ibe.getMessage());
        }
    }
}
