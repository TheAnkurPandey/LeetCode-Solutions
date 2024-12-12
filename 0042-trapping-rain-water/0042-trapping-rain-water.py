class Solution:
    def trap(self, height: List[int]) -> int:
        # tc: O(n); sc: O(n)
        n = len(height)
        leftMax = [0] * n
        rightMax = [0] * n
        
        leftMaxSoFar = 0
        for i, h in enumerate(height):
            leftMaxSoFar = max(leftMaxSoFar, h)
            leftMax[i] = leftMaxSoFar
            
        rightMaxSoFar = 0
        for i, h in reversed(list(enumerate(height))):
            rightMaxSoFar = max(rightMaxSoFar, h)
            rightMax[i] = rightMaxSoFar
            
        res = 0
        for i, h in enumerate(height):
            res += min(leftMax[i], rightMax[i]) - h
            
        return res
            
        