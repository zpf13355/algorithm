package GenericArrayList;

public interface List<E> extends Iterable<E> {
    //尾插法
    boolean add(E e);
    //指定位置插入
    void add(int index, E e);
    // 根据下标删除
    E remove(int index);
    // 删除第一个遇到的值
    boolean remove(E e);
    //根据下标获取值
    E get(int index);
    //根据下标修改值
    E set(int index, E e);
    //大小
    int size();
    //清空
    void clear();
    //判断是否为空
    boolean isEmpty();
    //判断是否包含
    boolean contains(E e);
    //查找指定元素的第一次出现索引
    int indexOf(E e);
    //查找指定元素最后一次出现的索引
    int lastIndexOf(E e);
    Object[] toArray();
    <E> E[] toArray(E[] a);
}

