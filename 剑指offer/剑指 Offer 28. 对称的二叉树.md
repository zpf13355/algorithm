### 题目
请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。

例如，二叉树 [1,2,2,3,4,4,3] 是对称的。
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210320193729856.png#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210320193738608.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1NjMwNzEx,size_16,color_FFFFFF,t_70#pic_center)但是下面这个 [1,2,2,null,3,null,3] 则不是镜像对称的:


>示例 1：
>输入：root = [1,2,2,3,4,4,3]
>输出：true
>示例 2：
>输入：root = [1,2,2,null,3,null,3]
>输出：false

### 思路
>- 空树是对称数
>- 左右两棵子树是否对称(root1和root2)
>    1. 两棵树均为空，相同
>    2. 两棵树有一颗为空，不相同
>    3. 两棵树均不为空
>    				1. 根节点相同
>                   2. root1的左子树和root2的右子树是否相同
>    		 			3. root1的右子树和root2的左子树是否相同


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
    public boolean isSymmetric(TreeNode root) {
        if(root==null){
            return true;
        }
        return isSame(root.left,root.right);
    }

    private boolean isSame(TreeNode root1,TreeNode root2){
        //两棵树均为空
        if(root1==null&&root2==null){
            return true;
        }

        //一棵空一棵非空

        if(root1==null||root2==null){
            return false;
        }        

        return root1.val==root2.val&&isSame(root1.left,root2.right)&&isSame(root2.left,root1.right);
    }
}
```

### 复杂度
>**时间复杂度O(n)** n个节点均要遍历
>**空间复杂度O(n)**:最差情况下，二叉树退化为链表，系统使用 O(N)O(N) 大小的栈空间。