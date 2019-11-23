package graph.bellman_ford;


import java.util.ArrayList;
import java.util.List;

class Graph {
    class Edge {
        int src, dest, weight;

        public Edge(int src, int dest, int weight) {
            this.src = src;
            this.dest = dest;
            this.weight = weight;
        }

    }

    private int[][] adjList;
    private int vertices;
    private List<Edge> list;

    public Graph(int size) {
        this.adjList = new int[size][size];
        vertices = size;
        list = new ArrayList<>();

    }

    public void addEdge(int src, int dest, int weight) {
        list.add(new Edge(src, dest, weight));
        adjList[src][dest] = weight;
        adjList[dest][src] = weight;
    }

    public void bellmanFord( int vertex) {
        int[] distance = new int[vertices];
        for (int i = 0; i < vertices; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        distance[vertex] = 0;
        for (int i = 0; i < vertices; i++) {
            for (Edge e : list) {
                if ((distance[e.src] != Integer.MAX_VALUE || distance[e.dest] != Integer.MAX_VALUE) && distance[e.src] + adjList[e.src][e.dest] < distance[e.dest]) {
                    distance[e.dest] = distance[e.src] + adjList[e.src][e.dest];
                }
            }
        }
        for (int k=0;k<distance.length;k++) {
            System.out.println(k +"    "+distance[k]);
        }
    }
}

public class Bellman {
    public static void main(String[] args) {
        Graph graph = new Graph(4);
        graph.addEdge(0,1,4);
        graph.addEdge(0,3,5);
        graph.addEdge(3,2,3);
        graph.addEdge(1,2,-10);
        graph.bellmanFord(0);
    }


}
