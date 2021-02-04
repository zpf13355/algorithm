### 题目

给定一棵二叉搜索树，请找出其中第k大的节点。

 

示例 1:

输入: root = [3,1,4,null,2], k = 1
   3
  / \
 1   4
  \
   2
输出: 4
示例 2:

输入: root = [5,3,6,2,4,null,null,1], k = 3
       5
      / \
     3   6
    / \
   2   4
  /
 1
输出: 4

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-sou-suo-shu-de-di-kda-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 中序遍历

中序顺序遍历是递增有序

中序逆序遍历是递减有序的

第k大节点就是中序逆序遍历的低k个节点

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
    int res=0;
    int count=0;
    public int kthLargest(TreeNode root, int k) {
        dfs(root,k);
        return res;
    }
    private void dfs(TreeNode root,int k){
        if(root==null){
            return ;
        }
        dfs(root.right,k);
        count++;
        if(k==count){
            res=root.val;
            return;
        }
        dfs(root.left,k);
    
    }
    

}
```

### 非中序

**1.** 右子树的节点个数等于k-1那么根就是第k大节点

**2.** 右子树节点个数小于k-1就去左子树找k-右子树个数-1(1是根节点)

**3.** 右子树节点个数大于k-1就去右边找第k个节点



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
    public int kthLargest(TreeNode root, int k) {
        int numRight=numTree(root.right);
        if(numRight==k-1){
            return root.val;
        }else if(numRight>k-1){
            return kthLargest(root.right,k);
        } else {//if(numRight<k-1)
            //减1是根
            return kthLargest(root.left,k-numRight-1);
        }
     
    }
    //树的节点个数
    private int numTree(TreeNode root){
        if(root==null){
            return 0;
        }
        int numLeft=numTree(root.left);
        int numRight=numTree(root.right);
        return 1+numLeft+numRight;
    }
}
```

