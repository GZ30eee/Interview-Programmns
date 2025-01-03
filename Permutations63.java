import java.util.ArrayList;
import java.util.List;

public class Permutations63 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayList<>(), nums);
        return result;
    }

    private void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] nums) {
        // Base case: if the current permutation is of the same length as nums
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList)); // Add a copy of tempList to results
        } else {
            for (int i = 0; i < nums.length; i++) {
                if (tempList.contains(nums[i])) continue; // Skip if already in tempList
                tempList.add(nums[i]); // Choose
                backtrack(result, tempList, nums); // Explore
                tempList.remove(tempList.size() - 1); // Un-choose (backtrack)
            }
        }
    }

    public static void main(String[] args) {
        Permutations63 solution = new Permutations63();
        
        int[] nums = {1, 2, 3};
        List<List<Integer>> result = solution.permute(nums);
        
        System.out.println("All permutations:");
        for (List<Integer> perm : result) {
            System.out.println(perm);
        }
    }
}
