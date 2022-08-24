class Solution:
    def average(self, salary: List[int]) -> float:
        # O(1) time & O(1) space
        m = min(salary)
        M = max(salary)
        s = sum(salary)
        n = len(salary)
        return (s - M - m) / (n - 2)