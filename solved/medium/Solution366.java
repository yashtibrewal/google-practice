package solved.medium;
import java.util.ArrayList;
import java.util.List;

/**
 * Definition for a binary tree node.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    @Override
    public String toString() {
        return "{" + this.val + "}";
    }
}

class Solution366 {

    private boolean isLeaf(TreeNode node) {
        return node != null && node.left == null && node.right == null;
    }

    public void getLeaves(TreeNode root, List<Integer> leaves) {
        if (root != null) {
            if (root.left != null && isLeaf(root.left)) {
                leaves.add(root.left.val);
                root.left = null;
            } else {
                getLeaves(root.left, leaves);
            }
            if (root.right != null && isLeaf(root.right)) {
                leaves.add(root.right.val);
                root.right = null;
            } else {
                getLeaves(root.right, leaves);
            }
        }
    }

    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> leaves;
        while (!isLeaf(root)) {
            leaves = new ArrayList<>();
            getLeaves(root, leaves);
            result.add(leaves);
        }
        leaves = new ArrayList<>();
        leaves.add(root.val);
        result.add(leaves);
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode root = new TreeNode(10, new TreeNode(14), new TreeNode(15, new TreeNode(16), null));
        solution.findLeaves(root);
    }
}
