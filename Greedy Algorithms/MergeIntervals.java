import java.util.*;

public class MergeIntervals {
        public static int[][] merge(int[][] intervals) {
            Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

            List<int[]> merged = new ArrayList<>();
            int[] curr = intervals[0];
            merged.add(curr);

            for (int[] interval : intervals) {
                int currEnd = curr[1];
                int nextStart = interval[0];
                int nextEnd = interval[1];

                if (nextStart <= currEnd) {
                    curr[1] = Math.max(currEnd, nextEnd);
                } else {
                    curr = interval;
                    merged.add(curr);
                }
            }

            return merged.toArray(new int[merged.size()][]);
        }

    public static void main(String[] args) {
        int[][] intervals = {
            {1, 3},
            {2, 6},
            {8, 10},
            {15, 18}
        };

        int[][] merged = merge(intervals);

        System.out.println("Merged Intervals:");
        for (int[] interval : merged) {
            System.out.print(Arrays.toString(interval)+" ");
        }
    }
}
