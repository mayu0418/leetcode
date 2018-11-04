/*
 根据一棵树的中序遍历与后序遍历构造二叉树。
 
 注意:
 你可以假设树中没有重复的元素。
 
 例如，给出
 
 中序遍历 inorder = [9,3,15,20,7]
 后序遍历 postorder = [9,15,7,20,3]
 返回如下的二叉树：
 
 3
 / \
 9  20
 /  \
 15   7
 */

#include <iostream>
struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};


struct TreeNode* creatTree(int* inorder, int inorderSize, int* postorder, int postorderSize, int start, int end, int *rootIndex) {
    int value=postorder[*rootIndex];
    struct TreeNode *node=(struct TreeNode *)malloc(sizeof(struct TreeNode));
    node->val=value;
    for (int i=0; i<inorderSize; i++) {
        if (inorder[i]==value) {
            if (end>i) {
                (*rootIndex)--;
                node->right=creatTree(inorder, inorderSize, postorder, postorderSize, i+1, end, rootIndex);
            }
            if (start<i) {
                (*rootIndex)--;
                node->left=creatTree(inorder, inorderSize, postorder, postorderSize, start, i-1, rootIndex);
            }
        }
    }
    return node;
}

struct TreeNode* buildTree(int* inorder, int inorderSize, int* postorder, int postorderSize) {
    if (inorderSize==0||inorderSize!=postorderSize) {
        return NULL;
    }
    int *rootIndex=(int *)malloc(sizeof(int));
    *rootIndex=postorderSize-1;
    return creatTree(inorder, inorderSize, postorder, postorderSize, 0, postorderSize-1, rootIndex);
}

int main(int argc, const char * argv[]) {
    int *inorder=(int *)malloc(sizeof(int)*3);
    int *postorder=(int *)malloc(sizeof(int)*3);
    int a[3]={3,2,1};
    int b[3]={3,2,1};
    for (int i=0; i<3; i++) {
        inorder[i]=a[i];
        postorder[i]=b[i];
    }
    int *inorderSize=(int *)malloc(sizeof(int));
    *inorderSize=3;
    int *postorderSize=(int *)malloc(sizeof(int));
    *postorderSize=3;
    buildTree(inorder, 3, postorder, 3);
    
}
