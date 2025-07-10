import java.util.Arrays;

public class NumberOfSubstrings {
    public static int numberOfSubstrings(String s) {
        int len = 0;
        int r = 0;
        int[] lastSeen = new int[3];
        Arrays.fill(lastSeen, -1);

        for (r = 0; r < s.length(); r++) {
            lastSeen[s.charAt(r) - 'a'] = r;

            if (lastSeen[0] != -1 && lastSeen[1] != -1 && lastSeen[2] != -1) {
                // The earliest position among a, b, and c — determines how many substrings end at r
                len += 1 + Math.min(lastSeen[0], Math.min(lastSeen[1], lastSeen[2]));
            }
        }

        return len;
    }

    public static void main(String[] args) {
        String s = "abcabc";
        int result = numberOfSubstrings(s);
        System.out.println("Number of substrings containing all three characters: " + result);
        // Output: 10
    }
}
