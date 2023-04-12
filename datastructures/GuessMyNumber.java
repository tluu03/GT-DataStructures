import java.util.Scanner;
public class GuessMyNumber {
    //guesser method
    public static void guesser(int min , int max){
        Scanner scan = new Scanner(System.in);
        char answer;
        //calculates the guess and assigns the output to guessedNum
            int guessedNum = (min + max) / 2;
            System.out.println("Is your number: " + guessedNum + "?");
            System.out.println("Please enter C for correct, H for too high, or L for too low.");
            System.out.print("Enter your response(H/L/C): ");
            answer = scan.next().charAt(0);
            //checks if the response is the desired response (H,L,C)
            while ((answer!='C')&&(answer!='H')&&(answer!='L')){
            System.out.print("Enter your response (H/L/C): ");
            answer = scan.next().charAt(0);
            }
            //checks the answer, if it's correct it will close the dialogue and say thank you
            if(answer == 'C'){
                System.out.println("Thank you for playing Guess My Number! ");
                scan.close();
            }
            //if it's 'L' it will divide higher
            else if(answer == 'L'){
                guesser(guessedNum+1, max);
            }
            //if it's 'H' or neither, it will divide lower
            else{
                guesser(min, guessedNum-1);
            }
    }
    //main method
    public static void main(String[]args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Enter n: ");
        int input = in.nextInt();
        //If the user inputs a negative number
        if (input <= 0){
            System.out.println("Enter a positive integer for n: ");
            input = in.nextInt();
        }
        System.out.println("Welcome to Guess My Number!");
        System.out.println("Please think of a number between 0 and " + (input-1) + ".");
        //calls the guesser method and feeds in the values
        guesser(0,(input-1));
    }
}