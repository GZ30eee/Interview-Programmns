// Definition for a binary tree node.
class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}

public class BinarySearchTree82 {
    TreeNode root;

    // Constructor
    public BinarySearchTree82() {
        root = null;
    }

    // Insert a new key
    public void insert(int key) {
        root = insertRec(root, key);
    }

    // Recursive function to insert a new key
    private TreeNode insertRec(TreeNode root, int key) {
        if (root == null) {
            root = new TreeNode(key);
            return root;
        }
        if (key < root.key) {
            root.left = insertRec(root.left, key);
        } else if (key > root.key) {
            root.right = insertRec(root.right, key);
        }
        return root;
    }

    // Delete a key
    public void delete(int key) {
        root = deleteRec(root, key);
    }

    // Recursive function to delete a key
    private TreeNode deleteRec(TreeNode root, int key) {
        if (root == null) return root;

        // Traverse the tree
        if (key < root.key) {
            root.left = deleteRec(root.left, key);
        } else if (key > root.key) {
            root.right = deleteRec(root.right, key);
        } else { // Node with the key found
            // Node with only one child or no child
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.key = minValue(root.right);

            // Delete the inorder successor
            root.right = deleteRec(root.right, root.key);
        }
        return root;
    }

    // Function to find the minimum value in a tree
    private int minValue(TreeNode root) {
        int minv = root.key;
        while (root.left != null) {
            minv = root.left.key;
            root = root.left;
        }
        return minv;
    }

    // Inorder traversal (Left, Root, Right)
    public void inorder() {
        inorderRec(root);
    }

    private void inorderRec(TreeNode node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.key + " ");
            inorderRec(node.right);
        }
    }

    // Preorder traversal (Root, Left, Right)
    public void preorder() {
        preorderRec(root);
    }

    private void preorderRec(TreeNode node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }

    // Postorder traversal (Left, Right, Root)
    public void postorder() {
        postorderRec(root);
    }

    private void postorderRec(TreeNode node) {
        if (node != null) {
            postorderRec(node.left);
            postorderRec(node.right);
            System.out.print(node.key + " ");
        }
    }

    public static void main(String[] args) {
        BinarySearchTree82 bst = new BinarySearchTree82();

        // Insert values into the BST
        int[] values = {50, 30, 20, 40, 70, 60, 80};
        for (int value : values) {
            bst.insert(value);
        }

        System.out.println("Inorder traversal:");
        bst.inorder(); // Should print: 20 30 40 50 60 70 80

        System.out.println("\nPreorder traversal:");
        bst.preorder(); // Should print: 50 30 20 40 70 60 80

        System.out.println("\nPostorder traversal:");
        bst.postorder(); // Should print: 20 40 30 60 80 70 50

        // Deleting elements from the BST
        bst.delete(20); // Delete leaf node
        System.out.println("\nInorder traversal after deleting 20:");
        bst.inorder(); // Should print: 30 40 50 60 70 80

        bst.delete(30); // Delete node with one child
        System.out.println("\nInorder traversal after deleting 30:");
        bst.inorder(); // Should print: 40 50 60 70 80

        bst.delete(50); // Delete node with two children
        System.out.println("\nInorder traversal after deleting 50:");
        bst.inorder(); // Should print: 40 60 70 80
    }
}
