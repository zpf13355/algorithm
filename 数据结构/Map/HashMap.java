package Map;



public class HashMap {
    HashNode[] array=new HashNode[11];
    int size;

    public boolean put(Integer key) {
        //hashCode()�ļ�������jvm���㵥�ײ���ͨ��c++����ʵ�ֵ�

        //1.�Ѷ���ת����int
        int hashValue=key.hashCode();
        //2.hashValת���ɺϷ��±�
        int index=hashValue%array.length;
        //3.������ϣ���ж�Ԫ���ڲ���
        HashNode current=array[index];
        while(current!=null){
            if(key.equals(current.key)){
                return false;
            }
            current=current.next;
        }
        //ͷ�巨�����ϣ��
        HashNode node=new HashNode(key);
        node.next=array[index];
        array[index]=node;

        size++;
        //����- ͨ��ά���������ӣ�����ά���ϵ͵ĳ�ͻ��
        if (size / array.length * 100 >= 75) {
            extendCapacity();
        }

        return true;


    }
    public boolean remove(Integer key){
        int hashValue=key.hashCode();
        int index=hashValue%array.length;

       HashNode current=array[index];
        HashNode currentPre=null;
        while(current!=null){
            if(key.equals(current.key)){
                if (currentPre==null){//˵��ɾ������ͷ���
                    array[index]=current.next;
                }else{//����ͷ���
                    currentPre.next=current.next;
                }
            }
            currentPre=current;
            current=current.next;
        }

        return false;
    }
    public boolean contains(Integer key){
        int hashValue=key.hashCode();
        int index=hashValue%array.length;

        HashNode current=array[index];
        while (current!=null){
            if (key.equals(current.key)){
                return true;
            }
            current=current.next;
        }
        return false;
    }
    public int get(Integer key){
        int hashValue=key.hashCode();
        int index=hashValue%array.length;

        HashNode current=array[index];
        while (current!=null){
            if (key.equals(current.key)){
                return current.key;
            }
            current=current.next;
        }
        return 0;
    }
    public void extendCapacity(){
        HashNode[] newArray=new HashNode[array.length*2];
        // ��ԭ����Ԫ�ع���
        // ����ֱ�Ӱ�������ˣ���ΪԪ�ر�����±�����鳤���й�
        // ���鳤�ȱ��ˣ��±�Ҳ���
        // ���ԣ���Ҫ��ÿ��Ԫ�����¼���һ��
        for(int i=0;i<array.length;i++){
            HashNode current=array[i];
            while(current!=null){
                int hashVal=current.key.hashCode();
                int index=hashVal%newArray.length;

               HashNode node=new HashNode(current.key);
                node.next=newArray[index];
                newArray[index]=node;

                current=current.next;
            }
        }
        array=newArray;
    }
}
