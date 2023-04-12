//given node class but modified
class Node2 { 
    int data; 
    Node2 left, right; 
    public Node2(int item){ 
        data = item; 
        left = null;
        right = null; 
    } 
}
public class lab11p2{
    public static void main(String[] args) throws Exception {
        //creates binary tree
        BinaryTree tree = new BinaryTree();
        tree.root = new Node2(4); 
        tree.root.left = new Node2(2); 
        tree.root.right = new Node2(6); 
        tree.root.left.left = new Node2(1); 
        tree.root.left.right = new Node2(3); 
        tree.root.right.left = new Node2(5);
        tree.root.right.right = new Node2(7); 
        tree.inorder();
        System.out.println();
        //calls BST, determines if it is BST or not
        if (tree.isBST())
            System.out.println("Is a BST");
        else
            System.out.println("Not a BST");
    }
}
//binary tree class, calls node
class BinaryTree { 
    Node2 root;
    //inorder method, sets root
    public void inorder(){ 
        inorder(root);
    } 
    //Calls BST2 or the actual checking method
    public boolean isBST() {
        return BST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean BST2(Node2 node, int min, int max){
        //if node is null, return true
        if (node == null){
            return true;
        }
        //returns false if node data is less than min and greater than max
        if (node.data < min || node.data > max){
            return false;
        }
        //Checks subtrees recursively
        return (BST2(node.left, min, node.data - 1) && BST2(node.right, node.data + 1, max));
    }
    //takes node and prints its data, if null, returns
    private void inorder(Node2 node) { 
        if (node == null) { 
            return; 
        } 
        inorder(node.left); 
        System.out.printf("%s ", node.data); 
        inorder(node.right); 
    } 
}
/* Test Cases:
 * Node values: 5,6,7,2,3,4,1
 * Output: 1,2,3,4,5,6,7
 * If the one end of the subtree were null, it would not complete its sort, it would fail
 * If a node does not process, it would lead to the process failing
 * The tree could be lopsided, but it would still return a correct output.
 * If there are duplicate values in the tree, it would output it twice.
 * If any of the conditions fail in the checking, it will display not a BST
 */