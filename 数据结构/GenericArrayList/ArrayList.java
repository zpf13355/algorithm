package GenericArrayList;



import java.util.Arrays;

public class ArrayList<E> implements List<E>{
    E[] array;
    int size;

    public ArrayList() {
        //无法直接泛型数组，所以先Object后强转
        this.array = (E[])new Object[10];
        this.size = 0;
    }

    @Override
    public boolean add(E e) {
        array[size++]=e;
        return true;
    }

    @Override
    public void add(int index, E e) {

    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public boolean remove(E e) {
        return false;
    }

    @Override
    public E get(int index) {
        return null;
    }

    @Override
    public E set(int index, E e) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {
        // 如果是基本类型，数组中的元素是否要清理成无效值其实无所谓
        // 但如果是引用类型，必须把数组中的元素修改成 null
        // 这样才不会内存泄漏
        Arrays.fill(array,null);
        size=0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(E e) {
        return false;
    }

    @Override
    public int indexOf(E e) {
        for (int i=0;i<size;i++){
            if(e==null){
                if (array[i]==e){
                    return i;
                }
            }else{
                //引用类型比较都要equals方法
                if (e.equals(array[i])){
                    return i;
                }
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        return 0;
    }

    @Override
    public Iterator<E> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        Object[] newArr=new Object[size];
        for (int i=0;i<size;i++){
            newArr[i]=array[i];
        }
        return newArr;
    }

    @Override
    public <E> E[] toArray(E[] a) {
        if(a.length<size){
            //创建一个新的数组存储返回
            E[] newArr=(E[])new Object[size];
            for (int i=0;i<size;i++){
                newArr[i]=(E)array[i];//不知为何要E强转
            }
            return newArr;
        }else if (a.length==size){
            for (int i=0;i<size;i++){
                a[i]=(E)array[i];
            }
            return a;
        }else{
            for (int i=0;i<size;i++){
                a[i]=(E)array[i];
            }
            a[size]=null;
            return a;
        }
    }
}
