import java.util.*;

public class MinimumPlatforms {
        public static int findPlatform(int arr[], int dep[]) {
            Arrays.sort(arr);
            Arrays.sort(dep);
            int i = 0, j = 0;
            int maxCnt = 0, cnt = 0;

            while (i < arr.length && j < dep.length) {
                if (arr[i] <= dep[j]) {
                    cnt++;
                    i++;
                } else {
                    cnt--;
                    j++;
                }
                maxCnt = Math.max(maxCnt, cnt);
            }

            return maxCnt;
        }
        public static void main(String[] args) {
        int[] arrival = {900, 940, 950, 1100, 1500, 1800};
        int[] departure = {910, 1200, 1120, 1130, 1900, 2000};

        int result = findPlatform(arrival, departure);
        System.out.println("Minimum number of platforms required: " + result);
    }
}