// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class SecondMinimumNode51 {

    private int firstMin;
    private int secondMin;

    public int findSecondMinimumValue(TreeNode root) {
        firstMin = root.val; // Initialize first minimum as root's value
        secondMin = -1; // Initialize second minimum as -1 (indicating no value found)
        dfs(root);
        return secondMin;
    }

    private void dfs(TreeNode node) {
        if (node == null) return;

        // Check if the current node's value is greater than firstMin
        if (node.val > firstMin) {
            // Update secondMin if it's not set or if current node's value is smaller
            if (secondMin == -1 || node.val < secondMin) {
                secondMin = node.val;
            }
        } else if (node.val == firstMin) {
            // Continue searching in children
            dfs(node.left);
            dfs(node.right);
        }
    }

    public static void main(String[] args) {
        // Constructing the special binary tree
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        SecondMinimumNode51 solution = new SecondMinimumNode51();
        
        int result = solution.findSecondMinimumValue(root);
        
        System.out.println("The second minimum value in the tree is: " + result); // Output: 5
    }
}
