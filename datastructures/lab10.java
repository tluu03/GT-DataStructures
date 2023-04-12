import java.util.ArrayDeque;
public class lab10{
    public static void main(String[] args) {
        //creates binary tree then assigns node values to certain positions in the tree
       // BinaryTree tree = new BinaryTree(); 
        tree.root = new Node(4); 
        tree.root.left= new Node(2); 
        tree.root.right= new Node(6); 
        tree.root.left.left= new Node(1); 
        tree.root.left.right= new Node(3); 
        tree.root.right.left= new Node(5); 
        tree.root.right.right= new Node(7); 
        //calls LOT(Level Order Transversal)
        LOT(tree.root);
    }
    //Level Order Transversal method
    public static void LOT(Node q) {
        //adds nodes to queue
        ArrayDeque<Node>queue = new ArrayDeque<>();
        if(q == null){
            return;
        } 
        queue.add(q);
        //loops queue until it is empty
        //pushes items into queues and removes from front
        while(!queue.isEmpty()) {
            Node x = queue.peek();
            System.out.print(x.data + " ");
            if(x.left != null){
                queue.add(x.left);
            }
            if(x.right != null){
                queue.add(x.right);
            }
            queue.remove();
        }
    }
}
//Node class
class Node {
    int data;
    Node left, right;
    
    public Node(int item) {
        data = item;
        left = null;
        right = null;
    }
}
//class BinaryTree {
    // Root of the Binary Tree
    Node root;
    public BinaryTree() {
        root = null;
    }
}

/*
Test Cases:
Node values did not form an even tree:
It would output as normal in order and level by level

Node values are trailing off to one side:
Given our time and space constrictions, it is harder to illustrate the 
levels being printed in, well, level order. But if this were the case 
in a nested while loop, it would print the trailing values one at a time
on their own level. In this program, it would print it in the same line.
*/
