package graph.prims;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Primsss {
    public static void main(String[] args) {
        Primsss primsss = new Primsss();
        primsss.prims(new int[][]{ { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } });
    }


    public void prims(int[][] graph) {
        boolean[] visited = new boolean[graph.length];
        int[] parent = new int[graph.length];
        int[] minDistance = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            visited[i] = false;
            minDistance[i] = Integer.MAX_VALUE;
        }
        minDistance[0] = 0;
        parent[0] = -1;
        for (int i = 0; i < graph.length; i++) {
            int u = minDistance(visited, minDistance);
            visited[u] = true;
            for (int v = 0; v < graph.length; v++) {
                if (visited[v] == false && graph[u][v] != 0 && graph[u][v] < minDistance[v]) {
                    parent[v] = u;
                    minDistance[v] = graph[u][v];
                }

            }
        }
        for (int i = 0; i < graph.length; i++) {
            System.out.println(i + "--" + parent[i] + " =  " + minDistance[i]);
        }

    }


    public int minDistance(boolean[] visited, int[] distance) {
        int max = Integer.MAX_VALUE, vertex = -1;
        for (int v = 0; v < visited.length; v++) {
            if (visited[v] == false && distance[v] < max) {
                max = distance[v];
                vertex = v;
            }
        }
        return vertex;
    }
}
