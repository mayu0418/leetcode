package leetcode;

import java.util.ArrayList;
import java.util.List;

public class N_ary_Tree_Preorder_Traversal {
    public List<Integer> preorder(Node root) {
        List ary = new ArrayList();
        test(root,ary);
        return ary;
    }
    
    void test(Node node, List list) {
        if (node == null) return;;
        list.add(node.val);
        for (Node curNode : node.children) {
            test(curNode,list);
        }
    }

}
