class Solution {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] arr = s.toCharArray();
        String vowels = "aeiouAEIOU";
        while(l<r){
            if (vowels.indexOf(arr[l]) == -1) {
                l++;
                continue;
            }
            if (vowels.indexOf(arr[r]) == -1) {
                r--;
                continue;
            } else {
                char temp = arr[l];
                arr[l] = arr[r];
                arr[r] = temp;
                l++;
                r--;
            }
        }
        return new String(arr);
    }
}