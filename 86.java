class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class 86 {
    private ListNode head;

    // Function to convert sorted linked list to BST
    public TreeNode sortedListToBST(ListNode head) {
        this.head = head;
        int size = getSize(head);
        return sortedListToBSTHelper(0, size - 1);
    }

    // Function to get the size of the linked list
    private int getSize(ListNode head) {
        int size = 0;
        while (head != null) {
            size++;
            head = head.next;
        }
        return size;
    }

    // Recursive function to build the BST
    private TreeNode sortedListToBSTHelper(int left, int right) {
        if (left > right) {
            return null;
        }

        // Recursively build the left subtree
        int mid = (left + right) / 2;

        // First step of the inorder traversal, process the left child
        TreeNode leftChild = sortedListToBSTHelper(left, mid - 1);

        // Now process the current node
        TreeNode root = new TreeNode(head.val);
        root.left = leftChild;

        // Move to the next list node
        head = head.next;

        // Now process the right child
        root.right = sortedListToBSTHelper(mid + 1, right);

        return root;
    }

    // Main method to test the conversion
    public static void main(String[] args) {
        // Create a sorted linked list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        SortedListToBST converter = new SortedListToBST();
        TreeNode bstRoot = converter.sortedListToBST(head);

        // You can add code here to print or verify the constructed BST
        System.out.println("BST constructed from sorted linked list.");
    }
}