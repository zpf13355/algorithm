package LinkedList;

public interface List extends Iterable{
    //β�巨
    boolean add(Integer e);
    //ָ��λ�ò���
    void add(int index, Integer e);
    // �����±�ɾ��
    Integer remove(int index);
    // ɾ����һ��������ֵ
    boolean remove(Integer e);
    //�����±��ȡֵ
    Integer get(int index);
    //�����±��޸�ֵ
    Integer set(int index, Integer e);
    //��С
    int size();
    //���
    void clear();
    //�ж��Ƿ�Ϊ��
    boolean isEmpty();
    //�ж��Ƿ����
    boolean contains(Integer e);
    //����ָ��Ԫ�صĵ�һ�γ�������
    int indexOf(Integer e);
    //����ָ��Ԫ�����һ�γ��ֵ�����
    int lastIndexOf(Integer e);
}

