/*
 * Tony Luu
 * CSC 2720 Lab 3 Pt 2
 * 09/09/2021
 */
import java.util.Scanner;
public class lab3pt2 {
    public static void main(String[] args){
        //setup from here to line 16 is very similar to part 1
        Scanner in = new Scanner(System.in);
        System.out.print("What size is your array? ");
        int rows = in.nextInt();
        int col = rows;
        int matrix[][] = new int[rows][col];
        //populates matrix 2d array with incremental values
        int counter = 1;
        for(int i = 0; i < rows; i++){
            for (int j = 0; j < col; j++){
                matrix[i][j] = counter++;
            }
        }
        in.close();
        //The rotation function:
        //The difference between this function and the function in part 1 is that this one trades the 
        //step of using a new 2D array(in my case resmat) which requires an additional nxn run time with
        //a bunch of smaller steps that take less time and space and operate through populating by switching spaces
        //as opposed to moving one space from an initial 2d array to an empty space in the result 2d array
        for(int i = 0; i < Math.floor(matrix.length/2); i++){
            for(int j = i; j < matrix.length - 1 - i; j++){
                //temp var z
                int z = matrix[i][j];
                matrix[i][j] = matrix[matrix.length - 1 - j][i];
                matrix[matrix.length - 1 - j][i] = matrix[matrix.length - 1 - i][matrix.length - 1 - j];
                matrix[matrix.length - 1 - i][matrix.length - 1 - j] = matrix[j][matrix.length - 1 - i];
                matrix[j][matrix.length - 1 - i] = z;
            }
        }
        //prints matrix in a formatted print statement
        for(int i = 0; i < matrix.length; i++){
            for (int j = 0; j < matrix[i].length; j++){
                System.out.printf("%4d", matrix[i][j]);
            }
            System.out.println();
        }
    }
}