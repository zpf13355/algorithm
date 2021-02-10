package Deque;

import java.util.NoSuchElementException;

public interface Deque extends Queue{
    // ���鷽����ͨ�����ⷵ��ֵ�������
    boolean offerFirst(Integer e);
    Integer peekFirst();
    Integer pollFirst();
    boolean offerLast(Integer e);
    Integer peekLast();
    Integer pollLast();
    int size();

    // ���鷽����ͨ���쳣����
    default void addFirst(Integer e) {
        if (offerFirst(e) == false) {
            throw new IllegalStateException();
        }
    }

    default Integer getFirst() {
        Integer e = peekFirst();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    default Integer removeFirst() {
        Integer e = pollFirst();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    default void addLast(Integer e) {
        if (offerLast(e) == false) {
            throw new IllegalStateException();
        }
    }
    default Integer getLast() {
        Integer e = peekLast();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }
    default Integer removeLast() {
        Integer e = pollLast();
        if (e == null) {
            throw new NoSuchElementException();
        }
        return e;
    }

    // ���鷽�����̳��� Queue
// ����ֵ
    default boolean offer(Integer e) {
        return offerLast(e);
    }
    default Integer peek() {
        return peekFirst();
    }
    default Integer poll() {
        return pollFirst();
    }

    // �������鷽��Ϊջ����̬׼��������������� peek ����
    default void push(Integer e) {
        addFirst(e);
    }

    default Integer pop() {
        return removeFirst();
    }


}
