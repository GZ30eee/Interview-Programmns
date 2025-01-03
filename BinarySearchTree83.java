// Definition for a binary tree node.
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinarySearchTree83 {
    private TreeNode root;

    // Method to insert a new value in the BST
    public void insert(int val) {
        root = insertRec(root, val);
    }

    private TreeNode insertRec(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
            return root;
        }
        if (val < root.val) {
            root.left = insertRec(root.left, val);
        } else if (val > root.val) {
            root.right = insertRec(root.right, val);
        }
        return root;
    }

    // Inorder traversal (Left, Root, Right)
    public void inorderTraversal(TreeNode node) {
        if (node != null) {
            inorderTraversal(node.left);
            System.out.print(node.val + " ");
            inorderTraversal(node.right);
        }
    }

    // Preorder traversal (Root, Left, Right)
    public void preorderTraversal(TreeNode node) {
        if (node != null) {
            System.out.print(node.val + " ");
            preorderTraversal(node.left);
            preorderTraversal(node.right);
        }
    }

    // Postorder traversal (Left, Right, Root)
    public void postorderTraversal(TreeNode node) {
        if (node != null) {
            postorderTraversal(node.left);
            postorderTraversal(node.right);
            System.out.print(node.val + " ");
        }
    }

    // Main method to test the implementation
    public static void main(String[] args) {
        BinarySearchTree83 bst = new BinarySearchTree83();
        
        // Insert values into the BST
        int[] values = {50, 30, 20, 40, 70, 60, 80};
        for (int value : values) {
            bst.insert(value);
        }

        System.out.println("Inorder Traversal:");
        bst.inorderTraversal(bst.root); // Should print: 20 30 40 50 60 70 80

        System.out.println("\nPreorder Traversal:");
        bst.preorderTraversal(bst.root); // Should print: 50 30 20 40 70 60 80

        System.out.println("\nPostorder Traversal:");
        bst.postorderTraversal(bst.root); // Should print: 20 40 30 60 80 70 50
    }
}
