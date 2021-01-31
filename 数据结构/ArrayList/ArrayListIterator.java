package ArrayList;

public class ArrayListIterator implements Iterator{
    int index;
    ArrayList list;
    public ArrayListIterator(ArrayList list){
        this.list=list;
        index=0;
    }
    //判断下一个索引是否合法
    @Override
    public boolean hasNext() {
        return index<list.size;
    }
    //返回当前值
    @Override
    public Integer next() {
        return list.get(index++);
    }

    @Override
    public void remove() {
        list.remove(index--);
    }
}
