class Solution {
    public int evalRPN(String[] tokens) {
        // O(n) time & O(n) space
        
        int n = tokens.length;
        int itr = 0;
        
        LinkedList<Integer> valueStack = new LinkedList<>();
        int num = Integer.parseInt(tokens[itr++]);
        valueStack.addLast(num);
        
        while (itr < n) {
            String token = tokens[itr++];
            
            if (isOperator(token)) {  // Token is operator then evaluate
                
                int operandY = valueStack.removeLast();
                int operandX = valueStack.removeLast();
                
                String operator = token;
                int result = calculate(operandX, operandY, operator);
                
                valueStack.addLast(result);
                
            } else {  // Otherwise push into stack
                num = Integer.parseInt(token);
                valueStack.addLast(num);
            }
        }
        
        // Top of the stack contains the result
        int result = valueStack.removeLast();
        return result;
    }
    
    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }
    
    private int calculate(int x, int y, String operator) {
        if (operator.equals("+")) return x + y;
        else if (operator.equals("-")) return x - y;
        else if (operator.equals("*")) return x * y;
        else if (operator.equals("/")) return x / y;
        else throw new IllegalArgumentException("Invalid operator");
    }
}