class Solution:
    def mergeAlternately(self, word1: str, word2: str) -> str:
        # TC: O(max(m, n)); SC: O(1) 
        res = ""
        l1, l2 = len(word1), len(word2)
        overlap_len = min(l1, l2)
        for i in range(overlap_len):
            res += word1[i] + word2[i]
        
        if (l1 > l2):
            res += word1[overlap_len :]
        else:
            res += word2[overlap_len :]

        return res

        