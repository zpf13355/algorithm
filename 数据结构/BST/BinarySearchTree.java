package BST;

/*
* ����������
* 1.������ 2.�ڵ㱣��ؼ���
* 3��ÿ���ڵ�ؼ���key,������С���йؼ���С��key,���������йؼ��ִ���key
* 4.������������������ȵ�key
* 5.�߱��Ƚ�����
* 6.�������������������һ���������
* */
public class BinarySearchTree {
    TreeNode root;
    public BinarySearchTree(){
        this.root=null;
    }
    public void insert(Integer key){
        if(this.root==null){
            this.root=new TreeNode(key);
            return;
        }
        //��ʶcurrent�ĸ��ڵ�
        TreeNode parentCurrent=null;
        //currentѰ�Ҳ���λ��
        TreeNode current=this.root;
        int cmp=0;
        while (current!=null){
            cmp=key.compareTo(current.key);
            if (cmp==0){
                throw new RuntimeException("������������������ͬ��keyֵ");
            }else if (cmp<0){//�����
                parentCurrent=current;
                current=current.left;
            }else{
                parentCurrent=current;
                current=current.right;
            }
        }
        TreeNode node=new TreeNode(key);
        if (cmp<0){
            parentCurrent.left=node;
        }else{
            parentCurrent.right=node;
        }
    }

    public boolean search(Integer key){
        if (this.root==null){
            return false;
        }
        TreeNode current=this.root;
        while (current!=null){
            int cmp=key.compareTo(current.key);
            if (cmp==0){
                return true;
            }else if(cmp<0){
                current=current.left;
            }else{
                current=current.right;
            }
        }
        return false;
    }
    /*
    * 1.ɾ������Ҷ�ӽڵ�
    * 2.ɾ��������һ�����ӵĽڵ�
    * 3.ɾ���������������ӵĽڵ㣨�滻ɾ����
    *   ѡ���������������Ļ�������������С��
    *
    * */
    public boolean remove(Integer key) {
        if(this.root==null){
            return false;
        }
        //����
        TreeNode parent=null;
        TreeNode current=this.root;
        while (current!=null){
            int cmp=key.compareTo(current.key);
            if (cmp==0){
                //ɾ��
                removeInternal(current,parent);
                return true;
            }else if(cmp<0){
                parent=current;
                current=current.right;
            }else{
                parent=current;
                current=current.left;
            }
        }
        return false;
    }
    private void removeInternal(TreeNode node, TreeNode parent) {
        //ɾ������Ҷ�ӽڵ�
        if(node.left==null&&node.right==null){
            if(this.root==node){//˵��ֻ��һ���ڵ����
                this.root=null;
            }else if (parent.left==node){ //ɾ������ȥ��
                parent.left=null;
            }else{//ɾ�к�����ȥ��
                parent.right=null;
            }
        }else if(node.left!=null&&node.right==null){
            if(this.root==node){
                this.root=node.left;
            }else if (node==parent.left){
                parent.left=node.left;
            }else{
                parent.right=node.right;
            }
        }else if(node.left==null&&node.right!=null){
            if(root==node){
                root=node.right;
            }else if(node==parent.left){
                parent.left=node.left;
            }else{
                parent.right=node.right;
            }
        }else if(node.left!=null&&node.right!=null){

                //���������е����ֵ
            //�����ӿ�ʼһֱ�����ߵ���ͷ
                TreeNode maxParent=node;
                TreeNode max=node.left;
                while (max.right!=null){
                    maxParent=max;
                    max=max.right;
                }

                //�滻-����
            if (maxParent==node){
                maxParent.left=max.right;
            }else{
                maxParent.right=max.left;
            }


        }
    }
}
