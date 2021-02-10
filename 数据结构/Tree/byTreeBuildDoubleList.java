package Tree;
/*
* ����һ�ö��������������ö���������ת����һ�������˫������
* Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
* */

/*
*��Ŀ��Ϣ������(�������) ˫������Ŷ �������½ڵ�
* ˼·
* 1.�������
* 2.������Ҫ��ӡ�Ľڵ���ӵ�˫��������
* */
public class byTreeBuildDoubleList {
    private TreeNode head;
    private TreeNode tail;

    //�������
    public  void preOrder(TreeNode root){
        if(root==null){
            return;
        }
        preOrder(root.left);
        //��ӵ�˫������
        add(root);
        preOrder(root.right);
    }
    //β�巨˫������
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
