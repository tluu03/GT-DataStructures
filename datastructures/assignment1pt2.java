import java.util.*;
public class assignment1pt2
{
    public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
        //prompts user for array size
        System.out.print("Enter the first array size: ");
        int size1 = in.nextInt();
        //creates size for m
        int m[] = new int[size1];
        //prompts user to enter array elements
        System.out.print("Enter the first arrays elements: ");
        //loops until the values are all inputted
        for(int i=0; i<size1; i++){
            m[i] = in.nextInt();
        }
        
        //prompts user for second array size
        System.out.print("Enter the second array size: ");
        int size2 = in.nextInt();
        //creates array size foe array n
        int n[] = new int[size2];
        System.out.print("Enter the second arrays elements: ");
        //loops until all values are inputted 
        for(int i=0; i < size2; i++){
            n[i] = in.nextInt();
        }

        //displays the unaltered arrays
        //loops and displays the first array
        System.out.printf("Your arrays before: %n[");
        //first array
		for(int i=0; i < size1; i++){
			System.out.print(m[i]);
	           if(m.length - 1 != i){
	        	   //printing out commas
	        	   System.out.print(", ");
	           }
		}
        //formats
        System.out.printf("]%n%n[");
        //loops and displays the second array
        for(int i=0; i < size2; i++){
            System.out.print(n[i]);
               if(n.length - 1 != i){
                   System.out.print(", ");
               }
        }
        System.out.printf("]%n"); 
		System.out.printf("%nYour array after:%n[");
		//initiate array for the final answer
		//calls the duplicate method to find duplicates
        int[] finalArr = findDupes(m, n, size1, size2);
    	for (int i = 0; i < finalArr.length; i++){
            System.out.print(finalArr[i]);
            if(finalArr.length - 1 != i){
                System.out.print(", ");
            }
        }
        System.out.print("]");
	}
    //binary search method
    private static boolean binarySearch(int[] n, int arrIndex){
    	//start and end of the pivot
        int start = 0, end = n.length - 1;

        //while start is less than or equal to end it will set the midpoint
        while (start <= end){
            int mid = start + (end - start) / 2;

            //true if the midpoint for the second array is true
            if (n[mid] == arrIndex){
                return true;
            }
            //if not, goes to final
            else if (n[mid] < arrIndex){
                start = mid + 1;
            } 
            //else, goes to end
            else{
                end = mid - 1;
            }
        }
        return false;
    }
    //dupe finder method
    private static int[] findDupes(int[] m, int[] n, int size1, int size2){
        int arrSize;
        //sets the new arrSize to the smaller array
        if(size1 < size2){
        	arrSize = size1;
        }
        else{
        	arrSize = size2;
        }
        //temp array of new size, stores special values
        int[] temp = new int[arrSize]; 
        int count = 0; 
        //for loop, finds the duplicates
        for (int i = 0; i < size1; i++){
            if (!(i > 0 && m[i] == m[i-1])){
                if (binarySearch(n, m[i])){
                    temp[count++] = m[i];
                }
            }
        }

        int[] dupes = new int[count];
        //creates an array of duplicates
        for (int i = 0; i < count; i++){
            dupes[i] = temp[i];
        }
        return dupes;
    }
}

/*
test case #1: input of size 10 and 7, values [1,5,6,6,9,9,9,11,11,21] and [6,6,9,11,21,21,21]
Outputs [6,9,11,21]

test case #2: input size of 4 and 5, values [5,1,4,2] and [8,2,6,3,4]
Outputs an empty array, the code is dependent on the user to input an ordered array

test case #3: input size of 4 and 5, no array values
The loop that asks the user to input their values will loop until a value inputted

test case #4: input size of 4 and 4 [1,3,4,5] and [3,4,6,7]
Outputs [3,4]

test case #5: input of null
Will throw an error

test case #6: input of size 0 and 1, values [] and [2]
Outputs an empty array, []
*/


//Part 3
/* 
 * I think an improved part 2 could go for a sorting method. As of now, it cannot handle an unsorted input 
 * and gives an incorrect output. It also doesnt handle large arrays very well, if one array value were much bigger
 * than the other, the algorithm would not know to prioritize which array to prioritize searches in.
 * If it were able to determine this, it could run linearly with O(m+n) while maintaining the use of binary search.
 * */
