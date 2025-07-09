import java.util.*;

public class InsertInterval {
        public static int[][] insert(int[][] intervals, int[] newInterval) {
            List<int[]> res = new ArrayList<>();
            int i = 0;
            int n = intervals.length;

            // Add all intervals that end before newInterval starts
            while (i < n && intervals[i][1] < newInterval[0]) {
                res.add(intervals[i]);
                i++;
            }

            // Merge overlapping intervals with newInterval
            while (i < n && intervals[i][0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
                newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
                i++;
            }
            res.add(newInterval); 

            // Add remaining intervals
            while (i < n) {
                res.add(intervals[i]);
                i++;
            }
            return res.toArray(new int[res.size()][]);
        }
        public static void main(String[] args) {
        int[][] intervals = {
            {1, 2},
            {3, 5},
            {6, 7},
            {8, 10},
            {12, 16}
        };
        int[] newInterval = {4, 8};

        int[][] result = insert(intervals, newInterval);

        System.out.println("Merged intervals:");
        for (int[] interval : result) {
            System.out.print(Arrays.toString(interval)+" ");
        }
    }
}

