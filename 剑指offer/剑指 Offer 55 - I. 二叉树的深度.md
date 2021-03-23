输入一棵二叉树的根节点，求该树的深度。从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。

例如：

给定二叉树 [3,9,20,null,null,15,7]，
![在这里插入图片描述](https://img-blog.csdnimg.cn/2021032320173237.png#pic_center)
返回它的最大深度 3 。

### 解1-DFS(递归)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        int leftHigh=maxDepth(root.left);
        int rightHigh=maxDepth(root.right);

        return Math.max(leftHigh,rightHigh)+1;
    }


}
```
### 复杂度
>**时间复杂度O(n)**:n为二叉树的节点个数
>**空间复杂度O(n)**:二叉树退化为链表递归耗费n个栈空间

### 解2-BFS(层序遍历)
```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int maxDepth(TreeNode root) {
        if(root==null){
            return 0;
        }

        Deque<TreeNode> queue=new LinkedList<>(); 
        int high=0;
        queue.add(root);
        while(!queue.isEmpty()){
           
            
            /*
                以下写法也可
                int len=queue.size();
                for(int i=0;i<len;i++){}
            */
            /*
                以下写法不可，queue.size()是变化的
                for(int i=0;i<queue.size();i++){}
            */
            for(int i=queue.size();i>0;i--){
                TreeNode node=queue.remove();
                if(node.left!=null){
                    queue.add(node.left);
                }

                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            high++;
        }

        return high;
    }
}
```

### 复杂度
>**时间复杂度O(n)**:n为二叉树的节点个数
>**空间复杂度O(n)**: O(n)

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210323195002791.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1NjMwNzEx,size_16,color_FFFFFF,t_70#pic_center)