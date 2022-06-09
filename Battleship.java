import java.util.Scanner;

public class Battleship {
    public static void main(String[] args) {
        boolean win = false;
        char[][] player1 = new char[5][5];
        char[][] player2 = new char[5][5];
        int player1Score = 5;
        int player2Score = 5;
        Scanner scan = new Scanner(System.in);
        System.out.printf("Welcome to Battleship!\n");
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
                printBattleShip(player1);
                // for(int z = 0; z < 101; z++){
                // System.out.println("");
                // }
            } else {
                printBattleShip(player2);
                // for(int z = 0; z < 101; z++){
                // System.out.println("");
                // }
            }
        }

        do {
            for (int i = 1; i < 3; i++) {
                switch (i) {
                    case 1:
                        System.out.println("Player 1, enter hit row/column:");
                        String input1 = scan.nextLine();
                        String[] input2 = input1.split(" ");
                        int x = Integer.valueOf(input2[0]);
                        int y = Integer.valueOf(input2[1]);
                        try {
                            if (player2[x][y] == '@') {
                                System.out.println("PLAYER 1 HIT PLAYER 2's SHIP!");
                                player2Score -= 1;
                            } else if (player2[x][y] == 'O') {
                                System.out.println("You already fired on this spot. Choose different coordinates");
                                i = i - 1;
                            } else {
                                System.out.println("PLAYER 1 MISSED!");
                                player2[x][y] = 'O';
                                // sets player1 temp board to have a O
                                // print temp board
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Invalid coordinates. Choose different coordinates.");
                            i = i - 1;
                        }
                    case 2:
                        System.out.println("Player 2, enter hit row/column:");
                        String input3 = scan.nextLine();
                        String[] input4 = input3.split(" ");
                        int z = Integer.valueOf(input4[0]);
                        int w = Integer.valueOf(input4[1]);
                        try {
                            if (player1[z][w] == '@') {
                                System.out.println("PLAYER 2 HIT PLAYER 1'S SHIP!");
                                player1Score -= 1;
                                // print temp board
                            } else if (player1[z][w] == 'O') {
                                System.out.println("You already fired on this spot. Choose different coordinates");
                                i = i - 1;
                            } else {
                                // sets player1 temp board to have a O
                                System.out.println("PLAYER 2 MISSED!");
                                player1[z][w] = 'O';
                                // print temp board
                            }
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Invalid coordinates. Choose different coordinates.");
                            i = i - 1;
                        }
                    default:
                        if (player1Score == 0) {
                            System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                            win = true;
                        } else if (player2Score == 0) {
                            System.out.println("PLAYER 2 WINS! YOU SUNK ALL OF YOUR OPPONENT'S SHIPS!");
                            win = true;
                        }
                        break;
                }
            }
        } while (win = false);

        // print final boards
        // need to figure out the hidden ships thing
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
