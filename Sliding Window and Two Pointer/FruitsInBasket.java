import java.util.HashMap;
import java.util.Map;

public class FruitsInBasket {

    public static int totalFruit(int[] fruits) {
        Map<Integer, Integer> mp = new HashMap<>();
        int l = 0, r = 0, maxlen = 0;
        int n = fruits.length;

        while (r < n) {
            mp.put(fruits[r], mp.getOrDefault(fruits[r], 0) + 1);

            while (mp.size() > 2) {
                mp.put(fruits[l], mp.get(fruits[l]) - 1);
                if (mp.get(fruits[l]) == 0) {
                    mp.remove(fruits[l]);
                }
                l++;
            }

            maxlen = Math.max(maxlen, r - l + 1);
            r++;
        }

        return maxlen;
    }

    public static void main(String[] args) {
        int[] fruits = {1, 2, 1, 2, 3};
        int result = totalFruit(fruits);
        System.out.println("Maximum number of fruits collected: " + result);  // Expected output: 4
    }
}
