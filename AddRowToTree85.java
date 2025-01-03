class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
        left = null;
        right = null;
    }
}

public class AddRowToTree85 {
    public TreeNode addRowToTree(TreeNode root, int val, int depth) {
        if (root == null) {
            return new TreeNode(val);
        }
        return addRowToTreeHelper(root, val, depth, 1);
    }

    private TreeNode addRowToTreeHelper(TreeNode node, int val, int targetDepth, int currentDepth) {
        if (currentDepth == targetDepth - 1) {
            TreeNode newNode = new TreeNode(val);
            newNode.left = node.left;
            newNode.right = node.right;
            node.left = newNode;
            node.right = newNode;
            return node;
        }

        if (currentDepth < targetDepth - 1) {
            if (node.left != null) {
                node.left = addRowToTreeHelper(node.left, val, targetDepth, currentDepth + 1);
            }
            if (node.right != null) {
                node.right = addRowToTreeHelper(node.right, val, targetDepth, currentDepth + 1);
            }
        }

        return node;
    }

    public static void main(String[] args) {
        // Create a binary tree
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(1);
        root.right.left = new TreeNode(5);

        // Add a row of nodes with value 1 at depth 2
        AddRowToTree85 addRow = new AddRowToTree85();
        TreeNode newRoot = addRow.addRowToTree(root, 1, 2);

        // You can add code here to print or traverse the modified tree
        System.out.println("Tree modified with new row added.");
    }
}