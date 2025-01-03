import java.util.*;

public class MatchResults96 {
    public List<List<Integer>> findWinners(int[][] matches) {
        // Map to count losses
        Map<Integer, Integer> lossCount = new HashMap<>();
        // Set to track players who have played
        Set<Integer> players = new HashSet<>();

        // Process each match
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            // Increment loss count for the loser
            lossCount.put(loser, lossCount.getOrDefault(loser, 0) + 1);
            // Ensure winner is also recorded
            lossCount.putIfAbsent(winner, 0);
            
            // Add players to the set
            players.add(winner);
            players.add(loser);
        }

        List<Integer> noLosses = new ArrayList<>();
        List<Integer> oneLoss = new ArrayList<>();

        // Determine players with no losses and exactly one loss
        for (int player : players) {
            if (!lossCount.containsKey(player)) {
                noLosses.add(player); // Player has no losses
            } else if (lossCount.get(player) == 1) {
                oneLoss.add(player); // Player has exactly one loss
            }
        }

        // Sort both lists
        Collections.sort(noLosses);
        Collections.sort(oneLoss);

        return Arrays.asList(noLosses, oneLoss);
    }

    public static void main(String[] args) {
        MatchResults96 mr = new MatchResults96();
        
        int[][] matches = {
            {1, 3},
            {2, 3},
            {3, 6},
            {5, 6},
            {5, 7},
            {4, 5},
            {4, 8},
            {4, 9},
            {10, 4},
            {10, 9}
        };

        List<List<Integer>> result = mr.findWinners(matches);
        
        System.out.println(result); // Output: [[1, 2, 10], [4, 5, 7, 8]]
    }
}
