package linked;

public class LinkedListTestCase {
    public static void main(String[] args) {
        List list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println("LinkedList="+list.toString());
        //-*+// tem.out.println("size="+list.size());

        list.add(0,5);
        list.add(2,6);
        list.add(5,7);
        list.add(7,8);
        System.out.println("LinkedList="+list.toString());
        //System.out.println("size="+list.size());
        list.remove(0);
        System.out.println("LinkedList="+list.toString());
        //System.out.println("size="+list.size());
        list.remove(2);
        System.out.println("LinkedList="+list.toString());
        //System.out.println("size="+list.size());
        list.remove(5);
        System.out.println("LinkedList="+list.toString());
        //System.out.println("size="+list.size());
        list.remove(4);
        System.out.println("LinkedList="+list.toString());
        //System.out.println("size="+list.size());

        /*list.add(0, 998);
        list.add(31);
        list.add(32);
        list.add(33);
        System.out.println(list);   // [998, 31, 32, 33]
        list.remove(3);
        System.out.println(list);
        list.remove(2);
        System.out.println(list);*/
        /*list.add(0, 1000);
        System.out.println(list);   // [1000, 998, 31, 32, 33]
        list.add(3, 28);
        System.out.println(list);   // [1000, 998, 31, 28, 32, 33]
        list.add(1, 98);
        System.out.println(list);   // [1000, 98, 998, 31, 28, 32, 33]
        list.add(7, 2000);
        System.out.println(list);   // [1000, 98, 998, 31, 28, 32, 33, 2000]

        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }*/
    }
}
