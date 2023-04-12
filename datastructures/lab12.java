import java.util.*;
//solving iteratively
//public class function
public class lab12{
    private int V; 
    private LinkedList<Integer> adj[];
    public static void main(String args[])
    {
        lab12 g = new lab12(6);
        //given edges
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 3);
        g.addEdge(3, 5);
        //calls DFS
        g.DFS();
    }

    //given graph function
    public lab12(int V){
        this.V = V;
        adj = new LinkedList[V];
        
        for (int i = 0; i < adj.length; i++)
            adj[i] = new LinkedList<Integer>();
        }

    //method to add edges
    void addEdge(int v, int w){
        adj[v].add(w); 
    }

    //DFSUTIL nethod
    void DFSUtil(int v, boolean visited[]){
        //when visited, make true
        visited[v] = true;
        System.out.print(v + " ");
        //what drives the list
        Iterator<Integer> i = adj[v].listIterator();
        while (i.hasNext()) {
            int n = i.next();
            if (!visited[n])
                DFSUtil(n, visited);
        }
    }

    //DFS method
    void DFS(){
        boolean visited[] = new boolean[V];
        //for loop for visited values
        for (int i = 0; i < V; ++i)
            if (visited[i] == false)
                DFSUtil(i, visited);
    }
}
/* Test Cases:
 * Graph Values:  
 *      g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(2, 3);
        g.addEdge(2, 4);
        g.addEdge(4, 5);
        g.addEdge(1, 3);
        g.addEdge(3, 5);
 * Output: 0, 1, 3, 5, 2, 4
 * If the one end of the graph were null, it would not complete its sort, it would fail
 * The graph may have a tail end which would be handled by outpting last
 * If there are duplicate values in the tree, it would output it twice.
 */