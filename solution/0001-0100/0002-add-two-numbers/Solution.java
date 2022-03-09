class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyNode = new ListNode(0);
        int carry = 0;
        ListNode p = dummyNode;
        while(l1 != null || l2 != null || carry != 0){
            if(l1 != null){
                carry += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                carry += l2.val;
                l2 = l2.next;
            }
            p.next = new ListNode(carry % 10);
            p = p.next;
            carry /= 10;
        }
        return dummyNode.next;
    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode p = dummyNode;
        int carry = 0;
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
            carry = sum / 10;
        }
        while(l1 != null){
            int sum = l1.val + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l1 = l1.next;
            carry = sum / 10;
        }
        while(l2 != null){
            int sum = l2.val + carry;
            p.next = new ListNode(sum % 10);
            p = p.next;
            l2 = l2.next;
            carry = sum / 10;
        }
        if(l1 == null && l2 == null && carry > 0){
            p.next = new ListNode(carry);
            p = p.next;
        }
        return dummyNode.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}