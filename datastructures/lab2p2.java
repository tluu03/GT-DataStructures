import java.lang.Math;
public class lab2p2 {
    public static void main(String[] args){
        //initializing and assigning given_Array
        int[] given_Array = {1,9,8,9};
        //The idea is to convert to base 10 and add one
        //The end goal is to convert our integer array into an array
        int base = 10; 
        int sum = 0; 
        int carry = 1;
        //loops through array
        for(int i = 3; i >= 0; i--){
            //adds the carry to the current index
            given_Array[i] = given_Array[i] + carry;
            //checks if the new index is greater than 10
            //if greater than 10, set carry to 1. Otherwise set to 0
            if (given_Array[i] > 9){
                carry = 1;
            }
            else{
                carry = 0;
            }
            //take the mod of the index
            given_Array[i] = given_Array[i] % 10;
            sum += (int)given_Array[i] * (int)Math.pow(base, (4 - i - 1)); 
        }
        System.out.println(sum);
    }
}
