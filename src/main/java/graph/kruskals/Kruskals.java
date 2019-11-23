package graph.kruskals;

import graph.prims.Primsss;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Triplet {
    public Triplet(int src, int dest, int weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    int src, dest, weight;
}

public class Kruskals {

    public static void main(String[] args) {
        Kruskals kruskals = new Kruskals();
        kruskals.kruskals(new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}});

    }

    public void kruskals(int[][] graph) {
        PriorityQueue<Triplet> priorityQueue = new PriorityQueue<Triplet>(new Comparator<Triplet>() {
            public int compare(Triplet o1, Triplet o2) {
                return o1.weight - o2.weight;
            }
        });
        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[0].length; j++) {
                if (graph[i][j] != 0) {
                    priorityQueue.add(new Triplet(i, j, graph[i][j]));
                }
            }
        }
        int edgeCount = 0;
        List<Triplet> l = new ArrayList<>();
        boolean[] visited = new boolean[graph.length];

        while (edgeCount != graph.length - 1) {
            Triplet t = priorityQueue.remove();
            if (!(visited[t.src] == true && visited[t.dest] == true)) {
                visited[t.src] = visited[t.dest] = true;
                l.add(t);
                edgeCount++;
            }



        }
        for (Triplet k : l) {
            System.out.println(k.src + "   " + k.dest + "  " + k.weight);
        }
    }
}

