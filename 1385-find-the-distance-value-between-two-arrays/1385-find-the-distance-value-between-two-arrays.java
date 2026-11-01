class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int i = arr1.length;
        int j = arr2.length;
        int count = 0;
        for(int n=0;n<i;n++){
            boolean found = false;
            for(int m=0;m<j;m++){
                if(Math.abs((long)arr1[n] - arr2[m]) <= d){
                   found = true;
                   break;
                    }
                } 
                if(found == false){
                    count++;
                }
            }
        return count;
        }
    }