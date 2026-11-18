 class Solution {
    public String triangleType(int[] nums) {
        int a=nums[0];
        int b=nums[1];
        int c=nums[2];
        //checking for a valid traingle
        if(a+b<=c || b+c<=a || a+c<=b)
        {
            return "none";
        }
        //checking for equilateral
        if(a==b && b==c)
        {
            return "equilateral";
        }
        //check for isosceles
        if( a==b || b==c || c==a)
        {
            return "isosceles";
        }
        return "scalene";
    }
}