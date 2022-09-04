class Solution {
    public int pivotIndex(int[] nums) {
        // O(n) time & O(1) space
        
        int n = nums.length;
        int totalSum = 0;
        for (int i = 0; i < n; i++) totalSum += nums[i];
        
        int prefixSum = 0;
        for (int pivotIndex = 0; pivotIndex < n; pivotIndex++) {
            
            int pivotValue = nums[pivotIndex];
            int suffixSum = totalSum - pivotValue - prefixSum;
            
            if (prefixSum == suffixSum) return pivotIndex;
            
            prefixSum += pivotValue;
        }
        
        return -1;
    }
}