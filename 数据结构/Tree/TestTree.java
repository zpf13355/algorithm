package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class TestTree {

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

        //ǰ�����
        System.out.printf("ǰ�����: ");
        preTraversal(a);
        System.out.println();
        //�������
        System.out.print("�������: ");
        midTraversal(a);
        System.out.println();
        //�������
        System.out.print("�������: ");
        lastTraversal(a);
        System.out.println();

        //������
        System.out.println(getSize1(a));
        System.out.println(getSize2(a));

        //Ҷ�ӽڵ�
        System.out.println(getLeafSize1(a));
        System.out.println(getLeafSize2(a));

        //��k��ڵ����
        System.out.println(getKLevelSize(a, 4));

        //���ĸ߶�
        System.out.println(getHeight(a));

        //����
        System.out.println(contains1(a, 'C'));
        System.out.println(contains2(a, 'Z'));
        System.out.println(contains3(a, 'C').data);

        //�ж϶������Ƿ����ָ���ڵ�
        System.out.println(contains4(a, c));
        TreeNode m=new TreeNode('C');
        System.out.println(contains4(a, m));
    }
    //ǰ�����
    public static void preTraversal(TreeNode root){
        if (root!=null){
            System.out.print(root.data);
            preTraversal(root.left);
            preTraversal(root.right);
        }
    }
    //�������
    public static void midTraversal(TreeNode root){
        if (root!=null){
            preTraversal(root.left);
            System.out.print(root.data);
            preTraversal(root.right);
        }
    }
    //�������
    public static void lastTraversal(TreeNode root){
        if (root!=null){
            preTraversal(root.left);
            preTraversal(root.right);
           System.out.print(root.data);
        }
    }


    static int n = 0;
    // ����˼·-�������
    public static int getSize1(TreeNode root){
         //n=0;
        preOrder1(root);
        return n;
    }
    public static void  preOrder1(TreeNode root){
        if(root!=null){
            n++;
            preOrder1(root.left);
            preOrder1(root.right);
        }
    }
    /*
    ���ܷ�ʽ-�������
    ��+������+������
     */
    public static int getSize2(TreeNode root){
        if(root==null){
            return 0;
        }else{
            int rootNode=1;
            int leftNode=getSize2(root.left);
            int rightNode=getSize2(root.right);
            return rootNode+leftNode+rightNode;
        }
    }

    // ����˼·-��Ҷ�ӽ�����
    static int leafSize = 0;
    public static int getLeafSize1(TreeNode root){
        preOrder2(root);
        return leafSize;
    }

    public static void  preOrder2(TreeNode root){
        if(root!=null){
            if(root.left==null&&root.right==null){
                leafSize++;
            }
            preOrder2(root.left);
            preOrder2(root.right);
        }
    }

    // ������˼·-��Ҷ�ӽ�����
   public static int getLeafSize2(TreeNode root){
        if (root==null){
            return 0;
        }else if (root.left==null&&root.right==null){
            return 1;
        }else{
            int leftLeaf=getLeafSize2(root.left);
            int rightLeaf=getLeafSize2(root.right);
            return leftLeaf+rightLeaf;
        }
    }

    // ������˼·-��� k �������
    /*
    * 1.���� ����0
    * 2.k=1 ����1
    * 3.k>1 ���k��
    *      ������������� ��k-1��
    *           �ݹ�
    *      �൱���������� ��k-1��
    *           �ݹ�
    *
    * */
    public static int getKLevelSize(TreeNode root,int k){
        if (root==null){
            return 0;
        }else if (k==1){
            return 1;
        }else{
            int leftk=getKLevelSize(root.left,k-1);
            int rightk=getKLevelSize(root.right,k-1);
            return leftk+rightk;
        }
    }
    // ��ȡ�������ĸ߶�
    /*
    * 1.���� �߶�=0
    * 2.һ���ڵ� �߶�=1
    * 3.����
    *   MAX(�������߶ȣ��������߶�)+1
    * */
    public static int getHeight(TreeNode root){
        if (root==null){
            return 0;
        }else if (root.left==null&&root.right==null){
            return 1;
        }else{
            int leftHeight=getHeight(root.left);
            int rightHeight=getHeight(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
    /*
    * 1. ���� û�ҵ�
    * 2. �ǿ���
    *   1.���ڵ��� �ҵ�
    *   2.���ڵ㲻�� û�ҵ�
    *       ��������
    *           �ҵ� ����
    *           û�ҵ� ��������
    *                   �ҵ�����
    *                   û�ҵ�Ҳ����
    *
    * */
    public static boolean contains1(TreeNode root, char v){
        if (root==null){
            return false;
        }else{
            if (root.data==v){
                return true;
            }else{
                boolean leftv=contains1(root.left,v);
                if (!leftv){
                    boolean rightv=contains1(root.right,v);
                    if (!rightv){
                        return false;
                    }else{
                        return true;
                    }
                }else {
                    return true;
                }
            }
        }
    }
    public static boolean contains2(TreeNode root, char v){
        if (root==null){
            return false;
        }
        if (root.data==v){
            return true;
        }
        if (contains2(root.left,v)){
            return true;
        }
        return contains2(root.right,v);
    }

    public static TreeNode contains3(TreeNode root, char v){
        if (root==null){
            return null;
        }
        if (root.data==v){
            return root;
        }
        TreeNode leftNode=contains3(root.left,v);
        if (leftNode!=null){
            return leftNode;
        }
        return contains3(root.right,v);
    }
    //�ж϶������Ƿ����ָ���ڵ�(�������еĽڵ�)
    public static boolean contains4(TreeNode root, TreeNode node){
        if (root==null){
            return false;
        }
        if (root==node){
            return true;
        }
        boolean leftNode=contains4(root.left,node);
        if (leftNode){
            return true;
        }
        return contains4(root.right,node);
    }


}
