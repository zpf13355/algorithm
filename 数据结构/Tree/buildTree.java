package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class buildTree {
    /***

     * ����������
     @param in ����Ĵ��ս���ǰ���������
      * @param out ��һ���յ� list
     @return ������һ�ö������ĸ�
     */
    public static TreeNode buildTree(List<Character> in, List<Character> out) {
        if (in.isEmpty()) {
            // û�����У�ֻ���ǿ���
            // out ��Ȼ�ǿյ�
            return null;
        }

        // in ���� Empty ����
        char rootVal = in.remove(0);
        if (rootVal == '#') {
            // ʣ�µľ��� in ȥ����һ��Ԫ�أ�#��
            // in ���ڵ����� remove���Ѿ��ѵ�һ��Ԫ�أ��±�Ϊ0�ģ�ȡ����
            out.addAll(in);

            // ���� # һ���ǿ���
            return null;
        }

        // rootVal һ������ #��������ͬ�Ľ����Ըý��Ϊ������
        TreeNode root = new TreeNode(rootVal);

        // ���� root ��������
        // ����� in ���ڸղŵ��ù� in.remove(0) �ˣ����ԣ��Ѿ���������һ��Ԫ����
        List<Character> rightOut = new ArrayList<>();
        TreeNode left = buildTree(in, rightOut);

        // ���� root ��������
        // ����� rightOut ���ǹ����������õ�����
        // ����������ʣ�µ����о��ǹ���������ʣ�µ�����
        TreeNode right = buildTree(rightOut, out);

        root.left = left;
        root.right = right;

        return root;
    }
    //�ַ���תList
    public static List<Character> stoArray(String s){
        List<Character> list=new ArrayList<>();
        for(char c:s.toCharArray()){
            list.add(c);
        }
        return list;
    }
    //�����ӡ
    public static void midOrder(TreeNode root){
        if(root==null){
            return;
        }
        midOrder(root.left);
        System.out.print(root.data+" ");
        midOrder(root.right);
    }

    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        String s=input.nextLine();
        //�ַ���תList
        List<Character> in=stoArray(s);
        List<Character> out=new ArrayList<>();
        TreeNode root=buildTree(in,out);
        //�����ӡ
        midOrder(root);
    }

}
