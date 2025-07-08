import java.util.Arrays;
class AssignCookies{
    public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g); 
        Arrays.sort(s); 
        int i = 0, j = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                i++; 
            }
            j++; 
        }

        return i; //total children satisfied
    }
    public static void main(String[] args) {
        int[] g = {1, 5, 3, 3, 4}; // greed factor of children
        int[] s = {4, 2, 1, 2, 1, 3};    // size of cookies

        int result = findContentChildren(g, s);
        System.out.println("Number of content(satisfied) children: " + result);
    }
}