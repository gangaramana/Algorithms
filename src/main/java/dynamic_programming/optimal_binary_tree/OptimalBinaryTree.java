package dynamic_programming.optimal_binary_tree;

public class OptimalBinaryTree {
    public static void main(String[] args) {
        OptimalBinaryTree optimalBinaryTree = new OptimalBinaryTree();
        int k = optimalBinaryTree.optimalSearchTree(new int[]{10, 12, 20}, new int[]{34, 8, 50}, 3);
        System.out.println(k);

    }

    public int optimalSearchTree(int[] keys, int[] freq, int length) {
        int[][] cost = new int[length + 1][length + 1];
        for (int i = 0; i < length; i++) {
            cost[i][i] = freq[i];
        }

        for (int L = 2; L <= length; L++) {
            for (int i = 0; i <= length - L + 1; i++) {
                int j = i + L - 1;
                cost[i][j] = Integer.MAX_VALUE;
                for (int r = i; r <= j; r++) {
                    int c = ((r > i) ? cost[i][r - 1] : 0) + ((r < j) ? cost[r + 1][j] : 0) + sum(freq, i, j);
                    if (c < cost[i][j]) {
                        cost[i][j] = c;
                    }

                }
            }
        }
        return cost[0][length - 1];
    }

    public int sum(int freq[], int i, int j) {
        int s = 0;
        for (int k = i; k <= j; k++) {
            if (k >= freq.length)
                continue;

            s = s + freq[k];

        }
        return s;
    }

}
