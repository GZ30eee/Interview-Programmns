import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

public class MostFrequentElements61 {
    private Map<Integer, Integer> frequencyMap = new HashMap<>();
    private int maxFrequency = 0;

    // Function to perform inorder traversal and count frequencies
    private void inorderTraversal(TreeNode node) {
        if (node == null) return;

        inorderTraversal(node.left);

        // Count the frequency of the current node's value
        frequencyMap.put(node.val, frequencyMap.getOrDefault(node.val, 0) + 1);
        maxFrequency = Math.max(maxFrequency, frequencyMap.get(node.val));

        inorderTraversal(node.right);
    }

    // Function to find the most frequently occurred elements
    public int[] findMode(TreeNode root) {
        inorderTraversal(root);

        // Collect all values that have the maximum frequency
        List<Integer> modes = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : frequencyMap.entrySet()) {
            if (entry.getValue() == maxFrequency) {
                modes.add(entry.getKey());
            }
        }

        // Convert the list to an array
        return modes.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        // Constructing the BST with duplicates
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(3);
        root.right.right.right = new TreeNode(3);
        root.right.right.right.right = new TreeNode(3);

        MostFrequentElements61 mfe = new MostFrequentElements61();
        int[] modes = mfe.findMode(root);

        System.out.print("Most frequently occurred elements: ");
        for (int mode : modes) {
            System.out.print(mode + " ");
        }
    }
}