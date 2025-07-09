import java.util.*;

public class MinNumberCoins {
        static List<Integer> minPartition(int N) {
            int[] coins = {1, 2, 5, 10, 20, 50, 100, 200, 500, 1000, 2000};
            List<Integer> ans = new ArrayList<>();

            for (int i = coins.length - 1; i >= 0; i--) {
                while (coins[i] <= N) {
                    ans.add(coins[i]);
                    N -= coins[i];
                }
            }

            return ans;
        }

    public static void main(String[] args) {
        int N = 2753; 
        List<Integer> result = minPartition(N);

        System.out.println("Minimum coins/notes used:");
        for (int coin : result) {
            System.out.print(coin + " ");
        }
        System.out.println(); // For newline
    }
}
