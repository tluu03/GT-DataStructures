public class assignment3 {
    //given node class
    static class Node {
        int data;
        Node left, right;
        public Node(int item){
            data = item;
            left = null;
            right = null;
        }
    }
    Node root = null;
    public static void main(String[] args) {
        //given root elements
        assignment3 tree = new assignment3();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);
        tree.del(tree.root, tree.root.data);
        tree.order(tree.root);
        if (tree.isBST())
            System.out.println("Is a BST");
        else
            System.out.println("Not a BST");
    }
    //sets root
    public void order(){ 
        order(root);
    } 
    //Calls BST2 or the actual checking method
    public boolean isBST() {
        return BST2(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    boolean BST2(assignment3.Node root2, int min, int max){
        //if node is null, return true
        if (root2 == null){
            return true;
        }
        //returns false if node data is less than min and greater than max
        if (root2.data < min || root2.data > max){
            return false;
        }
        //Checks subtrees recursively
        return (BST2(root2.left, min, root2.data - 1) && BST2(root2.right, root2.data + 1, max));
    }
    //recursive inorder method
    public void order(Node root) {
        //runs if root isnt null
        if (root != null) {
            order(root.left);
            //prints root data  
            System.out.print(root.data + " ");
            order(root.right);
        }
    }
    //deletion method
    //nested if statement
    public Node del(Node root, int data) {
        //if roots null, just return
        if (root == null){
            return root;
        }
        //if data is less than the data the root contains, delete left root data
        if (data < root.data){
            root.left = del(root.left, data);
        } 
        //if not, remove right
        else if (data > root.data) {
            root.right = del(root.right, data);
        } 
        else {
            //if left is null, return right
            if (root.left == null) {
                return root.right;
            } 
            //returns left if right is null
            else if (root.right == null) {
                return root.left;
            }
            root.data = min(root.right);
            root.right = del(root.right, root.data);
        }
        return root;
    }
    //minimum value method
    public int min(Node root) {
        int value = root.data;
        //while loop runs under the condition that the left node is not null
        while (root.left != null) {
            value = root.left.data;
            root = root.left;
        }
        return value;
    }
}

/* Test Cases:
 * Node values: 
 * tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);
 * Output: 1,2,3,5,6,7 Is a BST
 * If the one end of the subtree were null, it would not complete its sort, it would fail
 * If any of the conditions for BST fails, displays that it is not a BST
 */
