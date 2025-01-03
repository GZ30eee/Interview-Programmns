import java.util.HashMap;

public class PairSum43 {

    public static int countPairsWithSum(int[] arr, int target) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        int count = 0;

        for (int num : arr) {
            // Calculate complement
            int complement = target - num;

            // If complement exists in map, add its frequency to count
            if (frequencyMap.containsKey(complement)) {
                count += frequencyMap.get(complement);
            }

            // Update frequency map with current number
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1, 5, 7, -1, 5}; // Example input
        int target = 6;
        
        int result = countPairsWithSum(arr, target);
        
        System.out.println("Number of pairs with sum " + target + ": " + result); // Output: 3
    }
}
