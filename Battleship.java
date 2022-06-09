import java.util.Scanner;
public class Battleship {
    public static void main(String[] args){
        boolean player1 = true;
        boolean player2 = false;
        boolean win = false;
        char[][] board = new char[5][5];
        Scanner scan = new Scanner(System.in);
        System.out.printf("Welcome to Battleship!\n");

        do{
            for(int i = 1; i < 3; i++){
                System.out.println("PLAYER " + i + ", ENTER YOUR SHIPS' LOCATION.");
                for (int j = 1; j < board.length + 1; j++){
                    System.out.println("Enter ship " + j + " location:");
                    String input1 = scan.nextLine();
                    String[] input2 = input1.split(" ");
                    int x = Integer.valueOf(input2[0]);
                    int y = Integer.valueOf(input2[1]);
                    try{
                        if (board[x][y] == '@'){
                            System.out.println("You already have a ship there. Choose different coordinates.");
                        }
                        else{
                            board[x][y] = '@';
                        }
                    }
                    catch(IndexOutOfBoundsException e){
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                    }
                }
        }
        }while(win = false);
    }
    private static void printBattleShip(char[][] player) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                if (row == -1) {
                    System.out.print(column + " ");
                } else {
                    System.out.print(player[row][column] + " ");
                }
            }
            System.out.println("");
        }
    }    
}
