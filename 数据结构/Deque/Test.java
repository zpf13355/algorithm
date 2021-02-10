package Deque;

public class Test {
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        linkedList.offerFirst(1);
        linkedList.offerFirst(2);
        linkedList.offerFirst(3);
        linkedList.offerFirst(4);
        linkedList.offerFirst(5);

        System.out.println(linkedList.peekFirst());
        System.out.println(linkedList.pollFirst());
        System.out.println(linkedList.peekFirst());

        linkedList.offerLast(6);
        System.out.println(linkedList.peekLast());
        System.out.println(linkedList.pollLast());
        System.out.println(linkedList.peekLast());
    }
}
