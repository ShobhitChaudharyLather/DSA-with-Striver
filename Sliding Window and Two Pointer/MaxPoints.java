public class MaxPoints {
    public static int maxScore(int[] cardPoints, int k) {
        int lSum = 0, rSum = 0, maxSum = 0, right = cardPoints.length - 1;
        for (int i = 0; i < k; i++) {
            lSum += cardPoints[i];
        }

        maxSum = lSum;

        for (int i = k - 1; i >= 0; i--) {
            lSum -= cardPoints[i];
            rSum += cardPoints[right];
            right--;
            maxSum = Math.max(maxSum, lSum + rSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] cardPoints = {1, 2, 3, 4, 5, 6, 1};
        int k = 3;

        int result = maxScore(cardPoints, k);
        System.out.println("Maximum score: " + result);  // Output should be 12
    }
}
