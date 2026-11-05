class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n = arr1.length;
        int m = arr2.length;
        int count = 0;
        for(int i=0;i<n;i++){
            boolean found = false;
            for(int j=0;j<m;j++){
                if(Math.abs((long) arr1[i]-arr2[j]) <= d){
                    found = true;
                    break;
                }
            }
            if(found == false) {
                count++;
            }
        }
        return count;
    }
}