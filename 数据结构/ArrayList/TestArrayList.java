package ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        /*
        List myArrayList=new ArrayList(); 正确
         ArrayList myArrayList=new ArrayList(); 正确
         List myArrayList=new List(); 错误：接口不能实例化
         */
        List myArrayList=new ArrayList();
        myArrayList.add(1);
        myArrayList.add(2);
        myArrayList.add(3);
        myArrayList.add(4);
        myArrayList.add(5);
        System.out.println("list="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());

        myArrayList.add(1,6);
        System.out.println("list="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());

        myArrayList.remove(4);
        System.out.println("list="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());

        //默认作为下标使用下标要装箱方可删除
        //myArrayList.remove(Integer.valueOf(6));可用
        /*
        myArrayList.remove(new Integer(6));
        不可用，虽构造对象但赋给的值是int
        还有疑惑可查Integer底层构造方法
        */
        myArrayList.remove((Integer)6);
        System.out.println("list="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());

        myArrayList.remove(3);
        System.out.println("list="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());

        System.out.println(myArrayList.get(0));

        System.out.println(myArrayList.set(2, 4));
        System.out.println("list="+myArrayList.toString());

        System.out.println(myArrayList.contains(1));

        System.out.println(myArrayList.indexOf(1));

        System.out.println(myArrayList.lastIndexOf(2));

        myArrayList.clear();
        System.out.println(myArrayList.isEmpty());
        System.out.println("list="+myArrayList.toString());

        //测试扩容
        for (int i=0;i<10;i++){
            myArrayList.add(i+1);
        }
        System.out.println("list="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());
        myArrayList.add(11);
        System.out.println("list="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());

        //构造拷贝
        List myArrayList2=new ArrayList(myArrayList);
        System.out.println("myArrayList="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());
        System.out.println("myArrayList2="+myArrayList2.toString());
        System.out.println("size="+myArrayList2.size());

        //以下说明上述构造方法只是发生了深拷贝-修改一个数组不会另一个数组
        List myArrayList3 = myArrayList;
        myArrayList3.set(0, 1000);
        System.out.println("myArrayList " + myArrayList);
        System.out.println("myArrayList2 = " + myArrayList2);
        System.out.println("myArrayList3 = " + myArrayList3);

        //迭代器
        Iterator iterator=myArrayList.iterator();
        /*while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        while (iterator.hasNext()){
            Integer x=iterator.next();
            if ((int)x==2){//如果是引用型你就的自己重写equals方法否则无效
                //迭代遍历链表的时候要用迭代器删除
                iterator.remove();
                break;
            }
        }
        iterator.remove();
        System.out.println("myArrayList="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());

    }


}
