package LinkedList;

public class LinkedlistIterator implements Iterator{
    public LinkdedList linkdedList;
    public Node cur;
    int index;
    public LinkedlistIterator(LinkdedList linkdedList){
        this.linkdedList=linkdedList;
        this.cur=this.linkdedList.head;
        index=0;
    }
    @Override
    public boolean hasNext() {
        return cur!=null;
    }

    @Override
    public Integer next(){
        Integer e=cur.data;
        cur=cur.next;
        index++;
        return e;
    }



    @Override
    public void remove() {

        //this.linkdedList.remove(index--);
    }
}
