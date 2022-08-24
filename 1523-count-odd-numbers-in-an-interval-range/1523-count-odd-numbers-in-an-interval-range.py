class Solution:
    def countOdds(self, low: int, high: int) -> int:
        # O(1) time & O(1) space
        upto_high = (high + 1) // 2
        upto_low = low // 2
        return upto_high - upto_low