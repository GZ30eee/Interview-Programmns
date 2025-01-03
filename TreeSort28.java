class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        left = right = null;
    }
}

public class TreeSort28 {
    private TreeNode root;

    // Function to insert a new value into the BST
    public void insert(int value) {
        root = insertRec(root, value);
    }

    // Recursive function to insert a new value into the BST
    private TreeNode insertRec(TreeNode root, int value) {
        if (root == null) {
            root = new TreeNode(value);
            return root;
        }

        if (value < root.value) {
            root.left = insertRec(root.left, value);
        } else if (value > root.value) {
            root.right = insertRec(root.right, value);
        }

        return root;
    }

    // Function to perform in-order traversal of the BST
    public void inOrderTraversal(TreeNode root, int[] sortedArray, int[] index) {
        if (root != null) {
            inOrderTraversal(root.left, sortedArray, index);
            sortedArray[index[0]] = root.value;
            index[0]++;
            inOrderTraversal(root.right, sortedArray, index);
        }
    }

    // Function to sort the array using Tree Sort
    public int[] treeSort(int[] arr) {
        // Insert elements into the BST
        for (int value : arr) {
            insert(value);
        }

        // Create an array to hold the sorted elements
        int[] sortedArray = new int[arr.length];
        int[] index = {0}; // Using an array to hold index as a reference

        // Perform in-order traversal to get sorted elements
        inOrderTraversal(root, sortedArray, index);
        return sortedArray;
    }

    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};

        TreeSort28 treeSort = new TreeSort28();
        int[] sortedArray = treeSort.treeSort(arr);

        System.out.println("Sorted array:");
        for (int value : sortedArray) {
            System.out.print(value + " ");
        }
    }
}