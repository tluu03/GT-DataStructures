public class lab11p1{
    public static void main(String[] args){
        //tree with nodes
        lab11p1 tree = new lab11p1();
        tree.root = new Node(4);
        tree.root.left = new Node(2);
        tree.root.right = new Node(6);
        tree.root.left.left = new Node(1);
        tree.root.left.right = new Node(3);
        tree.root.right.left = new Node(5);
        tree.root.right.right = new Node(7);
        tree.inorder();
    }
    //given node class
    static class Node{
        int data;
        Node left, right;
        public Node(int item){
            data = item;
            left = null;
            right = null;
        }
    }
    //setting root to null
    Node root;
    lab11p1(){
         root = null;
    }
    //insert, sets the root to the result of insertres
    void insert(int key){
         root = insertres(root, key);
    }
    //returns root if the key is greater than the data at root, but moves root left if otherwise
    Node insertres(Node root, int key){
        if (root == null){
            root = new Node(key);
            return root;
        }
        if (key < root.data)
            root.left = insertres(root.left, key);
        else if (key > root.data)
            root.right = insertres(root.right, key);
        return root;
    }
    //returns the the root after calling inorderret
    void inorder(){
         inorderret(root);
    }
    //returns the inorder root, calls recursively 
    void inorderret(Node root){
        if (root != null) {
            inorderret(root.left);
            System.out.printf("%s ", root.data);
            inorderret(root.right);
        }
    }
}
/*Test Cases:
 * Node values: 5,6,7,2,3,4,1
 * Output: 1,2,3,4,5,6,7
 * If the one end of the subtree were null, it would not complete its sort, it would fail
 * If a node does not process, it would lead to the process failing
 * The tree could be lopsided, but it would still return a correct output.
 * If there are duplicate values in the tree, it would output it twice.
 */