/*
 24. 两两交换链表中的节点
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
 给定 1->2->3->4, 你应该返回 2->1->4->3.
 说明:
 
 你的算法只能使用常数的额外空间。
 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
 */

#include <iostream>

struct ListNode {
    int val;
    struct ListNode *next;
};

struct ListNode* swapPairs(struct ListNode* head) {
    //给头结点前再加一个节点
    struct ListNode* extra=(struct ListNode*)malloc(sizeof(struct ListNode));
    extra->next=head;
    //pre代码要交换的两个数的之前的数
    struct ListNode*pre=extra;
    //current代表要交换的两个数的第一个数
    struct ListNode*current=head;
    
    while (current!=NULL && current->next!=NULL) {
        printf("%d %d\n",pre->val,current->val);
        //交换开始
        pre->next=current->next;
        current->next=pre->next->next;
        pre->next->next=current;
        //交换结束，pre指针挪动两个位置（即使挪动两个位置pre也不会为空，因为current->next不为空）
        pre=current;
        current=pre->next;
    }
    //返回头结点
    return extra->next;
}

int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    struct ListNode*head=(struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode*node1=(struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode*node2=(struct ListNode*)malloc(sizeof(struct ListNode));
    struct ListNode*node3=(struct ListNode*)malloc(sizeof(struct ListNode));
    head->val=1;
    node1->val=2;
    node2->val=3;
    node3->val=4;
    head->next=node1;
    node1->next=node2;
    node2->next=node3;
    head=swapPairs(head);
                                                 
    return 0;
}
