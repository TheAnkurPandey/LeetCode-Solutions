public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        // O(logn) time & O(1) space        
        
        int ans = 0;
        while(n != 0) {
            ans += n & 1;
            n >>>= 1;
        }
        
        return ans;
    }
}