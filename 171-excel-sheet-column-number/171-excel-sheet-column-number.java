class Solution {
    public int titleToNumber(String columnTitle) {
        // O(n) time & O(1) space
        
        int result = 0;
        
        for(int i = 0; i < columnTitle.length(); i++) {
            char ch = columnTitle.charAt(i);
            result = result * 26 + charToInt(ch);
        }
        
        return result;
    }
    
    private int charToInt(char ch) {
        return ch - 'A' + 1;
    }
}