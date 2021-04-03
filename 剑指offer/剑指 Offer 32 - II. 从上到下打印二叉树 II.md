从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。

>例如:
>给定二叉树: [3,9,20,null,null,15,7],
>![在这里插入图片描述](https://img-blog.csdnimg.cn/20210322214756503.png#pic_center)

返回其层次遍历结果：

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210322214804196.png#pic_center)
### 思路
>- 层序遍历
>- 栈的大小就是每一层节点(上一层取完就是下一层全部入栈之时)

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        Deque<TreeNode> queue=new LinkedList<>();
        if(root==null){
            return list;
        }
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> path=new ArrayList<>();
            //上一层取完时也是下一层加入完，所以栈的大小就是每一层节点的个数
            for(int i=queue.size();i>0;i--){
                TreeNode node=queue.remove();
                path.add(node.val);
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            list.add(path);
        }

        return list;
    }
}
```