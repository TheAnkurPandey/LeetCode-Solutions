class Solution:
    def rearrangeArray(self, nums: List[int]) -> List[int]:
        return self.rearrageArrayWithOrder(nums)
    
    def rearrageArrayWithNoOrder(self, nums: List[int]) -> List[int]:
        # O(n) time & O(1) space
        n = len(nums)
        
        pos = 0
        neg = 1
        
        i = 0
        while i < n:
            val = nums[i]
            
            is_odd = i & 1
            if not is_odd and val < 0:
                nums[neg], nums[i] = nums[i], nums[neg]
                neg += 2
            elif is_odd and val >= 0:
                nums[pos], nums[i] = nums[i], nums[pos]
                pos += 2
            else:
                i += 1
                
        return nums
    
    def rearrageArrayWithOrder(self, nums: List[int]) -> List[int]:
        # O(n) time & O(n) space
        n = len(nums)
        arr = [0] * n
        
        pos = 0
        neg = 1
        
        for i in range(n):
            if nums[i] < 0:
                arr[neg] = nums[i]
                neg += 2
            else:
                arr[pos] = nums[i]
                pos += 2
                
        return arr
        