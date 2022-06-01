
//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("List of operations: add subtract multiply divide alphabetize");
        System.out.println("Enter an operation:");
        String operation = input.nextLine();
        switch (operation.toLowerCase()) {
            case "add": {
                System.out.println("Enter two integers:");
                String input1 = input.nextLine();
                String[] input2 = input1.split(" ");
                try {
                    int x = Integer.valueOf(input2[0]);
                    int y = Integer.valueOf(input2[1]);
                    int z = x + y;
                    System.out.println("Answer: " + z);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
            }
            case "subtract":
                System.out.println("Enter two integers:");
                String input1 = input.nextLine();
                String[] input2 = input1.split(" ");
                try {
                    int x = Integer.valueOf(input2[0]);
                    int y = Integer.valueOf(input2[1]);
                    int z = x + y;
                    System.out.println("Answer: " + z);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
            case "multiply":
                System.out.println("Enter two doubles: ");
                String inputx = input.nextLine();
                String[] inputy = inputx.split(" ");
                try {
                    double x = Double.parseDouble(inputy[0]);
                    double y = Double.parseDouble(inputy[1]);
                    double z = x * y;
                    System.out.printf("Answer: %.2f%n", z);
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                }
            case "divide":
                System.out.println("Enter two doubles: ");
                String inputz = input.nextLine();
                String[] inputw = inputz.split(" ");
                if (Double.parseDouble(inputw[0]) == 0 || Double.parseDouble(inputw[1]) == 0) {
                    System.out.println("Invalid input entered. Terminating...");
                    break;
                } else {
                    try {
                        double x = Double.parseDouble(inputw[0]);
                        double y = Double.parseDouble(inputw[1]);
                        double z = x / y;
                        System.out.printf("Answer: %.2f%n", z);
                        break;
                    } catch (NumberFormatException e) {
                        break;
                    }
                }
            case "alphabetize":
                System.out.println("Enter two words:");
                String inputq = input.nextLine();
                String[] inputr = inputq.split(" ");
                String t = inputr[0].toLowerCase();
                String u = inputr[1].toLowerCase();
                int compare = t.compareTo(u);
                if (compare > 0) {
                    System.out.println("Answer: " + inputr[1] + " comes before " + inputr[0] + " alphabetically.");
                    break;
                } else if (compare < 0) {
                    System.out.println("Answer: " + inputr[0] + " comes before " + inputr[1] + " alphabetically.");
                    break;
                } else {
                    System.out.println("Answer: Chicken or Egg.");
                    break;
                }
            default: {
                if (operation != "add" || operation != "subtract" || operation != "divide" || operation != "multiply"
                        || operation != "alphabetize") {
                    System.out.println("Invalid input entered. Terminating...");
                } else {
                    input.close();
                }
            }
        }
    }
}
