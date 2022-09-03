class Solution {
    public int climbStairs(int n) {
        return climbStairsTopDownClient(n);
    }
    
    private int climbStairsTopDownClient(int n) {
        int[] countDP = new int[n + 1];
        return climbStairsTopDown(n, countDP);
    }
    
    private int climbStairsTopDown(int n, int[] countDP) {
        // Top down / Memoization
        // O(n) time & O(n) space
        
        // Base case
        if (n < 0) return 0;
        if (n == 0) return 1;
        
        // Already computed
        if (countDP[n] != 0) return countDP[n];
        
        // Recursive case
        int stepX = climbStairsTopDown(n - 1, countDP);  // Go down by 1 step
        int stepY = climbStairsTopDown(n - 2, countDP);  // Go down by 2 steps
        
        countDP[n] = stepX + stepY;
        
        return countDP[n];
    }
}