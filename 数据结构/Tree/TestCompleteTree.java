package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class TestCompleteTree {
    public static void main(String[] args) {
        // �ȹ�����
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

        // �ѽ��֮��Ĺ�ϵ���������ǵİ����ϵ�ͼ����������
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
    //�������
    /*
    * 1.���ȸ��ڵ����
    * 2.ѭ���ߴ�ӡ(���в�Ϊ��)
    *   ȡ������Ԫ�ز���ӡ
    *   ����ýڵ�����Һ��Ӵ��ھ����
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

    //��ȫ������
    /*
    * 1.���ȸ��ڵ����
    * 2.ѭ���ж�������ǲ��ǿ�
    *   ����Ԫ�س��� �ǿս���ѭ����˵���������һ�㣩
    *   ����ýڵ�������Ӻ�����ӣ�����null��
    * 3.�ж϶�����ʣ���Ԫ��
    *   ȫ�� ˵������ȫ������
    *   ����ȫ�� ˵��������ȫ������
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
            //���Һ������
            queue.add(node.left);
            queue.add(node.right);
        }
        //�ж϶����е�ʣ��Ԫ��
        while (!queue.isEmpty()){
            if (queue.remove()!=null){
                return false;
            }
        }
        return true;
    }
    //���������ӡ�ڵ�ͬʱ��ӡ��Ӧ�Ĳ���
    //����ڵ�Ͳ���
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
