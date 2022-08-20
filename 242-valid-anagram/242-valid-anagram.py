class Solution:
    def isAnagram(self, s: str, t: str) -> bool:
        # O(max(m, n)) time & O(1) space
        
        # Trivial case
        if len(s) != len(t): return False
        
        # General case
        NUM_OF_CHARS = 256
        char_map = [0] * NUM_OF_CHARS
        
        for i in range(len(s)):
            char_map[ord(s[i])] += 1
            
        for i in range(len(t)):
            char_map[ord(t[i])] -= 1
            
        for i in range(NUM_OF_CHARS):
            if char_map[i] != 0: return False
        return True