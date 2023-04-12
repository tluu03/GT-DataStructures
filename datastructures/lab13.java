import java.util.*;
//Given class representing a directed graph using adjacency list
class lab13{
    int V;//Number of Vertice
    LinkedList<Integer> adj[]; ;// adjacency list
    // Constructor
    lab13(int V){
        this.V = V;
        adj = new LinkedList[V];
        for (int i = 0; i < adj.length; i++)
            adj[i] = new LinkedList < Integer>();
    }
 
    //To add an edge to graph
    void addEdge(int v, int w){
        adj[v].add(w);  // Add w to the list of v
    }
    //main method, passes values, calls BFS
    public static void main(String args[]){
        lab13 g = new lab13(6);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 3);
        g.addEdge(3, 5);
        g.BFS(2);
    }
 
    //BFS Method, prints BFS and checks verticies as false
    void BFS(int x){
        boolean passed[] = new boolean[V];
        //Creates queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();
        //Marks as passed and adds to queue
        passed[x] = true;
        queue.add(x);
        //runs while queue size is not empty
        while (queue.size() != 0){
            //dequeues and prints
            x = queue.poll();
            System.out.print(x + " ");
            
            //If adjacent vertex has not been visited, mark as passed and enqueue
            Iterator<Integer> i = adj[x].listIterator();
            while (i.hasNext()){
                int n = i.next();
                if (!passed[n]){
                    passed[n] = true;
                    queue.add(n);
                }
            }
        }
    }
}
/* Test Cases:
 * Node values: 
 * g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 3);
        g.addEdge(3, 5);
        g.BFS(2);
 * Output: 2 3 4 5
 * If the one end of the subtree were null, it would not complete its sort, it would fail
 * If queue is empty to begin with code terminates
 */