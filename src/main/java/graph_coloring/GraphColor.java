package graph_coloring;

public class GraphColor {

    public static void main(String[] args) {
        int[][] pp = new int[][]{{4, 1}, {4, 2}, {4, 3}, {2, 5}, {1, 2}, {1, 5}};
        int noOfColrs = 4;
        Graph de = new Graph(5);
        for (int[] x : pp) {
            de.addEdge(x[0], x[1]);
        }
       int [] colors=de.colorGraph(4);
        for (int o:colors){
            System.out.println(o);
        }

    }
}

class Graph {
    private int len;
    private int[][] adjMatrix;

    Graph(int len) {
        this.len = len;
        adjMatrix = new int[len][len];
    }

    public void addEdge(int source, int destination) {
        adjMatrix[source - 1][destination - 1] = 1;
        adjMatrix[destination - 1][source - 1] = 1;
    }

    public int[] colorGraph(int noOfColors) {
        int[] colors = new int[len];
        if (!graphColorUtil(adjMatrix, noOfColors, colors, 0)) {
            System.out.println("not found");
        }
        return colors;


    }

    private boolean graphColorUtil(int[][] graph, int noOfColors, int[] color, int vertice) {
        if (vertice == len) {
            return true;
        }
        for (int i = 1; i <= noOfColors; i++) {
            if (isSafe(vertice, graph, color, i)) {
                color[vertice] = i;
                if (graphColorUtil(graph, noOfColors, color, vertice+1)) {
                    return true;
                }
                color[vertice] = 0;
            }

        }
        return false;
    }

    boolean isSafe(int vertice, int[][] graph, int[] color, int presentColor) {
        for (int i = 0; i < len; i++) {
            if (graph[vertice][i] == 1 && presentColor == color[i]) {
                return false;
            }

        }
        return true;
    }

}