package graph.dijkristas;

public class Dijkstra {
    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        dijkstra.dijkstraImp(new int[][]{{0, 4, 0, 0, 0, 0, 0, 8, 0}, {4, 0, 8, 0, 0, 0, 0, 11, 0}, {0, 8, 0, 7, 0, 4, 0, 0, 2}, {0, 0, 7, 0, 9, 14, 0, 0, 0}, {0, 0, 0, 9, 0, 10, 0, 0, 0}, {0, 0, 4, 14, 10, 0, 2, 0, 0}, {0, 0, 0, 0, 0, 2, 0, 1, 6}, {8, 11, 0, 0, 0, 0, 1, 0, 7}, {0, 0, 2, 0, 0, 0, 6, 7, 0}}, 0);

    }

    public void dijkstraImp(int[][] graph, int source) {
        int[] dist = new int[graph.length];
        boolean[] visited = new boolean[graph.length];
        int[] parent = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            dist[i] = Integer.MAX_VALUE;
            visited[i] = false;
        }
        dist[source] = 0;


        for (int v = 0; v < graph.length; v++) {
            int min = findMin(dist, visited);
            visited[min] = true;
            for (int k = 0; k < graph.length; k++) {
                if (!visited[k] && graph[min][k] != 0 && dist[min] != Integer.MAX_VALUE && dist[min] + graph[min][k] < dist[k]) {
                    dist[k] = dist[min] + graph[min][k];
                    parent[k] = min;
                }
            }
        }

        for (int i = 0; i < dist.length; i++) {
            System.out.println(i + "     " + dist[i]+"  parent  "+parent[i]);
        }

    }

    public int findMin(int[] dist, boolean[] visited) {
        int min = 1, dis = Integer.MAX_VALUE;
        for (int k = 0; k < dist.length; k++) {
            if (!visited[k] && dist[k] <= dis) {
                dis = dist[k];
                min = k;
            }

        }
        return min;

    }
}
