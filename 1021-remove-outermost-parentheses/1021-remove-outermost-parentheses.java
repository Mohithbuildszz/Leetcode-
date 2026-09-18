class Solution {
    public String removeOuterParentheses(String s) {
        StringBuilder result = new StringBuilder();
        int count = 0;
        int n=s.length();
        for(int i=0;i<n;i++){
            if(s.charAt(i)== '('){
                if(count > 0){
                    result.append(s.charAt(i));
                }
                    count++;
                }else{
                        count--;
                    if(count > 0){
                        result.append(s.charAt(i));
                    }
                }
            }
return result.toString();
    }
}