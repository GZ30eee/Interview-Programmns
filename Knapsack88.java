import java.util.*;

class Item {
    int value;
    int weight;
    double ratio;

    Item(int value, int weight) {
        this.value = value;
        this.weight = weight;
        this.ratio = (double)value / weight;
    }
}

public class Knapsack88 {
    public static void main(String[] args) {
        int[] values = {10, 5, 15, 7, 6, 18, 3};
        int[] weights = {2, 3, 5, 7, 1, 4, 1};
        int capacity = 15;

        List<Item> itemsList = new ArrayList<>();
        for (int i =0; i < values.length; i++) {
            itemsList.add(new Item(values[i], weights[i]));
        }

        // Sort items by value-to-weight ratio in descending order
        itemsList.sort((a,b) -> Double.compare(b.ratio,a.ratio));

        int totalValue =0;
        int totalWeight =0;

        System.out.println("Selected Items:");
        for(Item item : itemsList) {
            if(totalWeight + item.weight <= capacity) {
                totalWeight += item.weight;
                totalValue += item.value;
                System.out.printf("Value=%d Weight=%d Ratio=%.2f\n", item.value,item.weight,item.ratio);
            }
        }

        System.out.println("Total Weight: " + totalWeight);
        System.out.println("Total Value: " + totalValue);
    }
}
