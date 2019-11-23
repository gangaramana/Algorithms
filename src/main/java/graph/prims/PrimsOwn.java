package graph.prims;

import java.util.*;

public class PrimsOwn {
    public static void main(String[] args) {
        Graph graph = new Graph(5);
        graph.addEdge(0, 1, 2);
        graph.addEdge(1, 2, 4);
        graph.addEdge(1, 3, 3);
        graph.addEdge(0, 4, 1);
        graph.addEdge(2, 4, 6);
    }
}


class Graph {
    private int[][] adjList;
    private int vertices;

    Graph(int size) {
        this.vertices = size;
        adjList = new int[size][size];
    }

    public void addEdge(int src, int dest, int weight) {
        adjList[src][dest] = weight;
        adjList[dest][src] = weight;
    }

    public List<Integer> bfs(int vertice) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(vertice);
        boolean[] visited = new boolean[vertices];
        List<Integer> list = new ArrayList<Integer>();
        list.add(vertice);
        visited[vertice] = true;
        while (!queue.isEmpty()) {
            int x = queue.remove();

            for (int i = 0; i < vertices; i++) {
                if (adjList[x][i] != 0 && visited[i] == false) {
                    list.add(i);
                    visited[i] = true;
                    queue.add(i);
                }
            }

        }
        return list;
    }

    public List<Integer> dfs(int vertice) {
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(vertice);
        List<Integer> result = new ArrayList<Integer>();
        boolean[] visited = new boolean[vertices];
        visited[vertice] = true;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            result.add(v);
            for (int i = 0; i < vertices; i++) {
                if (visited[i] == false && adjList[v][i] != 0) {
                    stack.add(i);

                    visited[i] = true;
                }
            }
        }
        return result;
    }

    public void prims() {

    }
}
