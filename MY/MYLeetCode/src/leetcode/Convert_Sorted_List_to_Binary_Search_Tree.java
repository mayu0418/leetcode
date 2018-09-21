package leetcode;


import java.util.ArrayList;

//升序链表转二叉搜索树
public class Convert_Sorted_List_to_Binary_Search_Tree {
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) return null;
        ArrayList aryList =  new ArrayList();
        while (head != null) {
            aryList.add(head.val);
            head = head.next;
        }
        return test(aryList,0,aryList.size() - 1);
    }
    TreeNode test(ArrayList aryList,int start,int end) {
        if (start > end) return null;
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode((int)aryList.get(mid));
        node.left = test(aryList,start,mid - 1);
        node.right = test(aryList,mid + 1,end);
        return node;
    }
}
