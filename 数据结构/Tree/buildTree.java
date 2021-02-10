package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class buildTree {
    /***

     * 构建二叉树
     @param in 传入的带空结点的前序遍历序列
      * @param out 是一个空的 list
     @return 构建的一棵二叉树的根
     */
    public static TreeNode buildTree(List<Character> in, List<Character> out) {
        if (in.isEmpty()) {
            // 没有序列，只能是空树
            // out 仍然是空的
            return null;
        }

        // in 不是 Empty 的了
        char rootVal = in.remove(0);
        if (rootVal == '#') {
            // 剩下的就是 in 去除第一个元素（#）
            // in 由于调用了 remove，已经把第一个元素（下标为0的）取出了
            out.addAll(in);

            // 遇到 # 一定是空树
            return null;
        }

        // rootVal 一定不是 #，构建不同的结点和以该结点为根的树
        TreeNode root = new TreeNode(rootVal);

        // 构建 root 的左子树
        // 这里的 in 由于刚才调用过 in.remove(0) 了，所以，已经不包括第一个元素了
        List<Character> rightOut = new ArrayList<>();
        TreeNode left = buildTree(in, rightOut);

        // 构建 root 的右子树
        // 这里的 rightOut 就是构建右子树用的序列
        // 构建右子树剩下的序列就是构建整棵树剩下的序列
        TreeNode right = buildTree(rightOut, out);

        root.left = left;
        root.right = right;

        return root;
    }
    //字符串转List
    public static List<Character> stoArray(String s){
        List<Character> list=new ArrayList<>();
        for(char c:s.toCharArray()){
            list.add(c);
        }
        return list;
    }
    //中序打印
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
        //字符串转List
        List<Character> in=stoArray(s);
        List<Character> out=new ArrayList<>();
        TreeNode root=buildTree(in,out);
        //中序打印
        midOrder(root);
    }

}
