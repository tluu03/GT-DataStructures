public class lab2p1 {
    public static void main(String[] args){
        //initialize array
        int[] given_Array = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        //compares and reassigns array elements 
        for (int i = 1; i < 12; i++){
            if (given_Array[i] < given_Array[i - 1]){
                //compares the indicies 
                given_Array[i] = given_Array[i] + given_Array[i - 1];
                //reassigns the indicies to ascending order
                given_Array[i - 1] = given_Array[i] - given_Array[i - 1];
                given_Array[i] = given_Array[i] - given_Array[i - 1];
                i = 0;
            }
        }
        //prints the rearranged array
        for (int i = 0; i < 12; i++){
            //prints array values
            System.out.print(given_Array[i] + " ");
        }
    }
}
