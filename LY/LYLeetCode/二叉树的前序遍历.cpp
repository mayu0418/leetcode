//
//  main.cpp
//  BinaryTreePreorderTraversal
//
//  Created by Yi Li on 2018/10/31.
//  Copyright © 2018年 Yi Li. All rights reserved.
//

#include <iostream>
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

//栈
struct Stack {
    int index;
    struct TreeNode *array[100];
};

//入栈
void push(struct Stack *stack, struct TreeNode *node) {
    stack->array[stack->index]=node;
    stack->index++;
}

//出栈
struct TreeNode *pop(struct Stack *stack) {
    stack->index--;
    return stack->array[stack->index];
}

//出栈
bool isStackEmpty(struct Stack *stack) {
    return !stack->index;
}

int *preorderTraversal(struct TreeNode* root, int *returnSize) {
    *returnSize=0;
    struct Stack *stack=(struct Stack *)malloc(sizeof(struct Stack));
    int *returnArray=(int *)malloc(sizeof(int)*10000);
    if (root!=NULL) {
        push(stack, root);
        while (!isStackEmpty(stack)) {
            struct TreeNode *p=pop(stack);
            returnArray[*returnSize]=p->val;
            (*returnSize)++;
            if (p->right!=NULL) {
                push(stack, p->right);
            }
            if (p->left!=NULL) {
                push(stack, p->left);
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
    
    node4->val=3;
    node4->left=NULL;
    node4->right=NULL;
    
    node5->val=3;
    node5->left=NULL;
    node5->right=node6;
    
    node6->val=3;
    node6->left=NULL;
    node6->right=NULL;
    int *returnSize=(int *)malloc(sizeof(int));
    preorderTraversal(node1, returnSize);
}
