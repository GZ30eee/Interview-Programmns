public class WashingMachine54 {
    public int findMinMoves(int[] machines) {
        int n = machines.length;
        int totalDresses = 0;
        for (int dress : machines) {
            totalDresses += dress;
        }
        if (totalDresses % n != 0) {
            return -1;
        }
        int averageDresses = totalDresses / n;
        int maxMoves = 0;
        int currentDresses = 0;
        for (int dress : machines) {
            currentDresses += dress - averageDresses;
            maxMoves = Math.max(maxMoves, Math.max(Math.abs(currentDresses), dress - averageDresses));
        }
        return maxMoves;
    }

    public static void main(String[] args) {
        SuperWashingMachines54 swm = new SuperWashingMachines54();
        int[] machines1 = {1, 0, 5};
        int[] machines2 = {0, 3, 0};
        System.out.println("Minimum number of moves for machines1: " + swm.findMinMoves(machines1)); // Output: 3
        System.out.println("Minimum number of moves for machines2: " + swm.findMinMoves(machines2)); // Output: 2
    }
}