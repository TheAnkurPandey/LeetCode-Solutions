class Solution {
    public int maxProfit(int[] prices) {
        // O(n) time & O(1) space
        
        int n = prices.length;
        int minSoFar = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        
        for(int i = 0; i < n; i++) {
            if(prices[i] < minSoFar) minSoFar = prices[i];
            
            int currentProfit = prices[i] - minSoFar;
            if(currentProfit > maxProfit) maxProfit = currentProfit;
        }
        
        return maxProfit;
    }
}