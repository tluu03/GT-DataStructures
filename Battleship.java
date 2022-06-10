//I worked on the homework assignment alone, using only course materials.
import java.util.Scanner;
/**
 * @author Tony Luu
 * @version version 1
 * Battle ship!
 */
public class Battleship {
    /**
     * main method
     * @param args args
     */
    public static void main(String[] args) {
        boolean player1Turn = true;
        char[][] player1 = new char[5][5];
        char[][] player2 = new char[5][5];
        int player1Score = 5;
        int player2Score = 5;
        Scanner scan = new Scanner(System.in);
        System.out.printf("\nWelcome to Battleship!\n");
        for (int i = 1; i < 3; i++) {
            System.out.println("PLAYER " + i + ", ENTER YOUR SHIPS' LOCATION.");
            for (int j = 1; j < player1.length + 1; j++) {
                System.out.println("Enter ship " + j + " location:");
                String input1 = scan.nextLine();
                String[] input2 = input1.split(" ");
                int x = Integer.valueOf(input2[0]);
                int y = Integer.valueOf(input2[1]);
                if (i == 1) {
                    try {
                        if (player1[x][y] == '@') {
                            System.out.println("You already have a ship there. Choose different coordinates.");
                            j = j - 1;
                        } else {
                            player1[x][y] = '@';
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        j = j - 1;
                    }
                } else {
                    try {
                        if (player2[x][y] == '@') {
                            System.out.println("You already have a ship there. Choose different coordinates.");
                            j = j - 1;
                        } else {
                            player2[x][y] = '@';
                        }
                    } catch (IndexOutOfBoundsException e) {
                        System.out.println("Invalid coordinates. Choose different coordinates.");
                        j = j - 1;
                    }
                }
            }
            if (i == 1) {
                printBattleShip(player1, 'T');
                for (int z = 0; z < 101; z++) {
                    System.out.println("");
                }
            } else {
                printBattleShip(player2, 'T');
                for (int z = 0; z < 101; z++) {
                    System.out.println("");
                }
            }
        }
        // this needs work
        do {
            if (player1Turn) {
                System.out.println("Player 1, enter hit row/column:");
                String input1 = scan.nextLine();
                String[] input2 = input1.split(" ");
                int x = Integer.valueOf(input2[0]);
                int y = Integer.valueOf(input2[1]);
                try {
                    if (player2[x][y] == '@') {
                        System.out.println("PLAYER 1 HIT PLAYER 2's SHIP!");
                        player2[x][y] = 'X';
                        player2Score -= 1;
                        if (player2Score <= 0) {
                            System.out.println("PLAYER 1 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                            System.out.println("");
                            break;
                        }
                        printBattleShip(player2, '@');
                        System.out.println("");
                        player1Turn = false;
                    } else if (player2[x][y] == 'O') {
                        System.out.println("You already fired on this spot. Choose different coordinates");
                    } else {
                        System.out.println("PLAYER 1 MISSED!");
                        player2[x][y] = 'O';
                        player1Turn = false;
                        printBattleShip(player2, '@');
                        System.out.println("");
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");
                }
            } else {
                System.out.println("Player 2, enter hit row/column:");
                String input3 = scan.nextLine();
                String[] input4 = input3.split(" ");
                int z = Integer.valueOf(input4[0]);
                int w = Integer.valueOf(input4[1]);
                try {
                    if (player1[z][w] == '@') {
                        System.out.println("PLAYER 2 HIT PLAYER 1's SHIP!");
                        player1[z][w] = 'X';
                        player1Score -= 1;
                        if (player1Score <= 0) {
                            System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                            System.out.println("");
                            break;
                        }
                        printBattleShip(player1, '@');
                        System.out.println("");
                        player1Turn = true;
                    } else if (player1[z][w] == 'O') {
                        System.out.println("You already fired on this spot. Choose different coordinates");
                    } else {
                        // sets player1 temp board to have a O
                        System.out.println("PLAYER 2 MISSED!");
                        player1[z][w] = 'O';
                        printBattleShip(player1, '@');
                        System.out.println("");
                        player1Turn = true;
                    }
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid coordinates. Choose different coordinates.");

                }
            }
            // need to figure out the hidden ships thing
        } while (player1Score > 0 || player2Score > 0);
        if (player1Score > 0 || player2Score > 0) {
            System.out.println("Final boards:");
            printBattleShip(player1, 'T');
            System.out.println("");
            printBattleShip(player2, 'T');
        }
    }

    private static void printBattleShip(char[][] player, char banned) {
        System.out.print("  ");
        for (int row = -1; row < 5; row++) {
            if (row > -1) {
                System.out.print(row + " ");
            }
            for (int column = 0; column < 5; column++) {
                char state = row == -1 ? ' ' : player[row][column];
                if (row == -1) {
                    System.out.print(column + " ");
                } else if (state != banned && (state == '@' || state == 'O' || state == 'X')) {
                    System.out.print(player[row][column] + " ");
                } else {
                    System.out.print("- ");
                }
            }
            System.out.println("");
        }
    }
}
