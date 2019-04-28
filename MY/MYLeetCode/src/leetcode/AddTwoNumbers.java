package leetcode;

public class AddTwoNumbers {
    /*
    You are given two non-empty linked lists representing two non-negative integers.
    The digits are stored in reverse order and each of their nodes contain a single digit.
    Add the two numbers and return it as a linked list.
    You may assume the two numbers do not contain any leading zero, except the number 0 itself.
    Example:
    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    Output: 7 -> 0 -> 8
    Explanation: 342 + 465 = 807.
    */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode headNode = new ListNode(l1.val +l2.val);
        Integer jinwei = (l1.val +l2.val) / 10;
        headNode.val = (l1.val +l2.val) % 10;

        l1 = l1.next;
        l2 = l2.next;
        ListNode curNode = headNode;

        while (l1 != null && l2 != null) {
            Integer sum = l1.val + l2.val + jinwei;
            curNode.next = new ListNode(sum % 10);
            jinwei = sum / 10;
            curNode = curNode.next;
            l1 = l1.next;
            l2 = l2.next;
        }

        while (l1 != null) {
            if (jinwei > 0) {
                Integer sum = l1.val + jinwei;
                curNode.next = new ListNode(sum % 10);
                jinwei = sum / 10;
                curNode = curNode.next;
                l1 = l1.next;
            } else {
                curNode.next = l1;
                break;
            }
        }

        while (l2 != null) {
            if (jinwei > 0) {
                Integer sum = l2.val + jinwei;
                curNode.next = new ListNode(sum % 10);
                jinwei = sum / 10;
                curNode = curNode.next;
                l2 = l2.next;
            } else {
                curNode.next = l2;
                break;
            }
        }

        if (jinwei > 0) {
            curNode.next = new ListNode(jinwei);
        }

        return headNode;
    }

}
