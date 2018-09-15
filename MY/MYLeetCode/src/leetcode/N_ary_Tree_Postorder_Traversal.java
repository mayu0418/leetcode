package leetcode;

import java.util.ArrayList;
import java.util.List;

public class N_ary_Tree_Postorder_Traversal {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<Integer>();
        test(root,list);
        return list;
    }
    
    void test(Node node,List list) {
        if (node == null) return;;
        for (Node curNode : node.children) {
            test(curNode,list);
        }
        list.add(node.val);
    }
}
