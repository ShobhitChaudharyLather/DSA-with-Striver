import java.util.Arrays;

public class FractionalKnapsack {

    static class Item {
        int value, weight;
        double ratio;

        Item(int value, int weight) {
            this.value = value;
            this.weight = weight;
            this.ratio = value * 1.0 / weight;
        }
    }
        public static double fractionalKnapsack(int[] values, int[] weights, int W) {
            int n = values.length;
            Item[] items = new Item[n];

            for (int i = 0; i < n; i++) {
                items[i] = new Item(values[i], weights[i]);
            }

            Arrays.sort(items, (a, b) -> Double.compare(b.ratio, a.ratio));

            double finalValue = 0;
            int capacity = W;

            for (Item item : items) {
                if (capacity >= item.weight) {
                    finalValue += item.value;
                    capacity -= item.weight;
                } else {
                    finalValue += item.ratio * capacity;
                    break;
                }
            }

            return finalValue;
        }
        public static void main(String[] args) {
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int W = 50;

        double maxValue = fractionalKnapsack(values, weights, W);
        System.out.printf("Maximum value in knapsack = %.2f\n", maxValue);
    }
}
