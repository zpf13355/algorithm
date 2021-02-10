package GenericArrayList;

public interface List<E> extends Iterable<E> {
    //β�巨
    boolean add(E e);
    //ָ��λ�ò���
    void add(int index, E e);
    // �����±�ɾ��
    E remove(int index);
    // ɾ����һ��������ֵ
    boolean remove(E e);
    //�����±��ȡֵ
    E get(int index);
    //�����±��޸�ֵ
    E set(int index, E e);
    //��С
    int size();
    //���
    void clear();
    //�ж��Ƿ�Ϊ��
    boolean isEmpty();
    //�ж��Ƿ����
    boolean contains(E e);
    //����ָ��Ԫ�صĵ�һ�γ�������
    int indexOf(E e);
    //����ָ��Ԫ�����һ�γ��ֵ�����
    int lastIndexOf(E e);
    Object[] toArray();
    <E> E[] toArray(E[] a);
}

