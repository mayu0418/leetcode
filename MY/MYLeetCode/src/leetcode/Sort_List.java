package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class Sort_List {
    //在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序。
    public ListNode sortList(ListNode head) {
        ArrayList<Integer> aryLIst = new ArrayList<>();
        ListNode node = head;
        while (node != null) {
            aryLIst.add(node.val);
            node = node.next;
        }
        Object[] ary = aryLIst.toArray();
        Arrays.sort(ary);
        node = head;
        for (int i = 0; i < ary.length; i++) {
            node.val = (Integer) ary[i];
            node = node.next;
        }
        return head;
    }
}
