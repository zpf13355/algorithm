package LinkedList;

public class LinkdedList implements List{
    Node head;
    Node tail;
    int size;

    public LinkdedList() {
        this.size = 0;
    }

    @Override
    public boolean add(Integer e) {
        Node node=new Node(e);
        if (size==0){
            this.head=this.tail=node;
        }else{
            this.tail.next=node;
            node.pre=this.tail;
            this.tail=node;
        }
        this.size++;
        return true;

    }

    @Override

    public void add(int index, Integer e) {
        if (index<0||index>size){
            throw  new IndexOutOfBoundsException("下标不和法："+index);
        }


        if(index==size){
            //尾插法
            add(e);

        }else if (index==0){
            //头插法
            Node node=new Node(e);
            node.next=this.head;
            this.head.pre=node;
            this.head=node;
            //return;//不结束会多执行一次size++
            this.size++;
        }else{
            //中间插-优化左半区间从前往后找 有半区间从后向前找
            Node preNode;
            if (index-1<size/2){
                //左区间
                preNode=this.head;
                for (int i=0;i<index-1;i++){
                    preNode=preNode.next;
                }

            }else{
                //右区间
                preNode=this.tail;
                for (int i=0;i<size-index;i++){
                    preNode=preNode.pre;
                }
            }
            Node preNext=preNode.next;//切记要标识不动点否则很容易出错
            Node node=new Node(e);
            node.next=preNext;
            node.pre=preNode;
            preNode.next=node;
            preNext.pre=node;
            this.size++;
        }
    }
    @Override
    public Integer remove(int index) {
        if (index<0||index>=size){
            throw  new IndexOutOfBoundsException("下标不和法："+index);
        }
        Node delete;
        if (index==0){
            delete=this.head;
           this.head=this.head.next;
           this.head.pre=null;
            //删完表变空了要释放内存防止内存泄露
           if(this.size==0){
               this.tail=null;
           }

        }else if(index==size-1){
            delete=this.tail;
            this.tail=this.tail.pre;
            this.tail.next=null;
            //删完表变空了要释放内存防止内存泄露
            if(size==0){
                this.head=null;
            }
        }else{
            //中间插-优化左半区间从前往后找 有半区间从后向前找
            Node preNode;
            if (index<size/2){
                //左区间
                preNode=this.head;
                for (int i=0;i<index-1;i++){
                    preNode=preNode.next;
                }

            }else{
                //右区间
                preNode=this.tail;
                for (int i=0;i<size-index;i++){
                    preNode=preNode.pre;
                }
            }
            delete=preNode.next;
            preNode.next=preNode.next.next;
            preNode.next.pre=preNode;
        }
        this.size--;
        return delete.data;
    }



    @Override
    public boolean remove(Integer e) {
        if (this.head.data.equals(e)){
            remove(0);
            return true;
        }else if (this.tail.data.equals(e)){
            remove(size-1);
            return true;
        }else{
            Node preNode=this.head;
            while (preNode.next!=null){
                if (preNode.next.data.equals(e)){
                    preNode.next=preNode.next.next;
                    preNode.next.pre=preNode;
                    this.size--;
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public Integer get(int index) {
        if (index<0||index>size){
            throw  new IndexOutOfBoundsException("下标不和法："+index);
        }
        Node cur=this.head;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        return cur.data;
    }

    @Override
    public Integer set(int index, Integer e) {
        if (index<0||index>size){
            throw  new IndexOutOfBoundsException("下标不和法："+index);
        }
        Node cur=this.head;
        for (int i=0;i<index;i++){
            cur=cur.next;
        }
        cur.data=e;
        return cur.data;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    @Override
    public boolean isEmpty() {
        return this.size==0;
    }

    @Override
    public boolean contains(Integer e) {
        return indexOf(e)!=-1;
    }

    @Override
    public int indexOf(Integer e) {
        int index=0;
        Node cur=this.head;
        while (cur!=null){
            if (cur.data.equals(e)){
                return index;
            }
            cur=cur.next;
            index++;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        int index=this.size-1;

        Node cur=this.tail;
        while (cur!=null){
            if (cur.data.equals(e)){
                return index;
            }
            cur=cur.pre;
            index--;
        }
        return -1;
    }

    @Override
    public Iterator iterator() {
        return new LinkedlistIterator(this);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.data);
            if (cur != tail) {
                sb.append(", ");
            }
       }
        sb.append("]");
        return sb.toString();
    }
}
