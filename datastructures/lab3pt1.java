/*
 * Tony Luu
 * CSC 2720 Lab 3 Pt 1
 * 09/09/2021
 */
import java.util.Scanner;
public class lab3pt1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        //prompt user to input array size
        System.out.print("What size is your array? ");
        int rows = in.nextInt();
        int col = rows;
        //create and populate 2d array
        int initmat[][] = new int[rows][col];
        //counter to assign incremental values inside 2d array
        int counter = 1;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < col; j++){
                initmat[i][j] = counter++;
            }
        }
        in.close();
        //rotates the matrix and creates a new array, retmat
        int[][] retmat = new int[col][rows];
        for (int i = 0; i < rows; i++){
                for (int j = 0; j < col; j++){
                    //ex: if row size was 3, it would place value 1 with index 0,0 at 
                    //the new spot j=0 and rows(3)-1-i(0) = 2 so 0,2
                    retmat[j][rows-1-i] = initmat[i][j];
            }
        }
        //print retmat, return matrix in a formatted print
        for(int i = 0; i < initmat.length; i++){
            for (int j = 0; j < initmat[i].length; j++){
                System.out.printf("%4d", retmat[i][j]);
            }
            System.out.println();
        }
    }
}
