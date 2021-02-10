package Deque;

import java.util.NoSuchElementException;

public interface Queue {
    // ����
    // true �ɹ�  false ʧ�ܣ������������ˣ�
    boolean offer(Integer e);

    // ������Ԫ�أ�����ɾ��
    // ���� null�����������ǿյ�
    Integer peek();

    // ���ز�ɾ������Ԫ��
    // ���� null�����������ǿյ�
    Integer poll();

    // ���鷽��ͨ���׳��쳣��֪ͨ����

    // ����
    // Ĭ����Զ���� true
    default boolean add(Integer e) {
        if (offer(e) == false) {
            throw new IllegalStateException();
        }

        return true;
    }

    // ������Ԫ�أ�����ɾ��
    default Integer element() {
        Integer e = peek();
        if (e == null) {
            throw new NoSuchElementException();
        }

        return e;
    }

    // ���ز�ɾ������Ԫ��
    default Integer remove() {
        Integer e = poll();
        if (e == null) {
            throw new NoSuchElementException();
        }

        return e;
    }
}
