class Solution {
    public String longestCommonPrefix(String[] strs) {
        int n = strs.length;
        if (strs == null || strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
       Arrays.sort(strs);
       String first = strs[0];
       String last = strs[n-1];
       int miniValue = Math.min(first.length(),last.length());
       for(int i=0;i<miniValue;i++){
        if(first.charAt(i) != last.charAt(i)){
            return result.toString();
        } else {
            result.append(first.charAt(i));
        }
       }
       return result.toString();
    }
}