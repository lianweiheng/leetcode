package tree.code;

import tree.utils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class MergeBinarySearchTree {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer>
                l1 = new ArrayList(),
                l2 = new ArrayList(),
                ans = new ArrayList();
        inOrderTraversal(root1, l1);
        inOrderTraversal(root2, l2);

        int i1 = 0, i2 = 0;
        while (i1 < l1.size() | i2 < l2.size()) {
            if (i2 < l2.size() && (i1 == l1.size() || l2.get(i2) < l1.get(i1))) {
                ans.add(l2.get(i2 ++));
            } else {
                ans.add(l1.get(i1 ++));
            }
        }
        return ans;
    }

    void inOrderTraversal(TreeNode node, List<Integer> l) {
        if (node == null) return;
        inOrderTraversal(node.left, l);
        l.add(node.val);
        inOrderTraversal(node.right, l);
    }

}
