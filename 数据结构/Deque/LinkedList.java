package Deque;

public class LinkedList implements Deque {
    Node head;
    Node tail;
    int size;

    @Override
    public boolean offerFirst(Integer e) {
        Node node=new Node(e);
        if(size==0){
            this.head=this.tail=node;
        }else{
            node.next=this.head;
            this.head.pre=node;
            this.head=node;
        }
        this.size++;
        return true;
    }

    @Override
    public Integer peekFirst() {
        if(size==0){
            return null;
        }
        return this.head.data;
    }

    @Override
    public Integer pollFirst() {
        if (size==0){
            return null;
        }
        Node cur=this.head;
        Integer e=this.head.data;
        this.head=cur.next;
        cur.next=null;
        this.head.pre=null;


        this.size--;
        return e;
    }

    @Override
    public boolean offerLast(Integer e) {
        Node node=new Node(e);
        if (size==0){
            this.head=this.tail=node;

        }else{
            node.pre=this.tail;
            this.tail.next=node;
            this.tail=node;

        }
        this.size++;
        return true;
    }

    @Override
    public Integer peekLast() {
        if (size==0){
            return null;
        }
        return this.tail.data;
    }

    @Override
    public Integer pollLast() {
        if (size==0){
            return null;
        }
        Node cur=this.tail;
        Integer e=this.tail.data;
        this.tail=cur.pre;
        this.tail.next=null;
        cur.pre=null;
        this.size--;
        return e;
    }

    @Override
    public int size() {
        return size;
    }
    public boolean isEmpty(){
        return size==0;
    }
}
