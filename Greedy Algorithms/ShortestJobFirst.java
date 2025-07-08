import java.util.*;

class ShortestJobFirst{
    static int avgWaitingTime(int bt[]) {
        Arrays.sort(bt); // Sort for SJF

        int n = bt.length;
        int wt = 0;    
        int currT = 0;    

        for (int i = 0; i < n; i++) {
            wt += currT;
            currT += bt[i];
        }

        return wt / n; 
    }

    public static void main(String[] args) {
        int[] bt = {6, 8, 7, 3};
        int avgWT= avgWaitingTime(bt);
        System.out.println("Average Waiting Time: " + avgWT);
    }
}
