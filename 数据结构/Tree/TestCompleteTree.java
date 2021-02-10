package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class TestCompleteTree {
    public static void main(String[] args) {
        // 先构造结点
        TreeNode a = new TreeNode('A');
        TreeNode b = new TreeNode('B');
        TreeNode c = new TreeNode('C');
        TreeNode d = new TreeNode('D');
        TreeNode e = new TreeNode('E');
        TreeNode f = new TreeNode('F');
        TreeNode g = new TreeNode('G');
        TreeNode h = new TreeNode('H');
        TreeNode i = new TreeNode('I');
        TreeNode j = new TreeNode('J');

        // 把结点之间的关系，按照我们的板书上的图，连接起来
        a.left = b;
        a.right = c;
        b.left = d;
        c.left = e;
        c.right = f;
        d.right = g;
        f.left = h;
        f.right = i;
        g.left = j;

        levelOrderTraversal(a);
        System.out.println();

        System.out.println(isCompleteTree(a));

        levelOrderWithLevel(a);
    }
    //层序遍历
    /*
    * 1.首先根节点入队
    * 2.循环边打印(队列不为空)
    *   取出队首元素并打印
    *   如果该节点的左右孩子存在就入队
    * */
    public static void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return ;
        }
        Deque<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.remove();

            System.out.print(node.data);

            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }

        }

    }

    //完全二叉树
    /*
    * 1.首先根节点入队
    * 2.循环判断你队列是不是空
    *   队首元素出队 是空结束循环（说明到了最后一层）
    *   否则该节点的左右子孩子入队（包括null）
    * 3.判断队列中剩余的元素
    *   全空 说明是完全二叉树
    *   不是全空 说明不是完全二叉树
    * */
    public static boolean isCompleteTree(TreeNode root){
        if (root==null){
            return false;
        }
        Deque<TreeNode> queue=new LinkedList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            TreeNode node=queue.remove();
            if(node==null){
                break;
            }
            //左右孩子入队
            queue.add(node.left);
            queue.add(node.right);
        }
        //判断队列中的剩余元素
        while (!queue.isEmpty()){
            if (queue.remove()!=null){
                return false;
            }
        }
        return true;
    }
    //层序遍历打印节点同时打印对应的层数
    //打包节点和层数
    static class NL{
        TreeNode node;
        int level;
        public NL(TreeNode node,int level){
            this.node=node;
            this.level=level;
        }
    }
    public static void levelOrderWithLevel(TreeNode root){
        if (root==null){
            return;
        }
        Deque<NL> queue=new LinkedList<>();
        queue.add(new NL(root,1));
        while (!queue.isEmpty()){
            NL nl=queue.remove();
            TreeNode node=nl.node;
            int level=nl.level;
            System.out.print(node.data);
            System.out.print(level);
            if (node.left!=null){
                queue.add(new NL(node.left,level+1));
            }
            if (node.right!=null){
                queue.add(new NL(node.right,level+1));
            }
        }

    }
}
