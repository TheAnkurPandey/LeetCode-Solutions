class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        # tc: O(n); sc: O(n)
        scanned = dict()
        for i, n in enumerate(nums):
            second = n
            first = target - second
            # pair exist
            if first in scanned:
                j = scanned[first]
                return [j, i]
            else:
                scanned[n] = i
                
        return []