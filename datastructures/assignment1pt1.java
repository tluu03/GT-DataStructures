import java.util.*;
public class assignment1pt1 {
    public static void main(String[] args){
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
        for(int i=0; i<size2; i++){
            n[i] = in.nextInt();
        }

        //displays the unaltered arrays
        //loops and displays the first array
        System.out.printf("Your arrays before: %n[");
        for(int i = 0; i < m.length; i++){
            System.out.print(m[i]);
            if(m.length - 1 != i){
                   System.out.print(", ");
               }
        }
        //formats
        System.out.printf("]%n%n[");
        //loops and displays the second array
        for(int i=0; i < n.length; i++){
            System.out.print(n[i]);
               if(n.length - 1 != i){
                   System.out.print(", ");
               }
        }
        System.out.printf("]%n"); 
        int arrSize;
        //sets size to the smaller array size
        if(size1 < size2){
            arrSize = size1;
        }
        else{
            arrSize = size2;
        }
        //merge array
        int newArr[] = new int[arrSize];
        int count = 0;
        //this will be the pivot
        int temp = -1;
        //finds the duplicates, sets the new array to temp array and then increments the count
        for(int i=0; i < size1; i++){
            for(int j = 0; j < size2; j++){
                if(n[j] == m[i] && n[j] != temp && m[i] != temp){
                    newArr[count] = n[j];
                    temp = newArr[count];
                    count++;
                }
            }
        }
        //eliminates the problem with the trailing 0 that would occasionally show up
        //just sets the range in which to display values
        newArr = Arrays.copyOfRange(newArr, 0, count);
        //outputs the ginal new array
        System.out.printf("Your arrays after: %n[");
        for(int i = 0; i < newArr.length; i++){
            System.out.print(newArr[i]);
            if(newArr.length - 1 != i){
                   //printing out commas
                   System.out.print(", ");
               }
        }
        System.out.print("]");
    }
}
/*
test case #1: input of size 10 and 7, values [1,5,6,6,9,9,9,11,11,21] and [6,6,9,11,21,21,21]
Outputs [6,9,11,21]

test case #2: input size of 4 and 5, values [5,1,4,2] and [8,2,6,3,4]
Outputs [4, 2]

test case #3: input size of 4 and 5, no array values
The loop that asks the user to input their values will loop until a value inputted

test case #4: input size of 4 and 4 [1,3,4,5] and [3,4,6,7]
Outputs [3,4]

test case #5: input of null
Will throw an error

test case #6: input of size 0 and 1, values [] and [2]
Outputs an empty array, []
*/