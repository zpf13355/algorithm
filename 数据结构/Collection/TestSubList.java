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
        List<Integer> sublist=list.subList(0,3);//����ҿ�
        System.out.println(list);//��Ӱ��ԭ����
        System.out.println(sublist);
    }
}
