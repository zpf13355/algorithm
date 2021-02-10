package Collection;

import java.util.ArrayList;
import java.util.List;

public class TestSubList {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>() ;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(list);
        List<Integer> sublist=list.subList(0,3);//左闭右开
        System.out.println(list);//不影响原数组
        System.out.println(sublist);
    }
}
