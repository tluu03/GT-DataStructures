import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;
public class assignment2_TonyLuu{
	public static void main(String[] args) {   	
		
        String expression = "10 * ( 2 + 15 ) / 17";    
        System.out.println(expression + " = " + solveExpression(expression));
    }
    
    private static int solveExpression(String expression) {
        char[] charArray = expression.toCharArray();
        
        // Stack for numbers 
        Stack<Integer> numbers = new Stack<Integer>();
        // Stack for the operators
        Stack<Character> operators = new Stack<Character>();
        
        for (int i = 0; i < charArray.length; i++) {    
            // if character is whitespace it gets skipped
            if (charArray[i] == ' ')
                continue;
            // if character is a number push it to stack of numbers
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                StringBuffer sbuf = new StringBuffer();
                
                // while loop checks to see that next char is part of the whole number if it is it gets appended to form the whole number
                while (i < charArray.length && charArray[i] >= '0' && charArray[i] <= '9')
                    sbuf.append(charArray[i++]); 
                
                // adds whole number to numbers stack
                numbers.push(Integer.parseInt(sbuf.toString()));  
                
                // since you had to look forward to compare the next char index in the while loop i is too far ahead for the for loop 
                // which is why it needs to be decreased by one
                i--;
            }
            // if current char is a '(' push it into operator stack
            else if (charArray[i] == '(')
                operators.push(charArray[i]);
            // if current char is a ')' solve entire brace
            else if (charArray[i] == ')')
            {
                while (operators.peek() != '(')
                numbers.push(evaluate(operators.pop(),numbers.pop(),numbers.pop()));
                operators.pop();
            }
            // Current char is an operator
            else if (charArray[i] == '+' ||charArray[i] == '-' || charArray[i] == '*' || charArray[i] == '/') {
            	// check weather the current char has same or greater precedence than the operator in the top of the operator stack
            	// apply the operator on the top of the operator stack to the top two numbers in the numbers stack
                while (!operators.empty() && hasPrecedence(charArray[i], operators.peek()))
                numbers.push(evaluate(operators.pop(),numbers.pop(),numbers.pop()));
                
                // Push current current operator to operator stack
                operators.push(charArray[i]);
            }
        }
        // after reading the entire expression apply the rest of the operations to the remaining values
        while (!operators.empty())
            numbers.push(evaluate(operators.pop(),numbers.pop(), numbers.pop()));
       
        // Remaining number in the numbers stack will contain the result
        return numbers.pop();
    }
    
    // method checks for precedence
    public static boolean hasPrecedence(char operator_1, char operator_2)
    {
        if ( operator_2 == ')' || operator_2 == '(' )
            return false;
        if (  (operator_2 == '+' || operator_2 == '-') && (operator_1 == '*' || operator_1 == '/'))
            return false;
        else
            return true;
    }
   
    // method to evaluate one operator and two numbers
    public static int evaluate(char operator,int numb2, int numb1)
    {
        switch (operator)
        {
        case '+':
            return numb1 + numb2;
        case '-':
            return numb1 - numb2;
        case '*':
            return numb1 * numb2;
        case '/':
            if (numb2 == 0)
                throw new UnsupportedOperationException("You cannot divide by zero");
            return numb1 / numb2;
        }
        return 0;
    }
}
/*Array deque may be faster than stack as it only needs to push an object
into an array and then update an index, while stack has to allocate a new 
object and update links everytime an item is added. In addition to this,
deque inserts and deletes from the stack from the front and rear.This is how 
deque may improve upon our calculator program. The program as of now is reliant on
stack which is one directional, only being able to insert and delete from one direction. 
Deque has insertion and deletion on both 
ends of the stack.*/