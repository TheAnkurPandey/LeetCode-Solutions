class Solution:
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        # tc: O(n); sc: O(1)
        n = len(nums)
        
        if n == 1: return 0
        
        smallestOutOfOrder = float('inf')
        largestOutOfOrder = float('-inf')
        for i, x in enumerate(nums):
            # Edge case
            if i == 0: 
                if x > nums[i+1]:
                    smallestOutOfOrder = min(smallestOutOfOrder, x)
                    largestOutOfOrder = max(largestOutOfOrder, x)
                continue
            
            # Edge case
            if i == n-1: 
                if nums[i-1] > x:
                    smallestOutOfOrder = min(smallestOutOfOrder, x)
                    largestOutOfOrder = max(largestOutOfOrder, x)
                continue
                
            # Middle out of order
            if nums[i-1] <= x and x >= nums[i+1]:
                smallestOutOfOrder = min(smallestOutOfOrder, x)
                largestOutOfOrder = max(largestOutOfOrder, x)
            elif nums[i-1] >= x and x <= nums[i+1]:
                smallestOutOfOrder = min(smallestOutOfOrder, x)
                largestOutOfOrder = max(largestOutOfOrder, x)
                
        # Array is already sorted
        if smallestOutOfOrder == float('inf') and largestOutOfOrder == float('-inf'):
            return 0
        elif smallestOutOfOrder == largestOutOfOrder:
            return 0
                
        left = 0
        for i, x in enumerate(nums):
            if smallestOutOfOrder < x:
                left = i
                break
        
        right = n-1     
        for i, x in reversed(list(enumerate(nums))):
            if largestOutOfOrder > x:
                right = i
                break
                
        lenOfSubrray = right - left + 1
        return lenOfSubrray