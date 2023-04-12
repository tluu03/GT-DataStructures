import java.util.Scanner;
public class lab4pt1 {
    public static void main(String[] args){
        //Assume the user will input a sorted array
        Scanner in = new Scanner(System.in);
        System.out.print("Input array size: ");
        int size = in.nextInt();
        //sets array to input size
        int[] array = new int[size];
        int val = array.length;
        //loop through array length and prompt user to enter a value for every iteration
        System.out.print("Input array values: ");
        for (int i = 0; i < array.length; i++){
            array[i] = in.nextInt();
        }
        //pass values through deduplicate method
        val = deduplicate(array, val);
        //prints and formats the array
        System.out.print("ARRAY[]= [");
        for (int i = 0; i < val; i++){
            System.out.print(array[i]);
            if(val - 1 != i)
               {
                   System.out.print(",");
               }
        }
        System.out.print("]");
    }
    //deduplication method
    public static int deduplicate(int array[], int val){
        //temp array, holds the special values
        int[] temp = new int[val];
        int j = 0;
        //iterates throughout the array, compares the values to the values next to it
        for(int i = 0; i < val - 1; i++){
            if(array[i] != array[i + 1]){
                //stores the values that are duplicate
                temp[j++] = array[i];
            }
        }
        temp[j++] = array[val - 1];
        //changes the original array to the temp array
        for (int i = 0; i < j; i++){
            array[i] = temp[i];
        }
        return j;
    }
}
