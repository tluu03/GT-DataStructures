import java.util.*;
public class assignment1p2 {
    //holds numbers
	public static Stack<Double> number = new Stack();
    //holds operations		
 	public static Stack<String> operatorcont = new Stack();	
 	public static int i = 0;									  	
	
	//method that goes through the array, gives an answer and removes spaces
	public static double work(String[] expression) {				
		//iterates throughout the string
	 	while(i < expression.length) {
	 		//if its a digit it gets pushed to stack.
	 		try {													
	 			Double digit = Double.parseDouble(expression[i]);
	 			number.push(digit);									
	 		}
             //if it isnt a digit, its an operator
             catch(Exception e){				
                String operator = expression[i];
                //if a parenthesis is found it gets pushed
	 			if(operator.equals("(")) {			
	 				i++;						
	 				operatorcont.push("(");		
	 				work(expression);
	 			}
                 //if its a ")" then it breaks and moves on
                 else if(operator.equals(")")) {		
	 				break;
	 			}
                 //calls multiply method when * is found and pushes to stack
                 else if(operator.equals("*")) {				
	 				number.push(multiply(expression));
	 			}
                 //calls divide method when / is found and pushes to stack
                 else if(operator.equals("/")) {			
	 				number.push(divide(expression));
	 			}
                 //negates the number when - is found and pushes to stack
                 else if(operator.equals("-")) {				
	 				number.push(subtract(expression));
	 				operatorcont.push("+");			
	 			}
                 //adds the number with get next and then pushes
                 else if(operator.equals("+")){				
	 				number.push(getNext(expression));	
	 				operatorcont.push("+");				
	 			}	
	 		}
	 		i++;										
	 	}
	 	
	 	//set sum to first item in stack
	 	double result = number.pop();
	 	//while the stack is not empty || there isnt a parenthesis, continue adding
	 	while(!number.isEmpty() && !operatorcont.peek().equals("(")) {
	 		result += number.pop();
	 		operatorcont.pop();	
	 	}
	 	//removes ( from the stack
	 	if(!operatorcont.isEmpty() && operatorcont.peek().equals("(")) {
	 		operatorcont.pop();
	 	}
	 	//pushes result to the stack
	 	number.push(result);
	 	return result;
	}
	
	//multiply method, multiplies popped num with the next number
	public static double multiply(String[] ops) {
		return number.pop() * getNext(ops);
	}
	
	//divide method
	public static double divide(String[] ops) {
		return number.pop() / getNext(ops);
	}
	//subtract method
	public static double subtract(String[] ops) {
		return -1 * getNext(ops);
	}
	//method that gets the next number in string
	public static double getNext(String[] arr) {
		i++;		
        //checks if the expression is in the parenthesis, if so, pushes			
		if(arr[i].equals("(")) {	
			operatorcont.push("(");	
			i++;					
			work(arr);				
			return number.pop();
		}
        else{
			//if not a parenthesis then its a digit, returns the digit     
			return Double.parseDouble(arr[i]);
		}
	}
    public static void main(String[] args) {
		String exp = ("10 * ( 15 + 2 ) / 17");			
		String[] expression = exp.split(" ");
		System.out.println(work(expression));
	}
}
/*
Test cases
Input was 0:
The code would handle this by returning 0.0

Input is an empty string ""
The code would throw an exception.

Input was nor digit or operator ie. "hello"
The code throws an exception.

Input is multiple parenthesis, "10 * 2 ( 10 * 2 ( 3 + 4 ) )"
Throws an exception
*/

//PART 2
/*
Array deque may be faster than stack as it only needs to push an object
into an array and then update an index, while stack has to allocate a new 
object and update links everytime an item is added. In addition to this,
deque inserts and deletes from the stack from the front and rear.This is how 
deque may improve upon our calculator program. The program as of now is reliant on
stack which is one directional, only being able to insert and delete from one direction. 
Deque has insertion and deletion on both ends of the stack.
*/


