import java.util.HashMap;

class SubarrayWithKDistinct {
    // subarrays with at most k distinct elements
    public static int lessOrEqualDistinct(int[] nums, int k) {
        int l = 0, r = 0, cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        while (r < nums.length) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            
            while (map.size() > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                if (map.get(nums[l]) == 0) {
                    map.remove(nums[l]);
                }
                l++;
            }
            
            cnt += (r - l + 1);
            r++;
        }
        
        return cnt;
    }

    // Exactly k distinct integers
    public static int subarraysWithKDistinct(int[] nums, int k) {
        return lessOrEqualDistinct(nums, k) - lessOrEqualDistinct(nums, k - 1);
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 1, 2, 3};
        int k = 2;
        System.out.println("Subarrays with exactly " + k + " distinct integers: " + subarraysWithKDistinct(nums, k));
    }
}
