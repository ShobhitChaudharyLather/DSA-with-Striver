import java.util.*;

class NMeeting {
    
    static class Details {
        int start, end, pos;
        public Details(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        Details[] arr = new Details[N];
        for (int i = 0; i < N; i++) {
            arr[i] = new Details(S[i], F[i], i + 1);
        }

        // Sort by end time
        Arrays.sort(arr, (a, b) -> a.end - b.end);

        ArrayList<Integer> meetings = new ArrayList<>();
        meetings.add(arr[0].pos);
        int lastEndTime = arr[0].end;

        for (int i = 1; i < N; i++) {
            if (arr[i].start > lastEndTime) {
                meetings.add(arr[i].pos);
                lastEndTime = arr[i].end;
            }
        }
        Collections.sort(meetings);
        return meetings;
    }

    public static void main(String[] args) {
        int[] start = {1, 3, 0, 5, 8, 5};
        int[] end   = {2, 4, 6, 7, 9, 9};
        int N = start.length;

        ArrayList<Integer> result = maxMeetings(N, start, end);

        System.out.println("Meetings that can be attended (by index): " + result);
    }
}
