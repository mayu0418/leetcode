package leetcode;

public class Swap_Nodes_in_Pairs {

    /*
    给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    示例:
    给定 1->2->3->4, 你应该返回 2->1->4->3.
    说明:
    你的算法只能使用常数的额外空间。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    */
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;
        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;
            first.next = second.next;
            current.next = second;
            current.next.next = first;
            current = current.next.next;
        }
        return dummy.next;
    }
}
