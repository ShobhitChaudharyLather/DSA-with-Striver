class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[1] - b[1]); // sort acc end time
        int count = 0;
        int prevEnd = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int currStart = intervals[i][0];
            if(currStart < prevEnd){
                count++;
            }
            else{
                prevEnd = intervals[i][1];
            }
        }
        return count;
    }
}