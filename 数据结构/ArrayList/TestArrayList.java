package ArrayList;

public class TestArrayList {
    public static void main(String[] args) {
        /*
        List myArrayList=new ArrayList(); ��ȷ
         ArrayList myArrayList=new ArrayList(); ��ȷ
         List myArrayList=new List(); ���󣺽ӿڲ���ʵ����
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

        //Ĭ����Ϊ�±�ʹ���±�Ҫװ�䷽��ɾ��
        //myArrayList.remove(Integer.valueOf(6));����
        /*
        myArrayList.remove(new Integer(6));
        �����ã��乹����󵫸�����ֵ��int
        �����ɻ�ɲ�Integer�ײ㹹�췽��
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

        //��������
        for (int i=0;i<10;i++){
            myArrayList.add(i+1);
        }
        System.out.println("list="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());
        myArrayList.add(11);
        System.out.println("list="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());

        //���쿽��
        List myArrayList2=new ArrayList(myArrayList);
        System.out.println("myArrayList="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());
        System.out.println("myArrayList2="+myArrayList2.toString());
        System.out.println("size="+myArrayList2.size());

        //����˵���������췽��ֻ�Ƿ��������-�޸�һ�����鲻����һ������
        List myArrayList3 = myArrayList;
        myArrayList3.set(0, 1000);
        System.out.println("myArrayList " + myArrayList);
        System.out.println("myArrayList2 = " + myArrayList2);
        System.out.println("myArrayList3 = " + myArrayList3);

        //������
        Iterator iterator=myArrayList.iterator();
        /*while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
        while (iterator.hasNext()){
            Integer x=iterator.next();
            if ((int)x==2){//�������������͵��Լ���дequals����������Ч
                //�������������ʱ��Ҫ�õ�����ɾ��
                iterator.remove();
                break;
            }
        }
        iterator.remove();
        System.out.println("myArrayList="+myArrayList.toString());
        System.out.println("size="+myArrayList.size());

    }


}
