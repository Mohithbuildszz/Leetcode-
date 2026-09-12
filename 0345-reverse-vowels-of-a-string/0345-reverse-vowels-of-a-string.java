class Solution {
    public String reverseVowels(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] arr = s.toCharArray();
        while(l<r){
            if(Character.toLowerCase(arr[l]) != 'a' && Character.toLowerCase(arr[l]) != 'e' && Character.toLowerCase(arr[l]) != 'i' && Character.toLowerCase(arr[l]) != 'o' && Character.toLowerCase(arr[l]) != 'u'){
                l++;
                continue;
            } else if(Character.toLowerCase(arr[r]) != 'a' && Character.toLowerCase(arr[r]) != 'e' && Character.toLowerCase(arr[r]) != 'i' && Character.toLowerCase(arr[r]) != 'o' && Character.toLowerCase(arr[r]) != 'u'){
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