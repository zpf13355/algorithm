package BST;

/*
* 二叉搜索树
* 1.二叉树 2.节点保存关键字
* 3，每个节点关键字key,左子树小所有关键字小于key,右子树所有关键字大于key
* 4.二叉搜索树不会有相等的key
* 5.具备比较能力
* 6.二叉搜索树的中序遍历一定是有序的
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
        //标识current的父节点
        TreeNode parentCurrent=null;
        //current寻找插入位置
        TreeNode current=this.root;
        int cmp=0;
        while (current!=null){
            cmp=key.compareTo(current.key);
            if (cmp==0){
                throw new RuntimeException("二叉搜索树不允许相同的key值");
            }else if (cmp<0){//往左插
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
    * 1.删除的是叶子节点
    * 2.删除的是有一个孩子的节点
    * 3.删除的是有两个孩子的节点（替换删除）
    *   选择作左子树中最大的或者右子树中最小的
    *
    * */
    public boolean remove(Integer key) {
        if(this.root==null){
            return false;
        }
        //查找
        TreeNode parent=null;
        TreeNode current=this.root;
        while (current!=null){
            int cmp=key.compareTo(current.key);
            if (cmp==0){
                //删除
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
        //删除的是叶子节点
        if(node.left==null&&node.right==null){
            if(this.root==node){//说明只有一个节点的树
                this.root=null;
            }else if (parent.left==node){ //删左孩子则去除
                parent.left=null;
            }else{//删有孩子则去除
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

                //找左子树中的最大值
            //从左孩子开始一直向右走到尽头
                TreeNode maxParent=node;
                TreeNode max=node.left;
                while (max.right!=null){
                    maxParent=max;
                    max=max.right;
                }

                //替换-特例
            if (maxParent==node){
                maxParent.left=max.right;
            }else{
                maxParent.right=max.left;
            }


        }
    }
}
