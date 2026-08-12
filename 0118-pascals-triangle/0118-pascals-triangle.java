class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> row  = new ArrayList<>();
         for(int i=0;i<numRows;i++){
            ArrayList<Integer> num = new ArrayList<>();
                for(int j=0;j<=i;j++){
                    if(j==0 || j==i){
                        num.add(1);
                    } else {
                         int value = row.get(i-1).get(j-1) + row.get(i-1).get(j);
                         num.add(value);
                    }
                }
                row.add(num);
         }
         return row;
    }
}