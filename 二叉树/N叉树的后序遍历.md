### 题目

给定一个 N 叉树，返回其节点值的后序遍历。

例如，给定一个 3叉树 :

 



 

返回其后序遍历: [5,6,3,2,4,1].

 

说明: 递归法很简单，你可以使用迭代法完成此题吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-postorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 题解

孩子(左右)+根

**1.** 根节点入栈

**2.** 栈顶元素出栈并加入list(头插法)，就是是孩子+根

**3.** 正序加入栈，逆序出栈刚好左右孩子

### 代码

```jaav
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
    public List<Integer> postorder(Node root) {
        Deque<Node> stack=new LinkedList<>();
        List<Integer> list=new LinkedList<>();
        if(root==null){
            return list;
        }
        stack.push(root);

        while(!stack.isEmpty()){
            Node node=stack.pop();
            list.add(0,node.val);
            for(int i=0;i<node.children.size();i++){
                stack.push(node.children.get(i));
            }
        }
        return list;
    }
}
```



### 递归

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
    List<Integer> list=new ArrayList<>();
    public List<Integer> postorder(Node root) {
        
        if(root==null){
            return list;
        }
        
        for(Node node:root.children){
            postorder(node);
        }
        list.add(root.val);
        return list;

    }
}
```



