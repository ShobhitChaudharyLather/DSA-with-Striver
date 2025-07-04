import java.util.*;
class CourseSchedule1{
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prereq = pair[1];
            adj.get(prereq).add(course);
        }
        int[] indegree = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            for (int neighbor : adj.get(i)) {
                indegree[neighbor]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<>();
        while (!q.isEmpty()) {
            int node = q.poll();
            topo.add(node);

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }
        return topo.size() == numCourses;
    }
    public static void main(String[] args) {
        int numCourses1 = 4;
        int[][] prerequisites1 = {
            {1, 0},
            {2, 1},
            {3, 2}
        };
        System.out.println("Can finish all courses (Example 1): " + canFinish(numCourses1, prerequisites1)); // true
        int numCourses2 = 2;
        int[][] prerequisites2 = {
            {1, 0},
            {0, 1}
        };
        System.out.println("Can finish all courses (Example 2): " + canFinish(numCourses2, prerequisites2)); // false
    }
}