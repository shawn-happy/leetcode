## Description
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

### Example 1
```
Input: l1 = [2,4,3], l2 = [5,6,4]
Output: [7,0,8]
Explanation: 342 + 465 = 807.
```

### Example 2
```
Input: l1 = [0], l2 = [0]
Output: [0]
```

### Example 3
```
Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
Output: [8,9,9,9,0,0,0,1]
```

### Constraints
* The number of nodes in each linked list is in the range [1, 100].
* 0 <= Node.val <= 9
* It is guaranteed that the list represents a number that does not have leading zeros.

## Solutions

### java
```java
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
```

### python3
```python
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        dummyNode = ListNode()
        carry = 0
        cur = dummyNode
        while l1 != None or l2 != None or carry != 0:
            sum = (0 if l1 == None else l1.val) + (0 if l2 == None else l2.val) + carry
            carry, val = divmod(sum, 10)
            cur.next = ListNode(val=val)
            cur = cur.next
            l1 = None if not l1 else l1.next
            l2 = None if not l2 else l2.next
        return dummyNode.next

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
```


## Source Link
[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)