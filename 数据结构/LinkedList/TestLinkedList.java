package LinkedList;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkdedList linkdedList=new LinkdedList();
        linkdedList.add(1);
        linkdedList.add(2);
        linkdedList.add(3);
        linkdedList.add(9);
        System.out.println("LinkedList="+linkdedList.toString());
        System.out.println("size="+linkdedList.size());

        linkdedList.add(0,5);
        System.out.println("LinkedList="+linkdedList.toString());
        linkdedList.add(2,6);
        System.out.println("LinkedList="+linkdedList.toString());
        linkdedList.add(5,7);
        System.out.println("LinkedList="+linkdedList.toString());
        linkdedList.add(7,8);
        System.out.println("LinkedList="+linkdedList.toString());
        System.out.println("size="+linkdedList.size());

        linkdedList.remove(0);
        System.out.println("LinkedList="+linkdedList.toString());
        System.out.println("size="+linkdedList.size());

        linkdedList.remove(2);
        System.out.println("LinkedList="+linkdedList.toString());
        System.out.println("size="+linkdedList.size());
        linkdedList.remove(5);
        System.out.println("LinkedList="+linkdedList.toString());
        System.out.println("size="+linkdedList.size());
        linkdedList.remove(4);
        System.out.println("LinkedList="+linkdedList.toString());
        System.out.println("size="+linkdedList.size());

        /*linkdedList.remove((Integer) 1);
        System.out.println("LinkedList="+linkdedList.toString());
        System.out.println("size="+linkdedList.size());
        linkdedList.remove((Integer) 6);
        System.out.println("LinkedList="+linkdedList.toString());
        System.out.println("size="+linkdedList.size());
        linkdedList.remove((Integer) 7);
        System.out.println("LinkedList="+linkdedList.toString());
        System.out.println("size="+linkdedList.size());*/
        /*System.out.println(linkdedList.get(0));
        System.out.println(linkdedList.get(2));
        System.out.println(linkdedList.get(3));*/

        /*linkdedList.set(0,8);
        linkdedList.set(3,9);
        System.out.println("LinkedList="+linkdedList.toString());
        System.out.println("size="+linkdedList.size());*/
        //System.out.println(linkdedList.indexOf(8));
        //System.out.println(linkdedList.contains(8));
        /*linkdedList.clear();
        linkdedList.isEmpty();
        System.out.println("LinkedList="+linkdedList.toString());
        System.out.println("size="+linkdedList.size());
*/
        /*Iterator iterator=linkdedList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        Iterator iterator=linkdedList.iterator();
        while (iterator.hasNext()){
            Integer e=iterator.next();
                if(e.equals(3)){
                    System.out.println(e);
                    iterator.remove();
                    break;
                }
        }
        //iterator.remove();
        System.out.println("LinkedList="+linkdedList.toString());
    }
}
