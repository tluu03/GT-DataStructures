import java.util.*;
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
                case "add":
                case "subtract":
                case "multiply":
                case "divide":
                case "alphabetize":
                default:
                System.out.println("Invalid input entered. Terminating...");
                cont = false;
            }
        }
        
    }
}