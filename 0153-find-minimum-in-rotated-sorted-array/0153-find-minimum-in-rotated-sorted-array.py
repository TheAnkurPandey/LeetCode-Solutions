class Solution:
    def findMin(self, nums: List[int]) -> int:
        # O(logn) time & O(1) space
        
        left = 0
        right = len(nums) - 1        
        
        while left < right:
            mid = left + (right - left) // 2  # Prevented arithmetic overflow
            
            if nums[mid] < nums[right]: right = mid
            else: left = mid + 1  # mid can't be an answer, bec nums[right] < nums[mid]
            
        return nums[left]
        