package tree.utils;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TreeUtils {

    public static TreeNode generateTree(List<Integer> nodeVals) throws Exception {
        if (nodeVals == null || nodeVals.size() == 0) {
            throw new IllegalArgumentException("Input is empty");
        }
        if (nodeVals.get(0) == null) return null;
        TreeNode root = new TreeNode(nodeVals.get(0));
        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();
        q1.offer(root);
        int st = 0;
        while (true) {
            for (TreeNode node: q1) {
                if (++st >= nodeVals.size()) {
                    q1.clear();
                    q2.clear();
                    break;
                }
                Integer leftVal = nodeVals.get(st);
                if (leftVal != null) {
                    TreeNode leftNode = new TreeNode(leftVal);
                    node.left = leftNode;
                    q2.offer(leftNode);
                }
                if (++st >= nodeVals.size()) {
                    q1.clear();
                    q2.clear();
                    break;
                }
                Integer rightVal = nodeVals.get(st);
                if (rightVal != null) {
                    TreeNode rightNode = new TreeNode(rightVal);
                    node.right = rightNode;
                    q2.offer(rightNode);
                }
            }
            if (q2.isEmpty()) break;
            q1.clear();
            q1.addAll(q2);
            q2.clear();
        }
        if (st < nodeVals.size() - 1) {
            throw new IllegalArgumentException("Input is not valid");
        }
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) {
            System.out.println("null");
            return;
        }
        int depth = 0;
        Queue<TreeNode> q1 = new LinkedList();
        Queue<TreeNode> q2 = new LinkedList();
        q1.offer(root);
        while (true) {
            for (TreeNode node: q1) {
                printNode(node, depth);
                if (node != null) {
                    q2.offer(node.left);
                    q2.offer(node.right);
                }
            }
            if (q2.isEmpty()) break;
            q1.clear();
            q1.addAll(q2);
            q2.clear();
            depth ++;
        }
    }

    private static void printNode(TreeNode node, int depth) {
        System.out.print(depth + "@ ");
        if (node == null) {
            System.out.println("null");
        } else{
            System.out.println(node.val);
        }
    }
}
