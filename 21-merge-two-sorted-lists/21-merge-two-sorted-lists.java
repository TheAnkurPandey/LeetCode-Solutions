/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // O(m + n) time & O(1) space
        
        // Edge cases
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        // Create Iterators
        ListNode list1Itr = list1;
        ListNode list2Itr = list2;
        
        // Setting head of merged list & iterator
        ListNode mergedListHead = new ListNode(Integer.MIN_VALUE);  // Header node
        ListNode mergedListItr = mergedListHead;
        
        // Iterate till each list has nodes in it
        while (list1Itr != null && list2Itr != null) {
            if (list1Itr.val <= list2Itr.val) {
                mergedListItr.next = list1Itr;
                list1Itr = list1Itr.next;
            } else {
                mergedListItr.next = list2Itr;
                list2Itr = list2Itr.next;
            }
            
            mergedListItr = mergedListItr.next;  // Advace the pointer
        }
        
        if (list1Itr == null) mergedListItr.next = list2Itr;
        if (list2Itr == null) mergedListItr.next = list1Itr;
        
        return mergedListHead.next;  // List without header node
    }
}