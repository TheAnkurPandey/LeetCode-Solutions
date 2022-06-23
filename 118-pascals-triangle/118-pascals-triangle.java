class Solution {
    public List<List<Integer>> generate(int numRows) {
        // O() time & O() space
        
        List<List<Integer>> pascalTriangle = new ArrayList<>();
        
        // Base case - Adding top element
        ArrayList<Integer> row = new ArrayList<>();
        row.add(1);
        pascalTriangle.add(row);
        
        // Rest
        for(int i = 1; i < numRows; i++) {
            // Left most
            row = new ArrayList<>();
            row.add(1);
            
            for(int j = 1; j < i; j++) {
                int a = pascalTriangle.get(i - 1).get(j - 1);
                int b = pascalTriangle.get(i - 1).get(j);
                
                row.add(a + b);
            }
            
            // Right most
            row.add(1);
            pascalTriangle.add(row);
        }
        
        return pascalTriangle;
    }
}