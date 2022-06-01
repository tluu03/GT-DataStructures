import java.util.Scanner;
public class Calculator {
    public static void main(String[] args){
        int add, subtract;
        double multiply, divide;
        String word;
        Scanner input = new Scanner(System.in);
        boolean cont = true;

        while(cont){
            System.out.println("List of operations: add subtract multiply divide alphabetize");
            System.out.println("Enter an operation:");
            String operation = input.nextLine();
            switch(operation.toLowerCase()){
                case "add":{
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Enter two integers:");
                    String input1 = scan.nextLine();
                    String[] input2 = input1.split(" ");
                    try{
                    int x = Integer.valueOf(input2[0]);
                    int y = Integer.valueOf(input2[1]);
                    int z = x + y;
                    System.out.println("Answer: " + z);
                    break;
                    }catch(NumberFormatException e){
                        cont = false;
                    }
                }
                case "subtract":
                    Scanner scan = new Scanner(System.in);
                    System.out.println("Enter two integers:");
                    String input1 = scan.nextLine();
                    String[] input2 = input1.split(" ");
                    try{
                    int x = Integer.valueOf(input2[0]);
                    int y = Integer.valueOf(input2[1]);
                    int z = x + y;
                    System.out.println("Answer: " + z);
                    break;
                    }catch(NumberFormatException e){
                        cont = false;
                    }
                case "multiply":
                    Scanner scan2 = new Scanner(System.in);
                    System.out.println("Enter two integers:");
                    String inputx = scan2.nextLine();
                    String[] inputy = inputx.split(" ");
                    try{
                    double x = Double.parseDouble(inputy[0]);
                    double y = Double.parseDouble(inputy[1]);
                    double z = x * y;
                    System.out.printf("Answer: %.2f%n", z);
                    break;
                    }catch(NumberFormatException e){
                        cont = false;
                    }
                case "divide":
                    Scanner scan3 = new Scanner(System.in);
                    System.out.println("Enter two integers:");
                    String inputz = scan3.nextLine();
                    String[] inputw = inputz.split(" ");
                    if(Double.parseDouble(inputw[0]) != 0){
                        try{
                        double x = Double.parseDouble(inputw[0]);
                        double y = Double.parseDouble(inputw[1]);
                        double z = x / y;
                        System.out.printf("Answer: %.2f%n", z);
                        break;
                        }catch(NumberFormatException e){
                        cont = false;
                    }
                }
                else{
                    cont = false;
                }
                case "alphabetize":
                default:{
                System.out.println("Invalid input entered. Terminating...");
                cont = false;
                }
            }
        }
        
    }
}