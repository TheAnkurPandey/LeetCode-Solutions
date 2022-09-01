class Solution {
    public int subtractProductAndSum(int n) {
        // O(logn) time & O(1) space
        
        long productOfDigits = 1;
        long sumOfDigits = 0;
        
        while (n > 0) {
            int digit = n % 10;
            
            productOfDigits *= digit;
            sumOfDigits += digit;
            
            n /= 10;
        }
        
        int diff = (int) (productOfDigits - sumOfDigits);
        return diff;
    }
}