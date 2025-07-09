import java.util.*;

public class NonOverlappingIntervals {
        public static int eraseOverlapIntervals(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[1] - b[1]);
            int n = intervals.length;
            int cnt = 1;
            int lastEnd = intervals[0][1];

            for (int i = 1; i < n; i++) {
                if (intervals[i][0] >= lastEnd) {
                    cnt++;
                    lastEnd = intervals[i][1];
                }
            }

            return n - cnt;
        }
        public static void main(String[] args) {
            int[][] intervals = {
                {1, 2},
                {2, 3},
                {3, 4},
                {1, 3}
            };
            
            int result = eraseOverlapIntervals(intervals);
            System.out.println("Minimum number of intervals to remove: " + result);
        }
}    

