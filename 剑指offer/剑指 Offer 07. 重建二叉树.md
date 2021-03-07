### 题目

输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

 

例如，给出

前序遍历 preorder = [3,9,20,15,7]
中序遍历 inorder = [9,3,15,20,7]
返回如下的二叉树：

    3
   / \
  9  20
    /  \
   15   7

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zhong-jian-er-cha-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 代码

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
    //前序数组
    int[] preorder;
    //HashMap用于查找中序的功能节点位置
    Map<Integer,Integer> map=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder=preorder;
        //中序存入HashMap
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }

        return recur(0,0,inorder.length-1);
    }

    private TreeNode recur(int root,int left,int right){
        //递归终止
        if(left>right){
            return null;
        }

        //构建根节点
        TreeNode node=new TreeNode(preorder[root]);
        //获取中序的根节点的位置
        int i=map.get(preorder[root]);

        //递归左子树
        node.left=recur(root+1,left,i-1);
        node.right=recur(root+i-left+1,i+1,right);

        return node;
    }
}
```

