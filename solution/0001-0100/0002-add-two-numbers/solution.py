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