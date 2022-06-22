class Solution {
    public int reverse(int x) {
        // O(d) time & O(1) space
        
        int result = 0;
        while(x != 0) {
            int digit = x%10;
            
            if(result > Integer.MAX_VALUE /10) return 0;
            if(result < Integer.MIN_VALUE/10) return 0;
            
            result = result*10 + digit;
            
            x /= 10;
        }
        
        return result;
    }
}