package Collection;

import java.util.ArrayList;
import java.util.List;

public class TestList {
    public static void main(String[] args) {
        /*List<Integer> list=new ArrayList<>() ;
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        System.out.println(list);//[1, 2, 3, 4, 5]
        list.remove(1);//索引有限于元素
        System.out.println(list);//[1, 3, 4, 5]
        list.remove((Integer)1);//装箱为对象
        //list.remove(Integer.valueOf(1))
        System.out.println(list);//[1, 3, 4, 5]*/





        /*list.add(0,6);
        System.out.println(list);//[6, 1, 2, 3, 4, 5]
        list.add(2,7);
        System.out.println(list);//[6, 1, 7, 2, 3, 4, 5]
        list.add(7,8);//注意：这是list尾元素的后面插，不会越界
        System.out.println(list);//[6, 1, 7, 2, 3, 4, 5, 8]*/





        Person p1=new Person(1,"张三");
        Person p2=new Person(1,"张三");
        Person p3=new Person(2,"王五");

        List<Person> list=new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        System.out.println(list);//[Person{id=1, name='张三'}, Person{id=1, name='张三'}, Person{id=2, name='王五'}]
        System.out.println(list.remove(p1));
        System.out.println(list);//[Person{id=1, name='张三'}, Person{id=2, name='王五'}]
        System.out.println(list.remove(new Person(1, "张三")));
        System.out.println(list);//[Person{id=1, name='张三'}, Person{id=2, name='王五'}]
        /*System.out.println(list.contains(p1));
        System.out.println(list.contains(p2));
        System.out.println(list.contains(p3));
        System.out.println(list.indexOf(p2));*/
    }
}
class Person{
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
