import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

public class Solution {

    ArrayList<Integer> res = new ArrayList<>();
    public List<Integer> preorder(Node root) {

        if(root ==null){
            return res;
        }
        res.add(root.val);
        for(Node node:root.children){
            preorder(node);
        }

        return res;
    }
}
