import java.util.Scanner;
public class PersonalizedHelloWorld{
    public static void main(String[] args) 
        {
            String name;
            Scanner in = new Scanner(System.in);
            System.out.print("What is your name? ");
            //do while loop that repeats the prompt as long as the input is empty
            do{
                name = in.nextLine();
                if(name.isEmpty()){
                    System.out.print("Please enter your name: ");
                }
                //breaks out of the loop and continues to the while if the input isnt empty
                else{
                    break;
                }
            }
            //when true it will output the name and close the scanner
            while (true);
            System.out.print("Hello, " + name + "!");
            in.close();
        }
}
