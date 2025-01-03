import java.util.*;

public class GroupAnagrams93 {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Create a map to hold the grouped anagrams
        Map<String, List<String>> anagramGroups = new HashMap<>();

        // Iterate through each string in the input array
        for (String s : strs) {
            // Sort the characters of the string to form a key
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            String sortedString = new String(charArray);

            // Add the original string to the corresponding list in the map
            anagramGroups.putIfAbsent(sortedString, new ArrayList<>());
            anagramGroups.get(sortedString).add(s);
        }

        // Return the values of the map as a list of lists
        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        GroupAnagrams93 solution = new GroupAnagrams93();
        
        // Test case
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(strs);
        
        // Print the result
        System.out.println(result);
    }
}
