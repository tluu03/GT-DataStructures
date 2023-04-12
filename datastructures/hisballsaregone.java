import java.util.Scanner;
public class hisballsaregone {
    public static void main(String[]args){
        boolean x = true;
        while (x == true){
        Scanner in = new Scanner(System.in);
        System.out.printf("You are in data structures...\nWho are you?\nTony?\nJenny?\nDuy?\nSarah?\n");
        String input = in.next();
        
        if(input == "Tony"){
            Tony(x);
        }
    }
    }
    public static boolean Tony(){
        Scanner in = new Scanner(System.in);
        System.out.print("Did he pull the fire alarm(Y/N)?");
        char input = in.next().charAt(0);

        if (input == 'Y'){
            System.out.println("Tony has balls!");
        }
        else{
            System.out.println("THIS MF DON'T GOT BALLS!");
        }
        System.out.print("Do you wish to exit or continue(E/C)?");
        char input2 = in.next().charAt(0);
        if (input == 'E'){
            System.out.println("Goodbye!");
            return
        }
        else{
            System.out.println("aight");
            return(x = true);
        }
        in.close();
    }
    public static void Sarah(){

    }
    public static void Duy(){

    }
    public static void Jenny(){

    }
}
