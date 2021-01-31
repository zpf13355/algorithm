### 题目

给定一个 N 叉树，返回其节点值的前序遍历。

例如，给定一个 3叉树 :

 



 

返回其前序遍历: [1,3,5,6,2,4]。

 

说明: 递归法很简单，你可以使用迭代法完成此题吗?

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 题解

根+孩子(顺序list)=根+孩子（逆序入栈+出栈）

**1.** 根节点入栈

**2.** 栈顶元素出栈，加入list

**3.** 孩子list逆序入栈

**4.** 循环栈不为空

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
    public List<Integer> preorder(Node root) {
        List<Integer> list=new ArrayList<>();
        Deque<Node> stack=new LinkedList<>();
        if(root==null){
            return list;
        }
        //根节点入栈
        stack.push(root);
        while(!stack.isEmpty()){
            Node node=stack.pop();
            list.add(node.val);
            for(int i=node.children.size()-1;i>=0;i--){
                stack.push(node.children.get(i));
            }
        }
        return list;
    }
}
```



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
    public List<Integer> preorder(Node root) {
        
        if(root==null){
            return list;
        }
        list.add(root.val);
        for(Node node:root.children){
            preorder(node);
        }

        return list;
    }
}
```

