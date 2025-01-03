import java.util.HashMap;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class BinaryTreeFromInorderPostorder92 {
    private int postIndex;
    private HashMap<Integer, Integer> inorderIndexMap;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1; // Start from the last element of postorder
        inorderIndexMap = new HashMap<>();

        // Create a map to store indices of inorder elements for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return buildTreeHelper(inorder, postorder, 0, inorder.length - 1);
    }

    private TreeNode buildTreeHelper(int[] inorder, int[] postorder, int inStart, int inEnd) {
        // Base case: if there are no elements to construct
        if (inStart > inEnd) {
            return null;
        }

        // The last element in postorder is the root
        int rootVal = postorder[postIndex--];
        TreeNode root = new TreeNode(rootVal);

        // Find the index of this root value in inorder traversal
        int inIndex = inorderIndexMap.get(rootVal);

        // Recursively build right and left subtrees
        // Important: Build right subtree first because we are using postIndex which decreases
        root.right = buildTreeHelper(inorder, postorder, inIndex + 1, inEnd);
        root.left = buildTreeHelper(inorder, postorder, inStart, inIndex - 1);

        return root;
    }

    // Function to print preorder traversal for verification
    public void printPreOrder(TreeNode node) {
        if (node == null) return;
        System.out.print(node.val + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);
    }

    public static void main(String[] args) {
        BinaryTreeFromInorderPostorder92 builder = new BinaryTreeFromInorderPostorder92();
        
        int[] inorder = {4, 2, 5, 1, 6, 3, 7};
        int[] postorder = {4, 5, 2, 6, 7, 3, 1};

        TreeNode root = builder.buildTree(inorder, postorder);
        
        System.out.println("Preorder traversal of constructed tree:");
        builder.printPreOrder(root); // Should output: 1 2 4 5 3 6 7
    }
}
