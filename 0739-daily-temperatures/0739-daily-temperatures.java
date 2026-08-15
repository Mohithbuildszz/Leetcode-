class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
       int n =  temperatures.length;
       int[] arr = new int[n];
       Stack<Integer> result = new Stack<>();
       for( int i=0;i<n;i++){
            while(!result.isEmpty() && temperatures[i] > temperatures[result.peek()]){
                int previous = result.pop();
                arr[previous] = i - previous;
            }
            result.push(i);
       }
       return arr;
    }
}