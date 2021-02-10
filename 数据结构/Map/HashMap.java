package Map;



public class HashMap {
    HashNode[] array=new HashNode[11];
    int size;

    public boolean put(Integer key) {
        //hashCode()的计算是由jvm计算单底层是通过c++代码实现的

        //1.把对象转换成int
        int hashValue=key.hashCode();
        //2.hashVal转化成合法下标
        int index=hashValue%array.length;
        //3.遍历哈希表判断元素在不在
        HashNode current=array[index];
        while(current!=null){
            if(key.equals(current.key)){
                return false;
            }
            current=current.next;
        }
        //头插法插入哈希表
        HashNode node=new HashNode(key);
        node.next=array[index];
        array[index]=node;

        size++;
        //扩容- 通过维护负载因子，进而维护较低的冲突率
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
                if (currentPre==null){//说明删除的是头结点
                    array[index]=current.next;
                }else{//不是头结点
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
        // 搬原来的元素过来
        // 不能直接按链表搬运，因为元素保存的下标和数组长度有关
        // 数组长度变了，下标也会变
        // 所以，需要把每个元素重新计算一次
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
