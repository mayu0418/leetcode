/*
 给定一个不含重复元素的整数数组。一个以此数组构建的最大二叉树定义如下：
 二叉树的根是数组中的最大元素。
 左子树是通过数组中最大值左边部分构造出的最大二叉树。
 右子树是通过数组中最大值右边部分构造出的最大二叉树。
 通过给定的数组构建最大二叉树，并且输出这个树的根节点。
 Example 1:
 输入: [3,2,1,6,0,5]
 输入: 返回下面这棵树的根节点：
 
 6
 /   \
 3     5
 \    /
 2  0
 \
 1
 注意:
 给定的数组的大小在 [1, 1000] 之间。
 */
#include <stdio.h>
struct TreeNode{
        int val;
        struct TreeNode *left;
        struct TreeNode *right;
    };

struct TreeNode* subtree(int* nums,int start,int end) {
    if(start==end) {
        struct TreeNode *node=(struct TreeNode*)malloc(sizeof(struct TreeNode));
        node->val=nums[start];
        node->left=NULL;
        node->right=NULL;
        return node;
    }
    int maxPosition = start;
    int maxNum = nums[start];
    for (int i=start+1; i<=end; i++) {
        if (nums[i]>maxNum) {
            maxNum=nums[i];
            maxPosition=i;
            
        }
    }
    struct TreeNode *node=(struct TreeNode*)malloc(sizeof(struct TreeNode));
    node->val=nums[maxPosition];
    if (maxPosition-start) {
        node->left=subtree(nums,start,maxPosition-1);
    } else {
        node->left=NULL;
    }
    if (end-maxPosition) {
        node->right=subtree(nums,maxPosition+1,end);
    } else {
        node->right=NULL;
    }
    return node;
}


struct TreeNode* constructMaximumBinaryTree(int* nums, int numsSize) {
    struct TreeNode*root =subtree(nums, 0, numsSize-1);
    printf("%d",root->val);
    return root;
}

int main(int argc, const char * argv[]) {
    @autoreleasepool {
        int array[]={3,2,1,6,0,5};
        int *nums=(int*)malloc(sizeof(int)*6);
        for (int i=0; i<6; i++) {
            nums[i]=array[i];
        }
        int numsSize=6;
       struct TreeNode*root=constructMaximumBinaryTree(nums,numsSize);
    }
    return 0;
}
