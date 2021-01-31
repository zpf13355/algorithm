### 题目

从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

 

例如:
给定二叉树: [3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
返回：

[3,9,20,15,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/cong-shang-dao-xia-da-yin-er-cha-shu-lcof
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        if(root==null){
            return list;
        }
        //根节点入队
        queue.add(root);
        while(!queue.isEmpty()){
            List<Integer> temp=new ArrayList<>();
            //queu每次爆粗你的就是每层节点
            for(int i=queue.size();i>0;i--){
                TreeNode node=queue.remove();
                temp.add(node.val);
                //把下一层节点入队
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            list.add(temp);
        }
        return list;
    }
}
```

