class Solution {
    public int lengthOfLIS(int[] nums) {
        // return lengthOfLISTopDownClient(nums);
        return lengthOfLISBottomUp(nums);
    }
    
    private int lengthOfLISTopDownClient(int[] nums) {
        int n = nums.length;  // Size of array
        int[] lisDP = new int[n];  // lisDP[i] = length of longest LIS ending at I 
        Arrays.fill(lisDP, 0);
        
        // Compute LIS ending at each index
        // Because LIS may end at any index
        for (int i = 0; i < n; i++) lengthOfLISTopDown(i, nums, lisDP);
        
        // Processing DP table
        int lenOfLIS = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (lisDP[i] > lenOfLIS) lenOfLIS = lisDP[i];
        }
        
        return lenOfLIS;
    }
    
    private int lengthOfLISTopDown(int end, int[] nums, int[] lisDP) {
        // Memoization / Top Down DP
        // O(n^2) time & O(n) space
        
        // Base case
        if (end == 0) {
            lisDP[end] = 1;
            return lisDP[end];
        }
        
        // Already computed
        if (lisDP[end] != 0) return lisDP[end];
        
        
        // Recrusive case
        // Not computed yet
        int lengthOfLISTillEnd = 1;  // Every element forms LIS of length atleast 1 
        
        for (int i = end - 1; i >= 0; i--) {
            if (nums[i] < nums[end]) {  // Can end form LIS with ith item
                
                // length of LIS by using LIS ending at i
                int lengthOfLISTillI = lengthOfLISTopDown(i, nums, lisDP);
                int lengthOfLISUsingI = lengthOfLISTillI + 1;
                
                // Update the length of longest LIS found ending at end
                lengthOfLISTillEnd = Math.max(
                    lengthOfLISTillEnd, lengthOfLISUsingI);
            }
        }
        
        // Update table
        lisDP[end] = lengthOfLISTillEnd;
        
        return lisDP[end];
    }
    
    private int lengthOfLISBottomUp(int nums[]){
        // Tabulation / Bottom up
        // O(n^2) time & O(n) space
        
        int n = nums.length;
        int[] lisDP = new int[n];
        
        // Compute LIS ending at each index
        // Because LIS may end at any index
        for (int end = 0; end < n; end++) {
            int lengthOfLISTillEnd = 1;  // Every element forms LIS of length atleast 1
            
            for (int i = end - 1; i > -1; i--) {
                if (nums[i] < nums[end]) {  // Can end form LIS with ith item
                    
                    // length of LIS by using LIS ending at i
                    int lengthOfLISTillI = lisDP[i];
                    int lengthOfLISUsingI = lengthOfLISTillI + 1;
                                        
                    // Update the length of longest LIS found ending at end
                    lengthOfLISTillEnd = Math.max(
                        lengthOfLISTillEnd, lengthOfLISUsingI);
                }
            }
            
            // Update table
            lisDP[end] = lengthOfLISTillEnd;
        }
        
        // Processing DP table
        int lenOfLIS = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (lisDP[i] > lenOfLIS) lenOfLIS = lisDP[i];
        }
        
        return lenOfLIS;
    }
}