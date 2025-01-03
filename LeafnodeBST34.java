class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    
    TreeNode(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

public class LeafnodeBST34 {
    public static void printLeafNodes(TreeNode root) {
        if (root == null) {
            return;
        }
        
        if (root.left == null && root.right == null) {
            System.out.print(root.val + " ");
            return;
        }
        
        printLeafNodes(root.left);
        printLeafNodes(root.right);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(25);
        root.left = new TreeNode(20);
        root.right = new TreeNode(36);
        root.left.left = new TreeNode(10);
        root.left.right = new TreeNode(22);
        root.left.left.left = new TreeNode(5);
        root.left.left.right = new TreeNode(12);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);
        root.right.left.left = new TreeNode(28);
        root.right.right.left = new TreeNode(38);
        root.right.right.right = new TreeNode(48);
        
        System.out.println("Leaf nodes of the BST are: ");
        printLeafNodes(root);
    }
}