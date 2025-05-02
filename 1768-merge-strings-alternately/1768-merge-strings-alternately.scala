object Solution {
    def mergeAlternately(word1: String, word2: String): String = {
        // TC: O(max(m, n)); SC: O(1)
        val res = new StringBuilder
        val l1 = word1.length
        val l2 = word2.length
        val overlapLen = Math.min(l1, l2)

        for (i <- 0 until overlapLen) {
            res.append(word1(i))
            res.append(word2(i))
        }

        if (l1 > l2) {
            res.append(word1.substring(overlapLen))
        } else {
            res.append(word2.substring(overlapLen))
        }

        res.toString
        
    }
}