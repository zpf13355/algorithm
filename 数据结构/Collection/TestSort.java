package Collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class TestSort {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>() ;

        list.add(1);
        list.add(4);
        list.add(3);
        list.add(5);
        list.add(2);
        System.out.println(list);//[1, 4, 3, 5, 2]
        //升序排列
        list.sort(new Comparator<Integer>() {
                      @Override
                      public int compare(Integer o1, Integer o2) {
                          return o1-o2;
                      }
                  }

        );
        System.out.println(list);//[1, 2, 3, 4, 5]

        //降序排列
        list.sort(new Comparator<Integer>() {
                      @Override
                      public int compare(Integer o1, Integer o2) {
                          return o2-o1;
                      }
                  }

        );
        System.out.println(list);//[5, 4, 3, 2, 1]

        //不变化
        list.sort(new Comparator<Integer>() {
                      @Override
                      public int compare(Integer o1, Integer o2) {
                          return 0;
                      }
                  }

        );
        System.out.println(list);//[5, 4, 3, 2, 1]

    }
}

