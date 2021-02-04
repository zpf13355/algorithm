### 题目

给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。

百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”

例如，给定如下二叉树:  root = [3,5,1,6,2,0,8,null,null,7,4]



 

示例 1:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
输出: 3
解释: 节点 5 和节点 1 的最近公共祖先是节点 3。
示例 2:

输入: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
输出: 5
解释: 节点 5 和节点 4 的最近公共祖先是节点 5。因为根据定义最近公共祖先节点可以为节点本身。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### DFS

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null||p==root||q==root){
            return root;
        }
        TreeNode isLeft=lowestCommonAncestor(root.left,p,q);
        TreeNode isRight=lowestCommonAncestor(root.right,p,q);
        if(isLeft==null){
            return isRight;
        }
        if(isRight==null){
            return isLeft;
        }
        return root;
    }
}
```

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //有一个在根说明公共祖先就是根
        if(p==root||q==root){
            return root;
        }
        
        //搜索节点的位置
        boolean pLeft=search(root.left,p);
        boolean qLeft=search(root.left,q);

        //都在左子树
        if(pLeft&&qLeft){
            return lowestCommonAncestor(root.left,p,q);
        }
        //都在右子树
        if(!pLeft&&!qLeft){
            return lowestCommonAncestor(root.right,p,q);
        }
        
        
       
        //一个在左一个在右，那公共祖先只能是root
        return root;

    }

    private boolean search(TreeNode root,TreeNode t){
        if(root==null){
            return false;
        }
        if(root==t){
            return true;
        }
        if(search(root.left,t)){
            return true;
        }
        return search(root.right,t);
    }
}
```



### BFS

**1.** map保存p和p的父节点（迭代）

**2.** 用集合存储p的祖先节点

**3.** 在p的祖先集合中是否包含q和q的祖先节点

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null){
            return null;
        }
        Deque<TreeNode> queue=new LinkedList<>();
        //记录每个节点的父节点
        Map<TreeNode,TreeNode> map=new HashMap<>();
        //根节点没有父节点
        queue.add(root);
        map.put(root,null);
        //p q都找到就退出循序
        while(!map.containsKey(p)||!map.containsKey(q)){
            TreeNode node=queue.remove();

            if(node.left!=null){
                queue.add(node.left);
                map.put(node.left,node);
            }

            if(node.right!=null){
                queue.add(node.right);
                map.put(node.right,node);
            } 
        } 
        /*
        Set<TreeNode> set=new HashSet<>();
        //将p的祖先节点保存起来
            while(p!=null){
                set.add(p);
                p=map.get(p);
            }
            //在p的祖先节点中找是否存在q或q的祖先节点
            while(!set.contains(q)){
                q=map.get(q);
            }
            */
            List<TreeNode> list=new ArrayList<>();
            while(p!=null){
                list.add(p);
                p=map.get(p);
            }
            while(!list.contains(q)){
                q=map.get(q);
            }
        return q;
    }
}
```

