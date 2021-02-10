package Collection;

import java.util.*;

public class TestyIterator {
    public static void main(String[] args) {
        List<String> list=new ArrayList<>() ;

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("E");

/*
        Object[] objects =list.toArray();
        for (Object o : objects) {
            String s = (String)o;
            System.out.println(s);
        }*/

        /*String[] strings=(String[]) list.toArray();
        for (String s:strings){

        }*/


        /*String[] sArray = new String[1];
        sArray[0] = "hello";
        String[] strings = list.toArray(sArray);
        System.out.println(Arrays.toString(strings));//[A, B, C, D, E]
        System.out.println(Arrays.toString(sArray));//[hello]*/


        /*String[] sArray = new String[5];
        String[] strings = list.toArray(sArray);
        // ��ӡ���飬��Ҫʹ�� Arrays.toString
        System.out.println(Arrays.toString(strings));//[A, B, C, D, E]
        System.out.println(Arrays.toString(sArray));//[A, B, C, D, E]
        // sArray �� strings ָ��ͬһ������
        System.out.println(sArray == strings);//true*/


        String[] sArray = { "1", "2", "3", "4", "5", "6", "7", "8" };
        String[] strings = list.toArray(sArray);
        list.toArray(sArray);
        System.out.println(strings == sArray);  // ���� true
        System.out.println(Arrays.toString(strings));//[A, B, C, D, E, null, 7, 8]
        System.out.println(Arrays.toString(sArray));//[A, B, C, D, E, null, 7, 8]

        /*ListIterator<String> listIterator=list.listIterator();
        //�������
        while (listIterator.hasNext()){
            String x=listIterator.next();
            System.out.println(x);//1 2 3 4 5
        }
        System.out.println(list);//[1, 2, 3, 4, 5]
        //�������
        while (listIterator.hasPrevious()){
            String x=listIterator.previous();
            System.out.println(x);//5 4 3 2 1

        }
        System.out.println(list);//[1, 2, 3, 4, 5]*/

        /*Iterator<String> iterator=list.iterator();
        while (iterator.hasNext()){
            String x=iterator.next();
            if (x.equals("2")){
                //�������������ʱ��Ҫ�õ�����ɾ��
                iterator.remove();//
            }
        }
        System.out.println(list);//[1, 3, 4, 5]*/

        /*Iterator<String> iterator=list.iterator();

        while (iterator.hasNext()){
            String x=iterator.next();
            if (x.equals("2")){
                //�������������ʱ��Ҫ�õ�����ɾ��
                list.remove(x);//
            }
        }


        for (String next:list){
            if (next.equals("2")){
                //�������������ʱ��Ҫ�õ�����ɾ��
                list.remove(next);//
            }
        }



        System.out.println(list);//[1, 3, 4, 5]*/
        /*Iterator<Integer> iterator1=list.iterator();
        Iterator<Integer> iterator2=list.iterator();

        iterator1.next();
        iterator2.next();

        System.out.println(iterator1.next());//2
        System.out.println(iterator2.next());//2*/

/*
        Iterator<Integer> iterator=list.iterator();

        while (iterator.hasNext()){
            int x=iterator.next();
            System.out.println(x);
        }*/


    }
}
