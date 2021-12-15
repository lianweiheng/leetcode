import tree.utils.TreeNode;
import tree.utils.TreeUtils;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        List<Integer> list= Arrays.asList(1, 2, null, 4, null, null, 5);
        TreeNode treeNode = TreeUtils.generateTree(list);
        TreeUtils.printTree(treeNode);
    }
}
