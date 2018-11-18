/*
 二叉搜索树中的插入操作
 给定二叉搜索树（BST）的根节点和要插入树中的值，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 保证原始二叉搜索树中不存在新值。
 
 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回任意有效的结果。
 
 例如,
 给定二叉搜索树:
 
 4
 / \
 2   7
 / \
 1   3
 
 和 插入的值: 5
 
 4
 /   \
 2     7
 / \   /
 1   3 5

 */

#include <iostream>

struct TreeNode {
    int val;
    struct TreeNode *left;
    struct TreeNode *right;
};

void insetNode(struct TreeNode* root, int val) {
    if (val>root->val) {
        if (root->right) {
            insetNode(root->right, val);
        } else {
            struct TreeNode *insertNode = (struct TreeNode *)malloc(sizeof(struct TreeNode));
            insertNode->val=val;
            insertNode->left=NULL;
            insertNode->right=NULL;
            root->right=insertNode;
        }
    } else {
        if (root->left) {
            insetNode(root->left, val);
        } else {
            struct TreeNode *insertNode = (struct TreeNode *)malloc(sizeof(struct TreeNode));
            insertNode->val=val;
            insertNode->left=NULL;
            insertNode->right=NULL;
            root->left=insertNode;
        }
    }
}

struct TreeNode* insertIntoBST(struct TreeNode* root, int val) {
    if (root==NULL) {
        struct TreeNode *insertNode = (struct TreeNode *)malloc(sizeof(struct TreeNode));
        return insertNode;
        insertNode->left=NULL;
        insertNode->right=NULL;
    } else {
        insetNode(root, val);
        return root;
    }
}



int main(int argc, const char * argv[]) {
    // insert code here...
    std::cout << "Hello, World!\n";
    struct TreeNode *root = (struct TreeNode *)malloc(sizeof(struct TreeNode));
    root->val = 3;
    root->left = NULL;
    root->right = NULL;
    insertIntoBST(root, 5);
    printf("%d",root->right->val);
    return 0;
}
