import java.util.Scanner;
public class lab6pt2 {
	public static void main(String[] args){
		Scanner in = new Scanner(System.in);
		//asks user for array size
		System.out.print("Input array size: ");
		//stores user input
		int size = in.nextInt();
		int array[] = new int[size];
        //asks user for array values
		System.out.print("Input array values: ");
		
		//populates array
		for(int i=0; i<array.length; i++){
			array[i] = in.nextInt();
		}

		//calls merge sort and then sets the final array to the
        //deduplicated sorted array
        quicksort(array, 0, size - 1);
	    int finalarr = deduplication(array, size);
        
        //prints out the final array
		System.out.print("ARRAY[]= [");
		for(int i=0; i<finalarr; i++){
            System.out.print(array[i] + " ");
		}
		System.out.print("]");
        
	}
	//deduplication method, removes duplicate values
	public static int deduplication(int array[], int size){
        //if the user enters 0 or 1 the value will be outputted or the empty array will be outputted
        if (size == 0 || size == 1){
            return size;
        }
        
        //stores the special values
        int j = 0;
        //finds duplicate values
        for(int i = 0; i < size - 1; i++){
            if(array[i] != array[i + 1]){
                //stores the values that are duplicate to the original array
                array[j++] = array[i];
            }
        }
        array[j++] = array[size - 1];
        return j;
    }
	//finds the partition
	private static int partition(int array[], int begin, int end) {
        //end of array
	    int pivot = array[end];
	    int i = (begin-1);
        //performs the swap and stores it
	    for (int j = begin; j < end; j++) {
	        if (array[j] <= pivot) {
	            i++;

	            int swap = array[i];
	            array[i] = array[j];
	            array[j] = swap;
	        }
	    }
        //stores it in temp
	    int temp = array[i+1];
	    array[i+1] = array[end];
	    array[end] = temp;

	    return i+1;
	}
	//quicksort method
	public static void quicksort(int array[], int begin, int end) {
        //compares the values
	    if (begin < end) {
	        int partitionIndex = partition(array, begin, end);
            //calls on itself twice
	        quicksort(array, begin, partitionIndex - 1);
	        quicksort(array, partitionIndex + 1, end);
	    }
	}
}
/*
test case #1: input size of 0
Code will run but display an empty array

test case #2: input size of 1
Will just output the only value in the array

test case #3: no array values
The loop that asks the user to input their values will loop until a value inputted

test case #4: input array of [1 1 3 2 4 6 5 3]
Will first sort the array using bubble sort. The sorted array will be [1 1 2 3 3 4 5 6]
Then it will be deduplicated to [1 2 3 4 5 6]

test case #5: input of null
Will throw an error
*/