class Solution {
    public int climbStairs(int n) {
        // return climbStairsTopDownClient(n);
        return climbStairsBottomUp(n);
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
    
    private int climbStairsBottomUp(int n) {
        // Bottom up / Tabulation
        // O(n) time & O(n) space
        
        int[] countDP = new int[n + 1];
        
        // Base case
        countDP[0] = 1;
        countDP[1] = 1;
        
        for (int i = 2; i < n+1; i++) {
            int stepX = countDP[i - 1];  // Go down by 1 step
            int stepY = countDP[i - 2];  // Go down by 2 steps 
            
            countDP[i] = stepX + stepY;
        }
        
        return countDP[n];
    }
}