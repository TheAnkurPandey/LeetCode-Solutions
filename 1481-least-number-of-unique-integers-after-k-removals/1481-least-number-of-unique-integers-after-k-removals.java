class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        // O(n*logn) time & O(n) space
        
        int n = arr.length;
        
        // Store the value in frequency map
        HashMap<Integer, Integer> freqMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int newFreq = freqMap.getOrDefault(arr[i], 0) + 1;
            freqMap.put(arr[i], newFreq);
        }
        
        // Store entries into list
        ArrayList<Map.Entry<Integer, Integer>> entries = new ArrayList<>(freqMap.entrySet());
        
        // Sort the entries by value (Sorting hashmap by value)
        Collections.sort(entries, 
                         new Comparator<Map.Entry<Integer, Integer>>() {
                             @Override
                             public int compare(Map.Entry<Integer, Integer> e1, 
                                                Map.Entry<Integer, Integer> e2) {
                                 return e1.getValue() - e2.getValue();
                             }
                         }
                        );
        
        // Getting unique elements left
        int leastUniqueElementsLeft = entries.size();
        
        for (int i = 0; i < entries.size(); i++) {
            
            int itemFreq= entries.get(i).getValue();
            
            if (itemFreq <= k) {  // Unique item can be remove
                leastUniqueElementsLeft--;
                k -= itemFreq;
            } else break;
        }
        
        return leastUniqueElementsLeft;
    }
}