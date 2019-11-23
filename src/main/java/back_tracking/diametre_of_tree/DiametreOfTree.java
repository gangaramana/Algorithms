package back_tracking.diametre_of_tree;

import java.util.HashMap;
import java.util.HashSet;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class DiametreOfTree {
    public static void main(String[] args) {
        DiametreOfTree diametreOfTree = new DiametreOfTree();
        HashMap<TreeNode, Integer> hashMap = new HashMap<TreeNode, Integer>();
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
//        node.left.left = new TreeNode(3);
//        node.left.right = new TreeNode(4);
//        node.left.right.right = new TreeNode(5);
        node.right = new TreeNode(6);
        diametreOfTree.height(node, hashMap);
        hashMap.put(null, 0);
        int x=diametreOfTree.diametreOfTree(node, hashMap);
        System.out.println(x);
    }

    public int diametreOfTree(TreeNode node, HashMap<TreeNode, Integer> hashMap) {
        if (node == null) {
            return 0;
        }

        int leftHeight = hashMap.get(node.left);
        int rightHeight = hashMap.get(node.right);

        int leftDiametre = diametreOfTree(node.left, hashMap);
        int rightDIametre = diametreOfTree(node.right, hashMap);

        return Math.max(1 + leftHeight + rightHeight, Math.max(leftDiametre, rightDIametre));

    }

    public int height(TreeNode node, HashMap<TreeNode, Integer> hashMap) {

        if (node == null) {
            return 0;
        } else {

            hashMap.put(node, 1 + Math.max(height(node.left, hashMap), height(node.right, hashMap)));
            return hashMap.get(node);
        }

    }
}
