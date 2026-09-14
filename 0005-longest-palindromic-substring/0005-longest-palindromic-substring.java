class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int start = 0;
        int max = 1;
        for(int i=0;i<n;i++){
            int left = i;int right = i;
            while(left >= 0 && right<n && s.charAt(left) == s.charAt(right)){
                int length = right-left+1;
                if(length>max){
                    max = length;
                    start = left;
                }
                left--;
                right++;
            }   
            left = i;
            right = i+1;
            while(left>=0 && right<n && s.charAt(left) == s.charAt(right)){
                int length=right-left+1;
                if(length>max){
                    max = length;
                    start = left;
                }
                left--;
                right++;
            }
       }
       return s.substring(start, start+max);
    }
}