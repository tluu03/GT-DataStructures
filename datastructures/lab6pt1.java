import java.util.Scanner;
public class lab6pt1 {
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
        mergeSort(array,size);
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
	//merge sort method
	public static void mergeSort(int[] array, int size) {
        //has to be greater than 2 to compare
	    if (size < 2) {
	        return;
	    }
        //finds the middle and left and right of the middle
	    int middle = size / 2;
	    int[] left = new int[middle];
	    int[] right = new int[size - middle];
        //loops and compares the left side
	    for (int i = 0; i < middle; i++) {
	        left[i] = array[i];
	    }
        //loops and compares the right side
	    for (int i = middle; i < size; i++) {
	        right[i - middle] = array[i];
	    }
        //calls on itself
	    mergeSort(left, middle);
	    mergeSort(right, size - middle);
	    merge(array, left, right, middle, size - middle);
	}
	//merges the individual subsets
	public static void merge(int[] array, int[] left2, int[] right2, int left, int right) {
			 
			    int i = 0, j = 0, k = 0;
			    while (i < left && j < right) {
			        if (left2[i] <= right2[j]) {
			            array[k++] = left2[i++];
			        }
			        else {
			            array[k++] = right2[j++];
			        }
			    }
			    while (i < left) {
			        array[k++] = left2[i++];
			    }
			    while (j < right) {
			        array[k++] = right2[j++];
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