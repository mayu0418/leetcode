//
//  main.c
//  BinaryToLink
//
//  Created by Yi Li on 2018/10/30.
//  Copyright © 2018年 Yi Li. All rights reserved.
//

#include "iostream"
using namespace std;

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
 };

void findAllNode(struct TreeNode* root, int *currentCount, struct TreeNode **allNode) {
    if (root) {
        //realloc(allNode, sizeof(struct TreeNode *) *((*currentCount)+1));
        allNode[*currentCount]=root;
        (*currentCount)++;
        if (root->left) {
            findAllNode(root->left, currentCount, allNode);
        }
        if (root->right) {
            findAllNode(root->right, currentCount, allNode);
        }
    }
}

void flatten(struct TreeNode* root) {
    struct TreeNode **allNode=(struct TreeNode **)malloc(sizeof(struct TreeNode *) *10000);
    int *currentCount=(int*)malloc(sizeof(int));
    *currentCount=0;
    findAllNode(root, currentCount, allNode);
    for (int i=0; i<*currentCount-1; i++) {
        if (allNode[i]) {
            allNode[i]->left=NULL;
            allNode[i]->right=allNode[i+1];
        }
    }
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
    node1->right=node5;
    
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
    flatten(node1);
}
