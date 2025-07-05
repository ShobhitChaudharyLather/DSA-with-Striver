import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

class AlienDictionary {
    public static ArrayList<Integer> topoSort(int K, ArrayList<ArrayList<Integer>> adj) {
        int[] indegree = new int[K];
        for (int i = 0; i < K; i++) {
            for (int it : adj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < K; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        ArrayList<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        return topo;
    }

    public static String findOrder(String[] words) {
        if (words == null || words.length == 0) {
            return "";
        }
        int K = 26;
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<>());
        }
        boolean[] present = new boolean[K];
        for (String word : words) {
            for (char c : word.toCharArray()) {
                present[c - 'a'] = true;
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String s1 = words[i];
            String s2 = words[i + 1];
            int len = Math.min(s1.length(), s2.length());
            boolean found = false;
            for (int ptr = 0; ptr < len; ptr++) {
                if (s1.charAt(ptr) != s2.charAt(ptr)) {
                    adj.get(s1.charAt(ptr) - 'a').add(s2.charAt(ptr) - 'a');
                    found = true;
                    break;
                }
            }
            if (!found && s1.length() > s2.length()) {
                return "";
            }
        }
        ArrayList<Integer> topo = topoSort(K, adj);
        int presentCount = 0;
        for (boolean p : present) {
            if (p) presentCount++;
        }
        // Check only present nodes were included in topological sort
        int topoPresentCount = 0;
        for (int node : topo) {
            if (present[node]) {
                topoPresentCount++;
            }
        }
        // If counts don't match, there's a cycle
        if (topoPresentCount != presentCount) {
            return "";
        }
        StringBuilder ans = new StringBuilder();
        for (int it : topo) {
            if (present[it]) {
                ans.append((char) (it + 'a'));
            }
        }
        return ans.toString();
    }
    public static void main(String[] args) {
        String[] words = {"baa", "abcd", "abca", "cab", "cad"};
        String order = findOrder(words);
        System.out.println("Alien dictionary order: " + order);
    }
}

