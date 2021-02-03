package LinkedList;

public interface List extends Iterable{
    //尾插法
    boolean add(Integer e);
    //指定位置插入
    void add(int index, Integer e);
    // 根据下标删除
    Integer remove(int index);
    // 删除第一个遇到的值
    boolean remove(Integer e);
    //根据下标获取值
    Integer get(int index);
    //根据下标修改值
    Integer set(int index, Integer e);
    //大小
    int size();
    //清空
    void clear();
    //判断是否为空
    boolean isEmpty();
    //判断是否包含
    boolean contains(Integer e);
    //查找指定元素的第一次出现索引
    int indexOf(Integer e);
    //查找指定元素最后一次出现的索引
    int lastIndexOf(Integer e);
}

