package ArrayList;

public class ArrayListIterator implements Iterator{
    int index;
    ArrayList list;
    public ArrayListIterator(ArrayList list){
        this.list=list;
        index=0;
    }
    //�ж���һ�������Ƿ�Ϸ�
    @Override
    public boolean hasNext() {
        return index<list.size;
    }
    //���ص�ǰֵ
    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public void remove() {
        list.remove(index--);
    }
}
