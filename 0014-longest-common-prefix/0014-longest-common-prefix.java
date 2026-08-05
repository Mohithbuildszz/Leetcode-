class Solution {
    public String longestCommonPrefix(String[] strs) {
        String abc ="";
        Arrays.sort(strs);
        String first=strs[0];
        String last=strs[strs.length-1];
        for(int i=0;i<first.length();i++){
            if(first.charAt(i)==last.charAt(i)){
                abc = abc + first.charAt(i);
            } else {
                break;
            }
        }
            return abc;
        }
    }