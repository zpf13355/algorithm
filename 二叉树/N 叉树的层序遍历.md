### 题目

给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。

树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。

 

示例 1：



输入：root = [1,null,3,2,4,null,5,6]
输出：[[1],[3,2,4],[5,6]]
示例 2：



输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 题解

层序遍历

### 代码

```java
/*
// Definition for a Node.
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
*/

class Solution {
    static class NL{
        Node node;
        int level;
        public NL(Node node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> list=new ArrayList<>();
        Deque<NL> queue=new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.add(new NL(root,0));

        while(!queue.isEmpty()){
            NL nl=queue.remove();
            Node node=nl.node;
            int level=nl.level;
            //添加空链表
            if(list.size()==level){
                list.add(new ArrayList<>());
            }
            list.get(level).add(node.val);
            int newLevel=level+1;
            for(int i=0;i<node.children.size();i++){
                queue.add(new NL(node.children.get(i),newLevel));
            }

        }
        return list;
    }
}
```

