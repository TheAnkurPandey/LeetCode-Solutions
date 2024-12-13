class Solution:
    def __outOfOrder(self, nums: List[int], i: int) -> bool:
        n = len(nums)
        
        # Edge cases
        if i == 0:
            return nums[i] > nums[i+1]
        elif i == n - 1:
            return nums[i-1] > nums[i]
        
        # True if it is out of order in the middle
        return nums[i-1] > nums[i] or nums[i] > nums[i+1]
    
    
    def findUnsortedSubarray(self, nums: List[int]) -> int:
        # tc: O(n); sc: O(1)
        n = len(nums)
        
        # Single array element are always sorted
        if n == 1: return 0
        
        smallestOutOfOrder = float('inf')
        largestOutOfOrder = float('-inf')
        for i, x in enumerate(nums):
            if self.__outOfOrder(nums, i):
                smallestOutOfOrder = min(smallestOutOfOrder, x)
                largestOutOfOrder = max(largestOutOfOrder, x)
                
        # Array is already sorted
        if smallestOutOfOrder == float('inf'):
            # It means both smallestOutOfOrder & largestOutOfOrder unchanged
            return 0
        elif smallestOutOfOrder == largestOutOfOrder:
            return 0
                
        # First index from left which is unsorted
        # equlity conditions helps to identify smallest subarray
        left = 0
        while nums[left] <= smallestOutOfOrder: left += 1
        
        # First index from right which is unsorted
        # equlity conditions helps to identify smallest subarray
        right = n-1     
        while largestOutOfOrder <= nums[right]: right -= 1
                
        lenOfSubrray = right - left + 1
        return lenOfSubrray
    
# Test cases
'''
[1,2,3,3,3]
[1,3,2,2,2]
[2,6,4,8,10,9,15]
[1,2,3,4]
[1]
'''