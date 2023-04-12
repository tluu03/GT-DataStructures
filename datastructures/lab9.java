import java.util.*;
public class lab9 {
    //creates linked list called main queue
    Queue<Integer> mainQueue = new LinkedList<>();
    //creates max queue
    ArrayDeque<Integer> maxQueue = new ArrayDeque<>();
    public static void main(String[] args){
        lab9 queue = new lab9();
        Scanner in = new Scanner(System.in);
        //gets the first number, prints the queue
        System.out.print("Enter a number: ");
        int x1 = in.nextInt();
        queue.enqueue(x1);
        System.out.println(queue);
        //prints max queue, takes the second value and queues it
        System.out.printf("Max queue: " + queue.max() + "\n\nInput next number: "); 
        int x2 = in.nextInt();
        queue.enqueue(x2);
        System.out.println(queue);
        //Obtains third value, queues and prints it
        System.out.printf("Max queue: " + queue.max() + "\n\nInput next number: ");
        int x3 = in.nextInt();
        queue.enqueue(x3);
        System.out.println(queue);
        //dequeues items in queue
        System.out.print("Max queue: " + queue.max()+", ");
        queue.dequeue();
        queue.dequeue();
        System.out.println(queue.max());
        queue.dequeue();
        //Obtains fourth value and then enqueues everything and prints the queue
        System.out.printf("\nInput next number: ");
        int x4 = in.nextInt();
        queue.enqueue(x1);
        queue.enqueue(x2);
        queue.enqueue(x3);
        queue.enqueue(x4);
        System.out.println(queue);
        //prints max queue, then dequeues the elements in queue
        System.out.print("Max queue: " + queue.max()+", ");
        queue.dequeue();
        queue.dequeue();
        System.out.print(queue.max());
        in.close();
    }
    //enqueue method
    public void enqueue(int y){
        //only removes last while the max queue is empty and the last value is less than our value
        while(!maxQueue.isEmpty() && maxQueue.getLast() < y){
            maxQueue.removeLast();
        }
        maxQueue.addLast(y);
        mainQueue.add(y);
    }
    //dequeue method, removes from queue when the first value in max is equal to the main value
    public void dequeue(){
        if(maxQueue.getFirst().equals(mainQueue.peek())){
            maxQueue.removeFirst();
        }
        mainQueue.remove();
    }
    //returns first in maxqueue
    public int max(){
        return maxQueue.getFirst();
    }
    //returns main queue in string form
    public String toString(){
        return "Main queue: " + mainQueue;
    }
}
/*
Test Cases:
Input [4, 1, 3, 2]:
Output: Max queue[4, 3]

Input null:
Keeps prompting user

Input [0,0,0,0]:
Outputs [0, 0]

Input: [5, 1, 4, 3]
Outputs [5, 4]

Input: [3, 5, 6, 6]
Outputs [6, 6]
*/