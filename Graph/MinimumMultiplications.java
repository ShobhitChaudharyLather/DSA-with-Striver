import java.util.*;

public class MinimumMultiplications {
    public static int minimumMultiplications(int[] arr, int start, int end) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});

        int[] dist = new int[100000];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;

        int mod = 100000;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int node = curr[0];
            int steps = curr[1];

            for (int it : arr) {
                int num = (it * node) % mod;
                if (steps + 1 < dist[num]) {
                    dist[num] = steps + 1;
                    if (num == end) return steps + 1;
                    q.offer(new int[]{num, steps + 1});
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 7};
        int start = 3;
        int end = 30;

        int result = minimumMultiplications(arr, start, end);
        System.out.println("Minimum Multiplications: " + result);
    }
}
