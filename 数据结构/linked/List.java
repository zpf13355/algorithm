package linked;

// 仿写真实的(java.util.List)List接口
// int 用在下标
// Integer 表示元素
public interface List  {
    boolean add(Integer e);
    void add(int index, Integer e);

    // 根据下标删除
    Integer remove(int index);
   /* // 删除第一个遇到的
    boolean remove(Integer e);

    Integer get(int index);
    Integer set(int index, Integer e);

    int size();
    void clear();
    boolean isEmpty();

    boolean contains(Integer e);
    int indexOf(Integer e);
    int lastIndexOf(Integer e);*/
}
