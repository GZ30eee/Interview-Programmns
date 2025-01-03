// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class InvertBinaryTree84 {

    // Function to invert the binary tree
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null; // Base case: if the node is null, return null
        }

        // Swap the left and right children
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        // Recursively invert the left and right subtrees
        invertTree(root.left);
        invertTree(root.right);

        return root; // Return the new root of the inverted tree
    }

    // Helper function to print the tree in-order (for testing purposes)
    public void printInOrder(TreeNode node) {
        if (node == null) return;
        printInOrder(node.left);
        System.out.print(node.val + " ");
        printInOrder(node.right);
    }

    public static void main(String[] args) {
        InvertBinaryTree84 ibt = new InvertBinaryTree84();

        // Creating a sample binary tree:
        //      1
        //     / \
        //    2   3
        //   / \
        //  4   5
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("Original In-Order Traversal:");
        ibt.printInOrder(root); // Output: 4 2 5 1 3

        // Invert the binary tree
        ibt.invertTree(root);

        System.out.println("\nInverted In-Order Traversal:");
        ibt.printInOrder(root); // Output: 3 1 5 2 4
    }
}
