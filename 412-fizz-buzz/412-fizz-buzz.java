class Solution {
    public List<String> fizzBuzz(int n) {
        // O(n) time & O(1) space
        
        final String FIZZBUZZ = "FizzBuzz";
        final String FIZZ = "Fizz";
        final String BUZZ = "Buzz";
        
        ArrayList<String> answer = new ArrayList<>();
        
        for(int i = 0; i < n; i++) {
            int index = i + 1;
            
            if(index%15 == 0) {
                answer.add(FIZZBUZZ);
            } else if(index%5 == 0) {
                answer.add(BUZZ);
            } else if(index%3 == 0) {
                answer.add(FIZZ);
            } else {
                answer.add(Integer.toString(index));
            }
        }
        
        return answer;
    }
}