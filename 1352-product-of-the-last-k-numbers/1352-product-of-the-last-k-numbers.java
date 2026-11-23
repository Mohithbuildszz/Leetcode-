class ProductOfNumbers {
    List<Integer> prefix;
    public ProductOfNumbers() {
        prefix = new ArrayList<>();
        prefix.add(1);
    }
    
    public void add(int num) {
        
        if(num == 0){
          prefix = new ArrayList<>();
          prefix.add(1) ;
        } else {
            prefix.add(prefix.get(prefix.size()-1)*num);
        }
    }
    
    public int getProduct(int k) {
        int n = prefix.size();
        if(k>=prefix.size()) return 0;
        int ans = prefix.get(prefix.size()-1) / prefix.get(n-1-k);
        return ans;
    }
}

/**
 * Your ProductOfNumbers object will be instantiated and called as such:
 * ProductOfNumbers obj = new ProductOfNumbers();
 * obj.add(num);
 * int param_2 = obj.getProduct(k);
 */