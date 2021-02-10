package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class NoDiGui {
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
        System.out.print("前序遍历:");
        preOrderTraversal(a);
        System.out.println();
        System.out.print("中序遍历:");
        inOrderTraversal(a);
        System.out.println();
        System.out.print("后序遍历:");
        postOrderTraversal(a);
        System.out.println();


    }
    // 非递归前序遍历
    public static void preOrderTraversal(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode current=root;
        while(!stack.isEmpty()||current!=null){
            while (current!=null){
                System.out.print(current.data);
                stack.push(current);
                current=current.left;

            }
            TreeNode top=stack.pop();
            current=top.right;
        }
    }
    // 非递归中序遍历
    public static void inOrderTraversal(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode current=root;
        while(!stack.isEmpty()||current!=null){
            while (current!=null){

                stack.push(current);
                current=current.left;

            }
            TreeNode top=stack.pop();
            System.out.print(top.data);
            current=top.right;
        }
    }
    // 非递归后序遍历
    public static void postOrderTraversal(TreeNode root){
        Deque<TreeNode> stack=new LinkedList<>();
        TreeNode current=root;
        TreeNode last=null;
        while(!stack.isEmpty()||current!=null){
            while (current!=null){

                stack.push(current);
                current=current.left;

            }
            TreeNode top=stack.peek();

            if (top.right==null){
                //左子树回来
                stack.pop();
                last=top;
                System.out.print(top.data);
            }else if(top.right==last){
                //说明从左子树回来 右子树空
                stack.pop();
                last=top;
                System.out.print(top.data);
            }else{
                //左子树回来 右子树不为空取遍历右
                current=top.right;
            }
        }

    }

}
