package Heap;


import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //���µ�������
        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(7);
        //ɾ��ʱ����ֱ��ɾ���Ѷ�Ԫ�أ������һ���ڵ������µ���
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }
}
