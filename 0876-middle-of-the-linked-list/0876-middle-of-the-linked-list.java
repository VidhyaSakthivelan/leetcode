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
    public ListNode middleNode(ListNode head) {
        ListNode p=head;
        int count=0;
        while(p!=null){//o(n)
            count++;
            p=p.next;
        }
        count=count/2;
        p=head;
        while(p!=null&&count!=0){//o(n/2)
            p=p.next;
            count=count-1;
        }
        return p;
    }
}