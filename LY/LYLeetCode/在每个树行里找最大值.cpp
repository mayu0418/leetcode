/*
 您需要在二叉树的每一行中找到最大的值。
 
 示例：
 
 输入:
 
 1
 / \
 3   2
 / \   \
 5   3   9
 
 输出: [1, 3, 9]
 */

#include <iostream>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

//队列
struct Queue
{
    struct TreeNode* treeQueue[1000];
    int front;
    int rear;
};

//入队列
void push(struct Queue *queue,struct TreeNode* node) {
    queue->treeQueue[queue->rear]=node;
    queue->rear++;
}

//最前面的元素
struct TreeNode* frontNode(struct Queue *queue) {
    return queue->treeQueue[queue->front];
}

//判断队列是否为空
bool queueEmpty(struct Queue *queue) {
    return queue->rear<=queue->front;
}

//出队列
struct TreeNode* pop(struct Queue *queue) {
    struct TreeNode *node=NULL;
    if (queue->rear>queue->front) {
        //队列非空
        node=queue->treeQueue[queue->front];
        queue->front++;
    }
    return node;
}

int* largestValues(struct TreeNode* root, int* returnSize) {

    *returnSize = 0;
    int *returnArray=(int *)malloc(sizeof(int)*1000);
    struct Queue *q1=(struct Queue *)malloc(sizeof(struct Queue));
    q1->front=0;
    q1->rear=0;
    struct Queue *q2=(struct Queue *)malloc(sizeof(struct Queue));
    q2->front=0;
    q2->rear=0;
    if (root!=NULL) {
        push(q1, root);
        while (!queueEmpty(q1)||!queueEmpty(q2)) {
            if (!queueEmpty(q1)) {
                int max=frontNode(q1)->val;
                while (!queueEmpty(q1)) {
                    struct TreeNode* node=pop(q1);
                    if (node!=NULL&&node->val!=NULL&&node->val>max) {
                        max=node->val;
                    }
                    if (node->left!=NULL) {
                        push(q2, node->left);
                    }
                    if (node->right!=NULL) {
                        push(q2, node->right);
                    }
                }
                returnArray[*returnSize]=max;
                (*returnSize)++;
            }
            
            if (!queueEmpty(q2)) {
                int max=frontNode(q2)->val;
                while (!queueEmpty(q2)) {
                    struct TreeNode* node=pop(q2);
                    if (node!=NULL&&node->val!=NULL&&node->val>max) {
                        max=node->val;
                    }
                    if (node->left!=NULL) {
                        push(q1, node->left);
                    }
                    if (node->right!=NULL) {
                        push(q1, node->right);
                    }
                }
                returnArray[*returnSize]=max;
                (*returnSize)++;
            }
        }
    }
    return returnArray;
}

int main(int argc, const char * argv[]) {
    struct TreeNode *node1=(struct TreeNode*)malloc(sizeof(struct TreeNode));
    struct TreeNode *node2=(struct TreeNode*)malloc(sizeof(struct TreeNode));
    struct TreeNode *node3=(struct TreeNode*)malloc(sizeof(struct TreeNode));
    struct TreeNode *node4=(struct TreeNode*)malloc(sizeof(struct TreeNode));
    struct TreeNode *node5=(struct TreeNode*)malloc(sizeof(struct TreeNode));
    struct TreeNode *node6=(struct TreeNode*)malloc(sizeof(struct TreeNode));
    node1->val=1;
    node1->left=node2;
    node1->right=NULL;
    
    node2->val=2;
    node2->left=node3;
    node2->right=node4;
    
    node3->val=3;
    node3->left=NULL;
    node3->right=NULL;
    
    node4->val=4;
    node4->left=NULL;
    node4->right=NULL;
    
    node5->val=5;
    node5->left=NULL;
    node5->right=node6;
    
    node6->val=6;
    node6->left=NULL;
    node6->right=NULL;
    int *returnSize=(int *)malloc(sizeof(int));
    largestValues(node1, returnSize);
}
