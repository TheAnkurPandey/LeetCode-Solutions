class Solution:
    def climbStairs(self, n: int) -> int:
        # O(n) time & O(n) space
        
        num_steps = [0] * (n + 1)  # Number of steps to reach i
        
        num_steps[0] = 1
        num_steps[1] = 1
        
        for i in range(2, n + 1):
            num_steps[i] = num_steps[i - 1] + num_steps[i - 2]
            
        return num_steps[n]