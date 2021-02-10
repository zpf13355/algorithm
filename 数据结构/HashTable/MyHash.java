package HashTable;


import java.util.*;

public class MyHash {
    public static void main(String[] args) {
        Person p1 = new Person("gb", 18);
        Person p2 = new Person("gb", 18);

        Set<Person> set = new HashSet<>();
        set.add(p1);
        //必须重写hashCode和equals才返回true
        System.out.println(set.contains(p2));

        Map<Person, String> map = new HashMap<>();
        map.put(p1, "gb");
        //必须重写hashCode和equals才有值否则返回null
        System.out.println(map.get(p2));
    }
}
class Person{
    String name;
    int age;
    public Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
