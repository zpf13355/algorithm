package Tree;

import java.util.Deque;
import java.util.LinkedList;

public class NoDiGui {
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
        System.out.print("ǰ�����:");
        preOrderTraversal(a);
        System.out.println();
        System.out.print("�������:");
        inOrderTraversal(a);
        System.out.println();
        System.out.print("�������:");
        postOrderTraversal(a);
        System.out.println();


    }
    // �ǵݹ�ǰ�����
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
    // �ǵݹ��������
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
    // �ǵݹ�������
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
                //����������
                stack.pop();
                last=top;
                System.out.print(top.data);
            }else if(top.right==last){
                //˵�������������� ��������
                stack.pop();
                last=top;
                System.out.print(top.data);
            }else{
                //���������� ��������Ϊ��ȡ������
                current=top.right;
            }
        }

    }

}
