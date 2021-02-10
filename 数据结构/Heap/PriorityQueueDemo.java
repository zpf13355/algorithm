package Heap;


import java.util.PriorityQueue;

public class PriorityQueueDemo {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        //向下调整建堆
        queue.add(3);
        queue.add(5);
        queue.add(2);
        queue.add(7);
        //删除时不是直接删除堆顶元素，用最后一个节点在向下调整
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());
        System.out.println(queue.remove());

    }
}
