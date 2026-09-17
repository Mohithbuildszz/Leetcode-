class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals,(x,y)->x[0]-y[0]);
        ArrayList <int[]> result = new ArrayList<>();
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i=1;i<n;i++){
            int currstart = intervals[i][0];
            int currend = intervals[i][1];
            if(currstart <= end){
                end = Math.max(end, currend);
            } else {
                int[] arr = new int[]{start,end};
                result.add(arr);
                start = currstart;
                end = currend;
            }
        }

        int[] arr = new int[]{start, end};
        result.add(arr);

        int[][] ans = new int[result.size()][2];
        for (int i=0;i<result.size();i++){
        ans[i] =result.get(i);
        }
    return ans;
    }
}