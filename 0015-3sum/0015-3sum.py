class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        # tc: O(n^2 + nlogn); sc: O(1)
        res = []
        nums.sort()
        
        target = 0
        n = len(nums)
        
        for i, x in enumerate(nums):
            if (i > n - 3): break  # We can't form triplet
            
            # We will get duplicates if x is same as previous
            # Sorting brings all duplicates number together
            if (i > 0 and x == nums[i-1]): continue
            
            j = i + 1  # left pointer
            k = n - 1  # right pointer
            
            while (j < k):
                y, z = nums[j], nums[k]
                curr_sum = x
                curr_sum += y + z
                
                # We got the target sum!
                if (curr_sum == target):
                    res.append([x, y, z])
                    j += 1
                    k -= 1
                    
                    # Move the left & right pointer as we got duplicates
                    # Sorting brings all duplicates number together
                    while (j < n and nums[j] == nums[j-1]): j += 1
                        
                elif (curr_sum < target): j += 1  # Move left pointer
                else: k -= 1  # Move right pointer
                    
        return res
        
# Test cases
'''
[0,0,0,0]
[-1,0,0,1,1]
[-2,0,1,1,2]
[-4,-2,-2,-2,0,1,2,2,2,3,3,4,4,6,6]
[-1,0,1,2,-1,-4]
[0,1,1]
[0,0,0]
'''