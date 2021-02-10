package Tree;
/*
* 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。
* 要求不能创建任何新的结点，只能调整树中结点指针的指向。
* */

/*
*题目信息：排序(中序遍历) 双向连败哦 不创建新节点
* 思路
* 1.中序遍历
* 2.遍历的要打印的节点添加到双向链表即可
* */
public class byTreeBuildDoubleList {
    private TreeNode head;
    private TreeNode tail;

    //中序遍历
    public  void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        preOrder(root.left);
        //添加到双向链表
        add(root);
        preOrder(root.right);
    }
    //尾插法双向链表
    public  void add(TreeNode node){
        if(head==null){
            head=tail=node;
        }else{
            node.left=tail;
            tail.right=node;
            tail=node;
        }

    }
    public TreeNode Convert(TreeNode pRootOfTree) {
        head = tail= null;
        preOrder(pRootOfTree);
        return head;
    }

}
