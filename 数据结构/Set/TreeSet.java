package Set;

public class TreeSet implements Set{
    public TreeNode root;
    int size=0;

    @Override
    public boolean add(Integer e) {
        if(this.root==null){
            this.root=new TreeNode(e);
            size++;
            return true;
        }

        TreeNode parentCurrent=null;
        TreeNode current=root;
        int cmp=0;
        while (current!=null){
            cmp=e.compareTo(current.key);
            if(cmp==0){
                return false;
            }else if(cmp<0){
                parentCurrent=current;
                current=current.right;
            }else{
                parentCurrent=current;
                current=current.left;
            }
        }
        TreeNode node=new TreeNode(e);
        if(cmp<0){
            parentCurrent.left=node;
        }else{
            parentCurrent.right=node;
        }
        this.size++;
        return true;
    }

    @Override
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
    @Override
    public boolean contains(Object o) {
        Comparable<Integer> comparable = (Comparable<Integer>)o;
        TreeNode current=null;
        while(current!=null){
            int cmp=comparable.compareTo(current.key);
            if(cmp==0){
                return true;
            }else if(cmp<0){
                current=current.right;
            }else{
                current=current.left;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public void clear() {
        this.root=null;
        this.size=0;
    }
}
