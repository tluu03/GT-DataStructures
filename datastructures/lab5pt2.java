import java.util.Scanner;
class lab5pt2 {
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
        val = sortdeduplicate(array, val);
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
    public static int sortdeduplicate(int array[], int val){
        //bubble sort algorithm
        for(int i=0; i < val; i++){  
            for(int j=1; j < (val-i); j++){  
                if(array[j-1] > array[j]){   
                    int temp = array[j-1];  
                    array[j-1] = array[j];  
                    array[j] = temp;  
                }  
            }
        }
        //temp array, holds the special values
        int j = 0;
        //iterates throughout the array, compares the values to the values next to it
        for(int i = 0; i < val - 1; i++){
            if(array[i] != array[i + 1]){
                //stores the values that are duplicate to the original array as opposed to 
                //a temp array. (I feel silly not getting this quicker)
                array[j++] = array[i];
            }
        }
        array[j++] = array[val - 1];
        //changes the original array to the temp array
        return j;
    }
}

/*
test case #1: input size of 0
Code will fail, throws an out of bounds error

test case #2: input size of 1
Will just output the only value in the array

test case #3: no array values
The loop that asks the user to input their values will loop until a value inputted

test case #4: input array of [1 1 3 2 4 5 5 3]
Will first sort the array using selection sort. The sorted array will be [1 1 2 3 3 4 5 5]
Then it will be deduplicated to [1 2 3 4 5]
*/