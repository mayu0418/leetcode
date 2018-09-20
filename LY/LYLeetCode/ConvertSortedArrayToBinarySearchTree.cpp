/*
 将一个按照升序排列的有序数组，转换为一棵高度平衡二叉搜索树。
 
 本题中，一个高度平衡二叉树是指一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1。
 给定有序数组: [-10,-3,0,5,9],
 
 一个可能的答案是：[0,-3,9,-10,null,5]，它可以表示下面这个高度平衡二叉搜索树：
 
 0
 / \
 -3   9
 /   /
 -10  5
 */
#include <iostream>
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};
struct TreeNode* sortedArrayToBST(int* nums, int numsSize) {
    if (numsSize>0) {
        struct TreeNode *rootNode=(struct TreeNode *)malloc(sizeof(struct TreeNode));
        rootNode->val=nums[numsSize/2];
        //左子树
        if (numsSize/2>0) {
            int currentIndex=numsSize/2-1;
            struct TreeNode *leftNode=(struct TreeNode *)malloc(sizeof(struct TreeNode));
            rootNode->left=leftNode;
            while (currentIndex>=0) {
                leftNode->val=nums[currentIndex];
                struct TreeNode *tempNode=(struct TreeNode *)malloc(sizeof(struct TreeNode));
                leftNode->left=tempNode;
                leftNode->right=NULL;
                leftNode=tempNode;
                currentIndex--;
            }
            leftNode->left=NULL;
            leftNode->right=NULL;
        }
        //右子树
        if (numsSize>numsSize/2) {
            int currentIndex=numsSize/2+1;
            struct TreeNode *rightNode=(struct TreeNode *)malloc(sizeof(struct TreeNode));
            rootNode->right=rightNode;
            while (currentIndex<numsSize) {
                rightNode->val=nums[currentIndex];
                struct TreeNode *tempNode=(struct TreeNode *)malloc(sizeof(struct TreeNode));
                rightNode->right=tempNode;
                rightNode->left=NULL;
                rightNode=tempNode;
                currentIndex++;
            }
            rightNode->left=NULL;
            rightNode->right=NULL;
        }
        return rootNode;
    } else {
        return NULL;
    }
}

//先序遍历二叉树
void bianli(struct TreeNode*root) {
    printf("%d\n",root->val);
    if (root->left) {
        bianli(root->left);
    }
    if (root->right) {
        bianli(root->right);
    }
}

int main(int argc, const char * argv[]) {
    int* nums = (int *)malloc(sizeof(int)*5);
    nums[0]=-3;
    nums[1]=-1;
    nums[2]=3;
    nums[3]=6;
    nums[4]=10;
    struct TreeNode*root=sortedArrayToBST(nums, 5);
    bianli(root);
}
