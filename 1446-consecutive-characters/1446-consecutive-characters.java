class Solution {
    public int maxPower(String s) {
        int n = s.length();
        int count = 1;
        int max = 1;
        for(int i=0;i<n-1;i++){
            if (s.charAt(i) == s.charAt(i+1)){
                count++;
            }
            else {
                count = 1;
            }
            max = Math.max(count,max);
        }
        return max;
    }
}