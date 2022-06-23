class Solution {
    public int romanToInt(String s) {
        // O(n) time & O(1) space
        
        int[] charToNumMap = new int[256];
        charToNumMap['I'] = 1;
        charToNumMap['V'] = 5;
        charToNumMap['X'] = 10;
        charToNumMap['L'] = 50;
        charToNumMap['C'] = 100;
        charToNumMap['D'] = 500;
        charToNumMap['M'] = 1000;
        
        int result = 0;
        
        int len = s.length();
        for(int i = 0; i < len; i++) {
            
            char currChar = s.charAt(i);
            int currCharToNum = charToNumMap[currChar];
            
            // All chars except rightmost
            if(i + 1 < len) {
                char nextChar = s.charAt(i + 1);
                int nextCharToNum = charToNumMap[nextChar];
                
                if(currCharToNum < nextCharToNum) {
                    result += nextCharToNum - currCharToNum;
                    i++; // Jump ahead by 2
                } else {
                    result += currCharToNum;
                }
            } 
            
            // Rightmost char
            else {
                result += currCharToNum;
            }
            
        }
        
        return result;        
    }
}