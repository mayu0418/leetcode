/*
 找树左下角的值
 给定一个二叉树，在树的最后一行找到最左边的值。
 
 输入:
 
 2
 / \
 1   3
 
 输出:
 1
 
 输入:
 
 1
 / \
 2   3
 /   / \
 4   5   6
 /
 7
 
 输出:
 7
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
    struct TreeNode* treeQueue[100];
    int front;
    int rear;
};

//入队列
void push(struct Queue *queue,struct TreeNode* node) {
    queue->treeQueue[queue->rear]=node;
    queue->rear++;
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

int findBottomLeftValue(struct TreeNode* root) {
    struct Queue *queue=(struct Queue *)malloc(sizeof(struct Queue));
    queue->front=0;
    queue->rear=0;
    if (root) {
        push(queue,root);
    }
    while(!queueEmpty(queue)) {
        struct TreeNode *node=pop(queue);
        if (node->right) {
            push(queue, node->right);
        }
        if (node->left) {
            push(queue, node->left);
        }
        if (queueEmpty(queue)) {
            return node->val;
        }
    }
    return root->val;
}

int main(int argc, const char * argv[]) {

}
