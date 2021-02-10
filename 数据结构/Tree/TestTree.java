package Tree;

import sun.reflect.generics.tree.Tree;

import java.util.Deque;
import java.util.LinkedList;

public class TestTree {

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

        //前序遍历
        System.out.printf("前序遍历: ");
        preTraversal(a);
        System.out.println();
        //中序遍历
        System.out.print("中序遍历: ");
        midTraversal(a);
        System.out.println();
        //后序遍历
        System.out.print("后序遍历: ");
        lastTraversal(a);
        System.out.println();

        //遍点个数
        System.out.println(getSize1(a));
        System.out.println(getSize2(a));

        //叶子节点
        System.out.println(getLeafSize1(a));
        System.out.println(getLeafSize2(a));

        //第k层节点个数
        System.out.println(getKLevelSize(a, 4));

        //树的高度
        System.out.println(getHeight(a));

        //查找
        System.out.println(contains1(a, 'C'));
        System.out.println(contains2(a, 'Z'));
        System.out.println(contains3(a, 'C').data);

        //判断二叉树是否存在指定节点
        System.out.println(contains4(a, c));
        TreeNode m=new TreeNode('C');
        System.out.println(contains4(a, m));
    }
    //前序遍历
    public static void preTraversal(TreeNode root){
        if (root!=null){
            System.out.print(root.data);
            preTraversal(root.left);
            preTraversal(root.right);
        }
    }
    //中序遍历
    public static void midTraversal(TreeNode root){
        if (root!=null){
            preTraversal(root.left);
            System.out.print(root.data);
            preTraversal(root.right);
        }
    }
    //后序遍历
    public static void lastTraversal(TreeNode root){
        if (root!=null){
            preTraversal(root.left);
            preTraversal(root.right);
           System.out.print(root.data);
        }
    }


    static int n = 0;
    // 遍历思路-求结点个数
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
    汇总方式-求结点个数
    根+左子树+右子树
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

    // 遍历思路-求叶子结点个数
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

    // 子问题思路-求叶子结点个数
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

    // 子问题思路-求第 k 层结点个数
    /*
    * 1.空树 返回0
    * 2.k=1 返回1
    * 3.k>1 求第k层
    *      相等于求左子树 第k-1层
    *           递归
    *      相当于求右子树 第k-1层
    *           递归
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
    // 获取二叉树的高度
    /*
    * 1.空树 高度=0
    * 2.一个节点 高度=1
    * 3.其他
    *   MAX(左子树高度，右子树高度)+1
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
    * 1. 空树 没找到
    * 2. 非空树
    *   1.根节点是 找到
    *   2.根节点不是 没找到
    *       左子树找
    *           找到 结束
    *           没找到 右子树找
    *                   找到结束
    *                   没找到也结束
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
    //判断二叉树是否存在指定节点(二叉树中的节点)
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
