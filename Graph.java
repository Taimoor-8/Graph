package Graph;

//Graph by using Matrix

/*public class Graph {

    private int vertices;
    private int edge;
    private int [][] adjMatrix;

    public Graph(int node){
        this.vertices = node;
        this.edge = 0;
        this.adjMatrix = new int[node][node];
    }

    public void addEdge(int u , int v){
        adjMatrix[u][v] = 1;
        adjMatrix[v][u] = 1;
        edge++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(vertices + " vertices " + edge + " edges \n");
        for (int v = 0; v < vertices; v++){
            sb.append(v + " : ");
            for (int k : adjMatrix[v]){
                sb.append(k + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        Graph g = new Graph(4);
        g.addEdge(1 ,0);
        g.addEdge(1 , 2);
        g.addEdge(2 , 3);
        g.addEdge(3 , 0);

        System.out.println(g);
    }
}*/

//Graph by using List

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Graph {

    private LinkedList<Integer> [] adj;
    private int edge;
    private int vertices;

    public Graph(int node){
        this.vertices = node;
        this.edge = 0;
        this.adj = new LinkedList[node];
        for (int v = 0; v < vertices; v++){
            adj[v] = new LinkedList<>();
        }
    }

    public void addEdge(int v , int u){
        adj[v].add(u);
        adj[u].add(v);
        edge++;
    }

    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append(vertices + " vertices " + edge + " edge \n");
        for (int v = 0; v < vertices; v++){
            sb.append(v + " : ");

            for (int k : adj[v]){
                sb.append(k + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    public void breathFirstSearch(int s){
        boolean [] isVisited = new boolean[vertices];
        Queue <Integer> q = new LinkedList<>();
        isVisited[s] = true;
        q.offer(s);

        while (!q.isEmpty()){
            int u = q.poll();
            System.out.print(u + " ");
            for (int v : adj[u]){
                if (!isVisited[v]){
                    q.offer(v);
                    isVisited[v] = true;
                }
            }
        }
    }

    /*public void depthFirstSearch(int s) {
        boolean[] isVisited = new boolean[vertices];
        Stack<Integer> stack = new Stack<>();
        stack.push(s);

        while (!stack.isEmpty()) {
            int u = stack.pop();
            if (!isVisited[u]) {
                isVisited[u] = true;
                System.out.print(u + " ");
                for (int v : adj[u]) {
                    if (!isVisited[v]) {
                        stack.push(v);

                    }
                }
            }
        }
    }*/

    public void depthFirstSearch(){
        boolean [] isVisited = new boolean[vertices];
        for (int v = 0; v < vertices; v++){
            if (!isVisited[v]){
                depthFirstSearch(v , isVisited);
            }
        }
    }

    private void depthFirstSearch(int v, boolean[] isVisited) {
        isVisited[v] = true;
        System.out.print(v + " ");
        for (int u : adj[v]){
            if (!isVisited[u]){
                depthFirstSearch(u , isVisited);
            }
        }
    }

    public static void main(String[] args) {

        Graph g = new Graph(5);
        g.addEdge(0 , 1);
        g.addEdge(1 , 2);
        g.addEdge(2 , 3);
        g.addEdge(3 , 0);
        g.addEdge(2 , 4);

        System.out.println(g);

        System.out.println();

        System.out.println("The breath first iteration of the graph is ");
        g.breathFirstSearch(0);
        System.out.println();

//        Iterative approach
        /*System.out.println("The depth first iteration of the graph is ");
        g.depthFirstSearch(0);*/

//        Recursive approach
        System.out.println("The depth first iteration of the graph is ");
        g.depthFirstSearch();
    }
}