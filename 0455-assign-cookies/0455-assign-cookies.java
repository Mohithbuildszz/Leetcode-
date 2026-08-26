class Solution {
    public int findContentChildren(int[] g, int[] s) {
    int n=g.length;
        int m=s.length;
        int left = 0;
        int right=0;
        Arrays.sort(g);
        Arrays.sort(s);
        while(left<n && right<m){
            if(s[right] >= g[left]){
                left++;
            }
            right++;
        }
        return left;
    }
}