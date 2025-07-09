import java.util.*;
class JobSequencingProblem {
    static class Job {
        int id, deadline, profit;
        Job(int id, int deadline, int profit) {
            this.id = id;
            this.deadline = deadline;
            this.profit = profit;
        }
    }

    public static int[] jobScheduling(int[] profit, int[] deadline) {
        int n = profit.length;
        Job[] jobs = new Job[n];

        for (int i = 0; i < n; i++) {
            jobs[i] = new Job(i + 1, deadline[i], profit[i]);
        }

        // Sort by descending profit
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (Job job : jobs)
            maxDeadline = Math.max(maxDeadline, job.deadline);

        boolean[] slots = new boolean[maxDeadline + 1]; 
        int jobCount = 0, totalProfit = 0;

        for (Job job : jobs) {
            for (int j = job.deadline; j > 0; j--) {
                if (!slots[j]) {
                    slots[j] = true;
                    jobCount++;
                    totalProfit += job.profit;
                    break;
                }
            }
        }

        return new int[]{jobCount, totalProfit};
    }

    public static void main(String[] args) {
        int[] profit = {40, 10, 40, 30};
        int[] deadline = {4, 1, 1, 1};

        int[] result = jobScheduling(profit, deadline);
        System.out.println("Jobs done: " + result[0]);
        System.out.println("Total Profit: " + result[1]);
    }
}
