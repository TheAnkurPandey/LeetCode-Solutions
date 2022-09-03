class Solution {
    public List<Integer> lexicalOrder(int n) {
        // return lexicalOrderComparator(n);
        return lexicalOrderDfsClient(n);
    }
    
    private List<Integer> lexicalOrderComparator(int n) {
        // O(n* logn) time & O(1) space
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < n; i++) list.add(i + 1);
        
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer i1, Integer i2) {
                return i1.toString().compareTo(i2.toString());
            }
        });
        
        return list;
    }
    
    private List<Integer> lexicalOrderDfsClient(int n) {
        ArrayList<Integer> lexicalOrderList = new ArrayList<>();
        
        for (int prefix = 1; prefix < 10; prefix++) {
            lexicalOrderDfs(prefix, n, lexicalOrderList);    
        }
        
        return lexicalOrderList;
    }
    
    private void lexicalOrderDfs(int prefix, int n, ArrayList<Integer> lexicalOrderList) {
        // Recursion / Backtracking / DFS
        // O(n) time & O(logn) space
        
        // Base case
        if (prefix > n) return;
        
        lexicalOrderList.add(prefix);
        
        // Recursive case
        for (int i = 0; i < 10; i++) {
            int nextPrefix = prefix * 10  + i;
            lexicalOrderDfs(nextPrefix, n, lexicalOrderList);
        }        
    }
}