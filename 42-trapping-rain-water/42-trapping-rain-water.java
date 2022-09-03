class Solution {
    public int trap(int[] height) {
        // Approach 1 - Array peprocssing (Prefix, suffix)
        return trappingRainWaterApproachA(height);
    }
    
    private int trappingRainWaterApproachA(int[] height) {
        // O(n) time & O(n) space
        
        int n = height.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        
        int leftMax = 0;
        for (int i = 0; i < n; i++) {
            if (height[i] > leftMax) leftMax = height[i];
            prefixMax[i] = leftMax;
        }
        
        int rightMax = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (height[i] > rightMax) rightMax = height[i];
            suffixMax[i] = rightMax;
        }
        
        int waterVolume = 0;
        for (int i = 0; i < n; i++) {
            waterVolume += Math.min(prefixMax[i], suffixMax[i]) - height[i];
        }
        
        return waterVolume;
    }
}