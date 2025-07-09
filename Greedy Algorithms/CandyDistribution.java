public class CandyDistribution {
        public static int candy(int[] ratings) {
            int sum = 1;
            int i = 1;
            int n = ratings.length;
            int peak = 0;
            int down = 0;

            while (i < n) {
                if (ratings[i] == ratings[i - 1]) {
                    sum += 1;
                    i++;
                    continue;
                }

                peak = 1; 
                while (i < n && ratings[i] > ratings[i - 1]) {
                    peak += 1;
                    sum += peak;
                    i++;
                }

                down = 1;
                while (i < n && ratings[i] < ratings[i - 1]) {
                    sum += down;
                    i++;
                    down++;
                }

                if (down > peak) {
                    sum += down - peak;
                }
            }

            return sum;
        }

    public static void main(String[] args) {
        int[] ratings = {1, 0, 2};  
        int result = candy(ratings);

        System.out.println("Minimum candies required: " + result);
    }
}
