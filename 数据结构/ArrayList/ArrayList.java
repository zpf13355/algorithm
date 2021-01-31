package ArrayList;

public class ArrayList implements List{
    Integer[] array;
    int size;

    public ArrayList() {
        this.array = new Integer[10];
        this.size = 0;
    }
    public ArrayList(List other) {
        array = new Integer[other.size()];
        for (int i = 0; i < other.size(); i++) {
            array[i] = other.get(i);
        }
        size = other.size();
    }

    //扩容
    public void extendCapacity(int newCapacity){
        if(size<array.length){
            return;
        }
        //扩容
        /*
        库函数拷贝
        Arrays.copyOf()
        System.arraycopy()
        clone()
        for()
         */
        Integer[] newArray=new Integer[newCapacity];
        //拷贝旧数组到新数组
        for (int i=0;i<size;i++){
            newArray[i]=this.array[i];
        }
        this.array=newArray;
    }
    @Override
    public boolean add(Integer e) {
        if(size==array.length){
            extendCapacity(array.length*2);
        }

        array[size]=e;
        size++;
        return true;
    }

    @Override
    public void add(int index, Integer e) {
        if(size==array.length){
            extendCapacity(array.length*2);
        }
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("不合法的下标:"+index);
        }
        for(int i=size-1;i>=index;i--){
            array[i+1]=array[i];
        }
        array[index]=e;
        size++;
    }

    @Override
    public Integer remove(int index) {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("不合法的下标:"+index);
        }
        for (int i=index+1;i<size;i++){
            array[i-1]=array[i];
        }
        this.size--;
        return array[index];
    }

    @Override
    public boolean remove(Integer e) {
        int index= indexOf(e);
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("不合法的下标:"+index);
        }
        for (int i=index+1;i<size;i++){
            array[i-1]=array[i];
        }
        this.size--;
        return false;
    }

    @Override
    public Integer get(int index) {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("不合法的下标:"+index);
        }
        return array[index];
    }

    @Override
    public Integer set(int index, Integer e) {
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("不合法的下标:"+index);
        }
        array[index]=e;
        return array[index];
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        this.size=0;
    }

    @Override
    public boolean isEmpty() {

        /*if (this.size==0){
            return true;
        }
        return false;*/
        return this.size==0;
    }

    @Override
    public boolean contains(Integer e) {
        /*for (int i=0;i<this.size;i++){
            if(array[i]==e){
                return true;
            }
        }
        return false;*/
        return indexOf(e)!=-1;
    }

    @Override
    public int indexOf(Integer e) {
        for (int i=0;i<this.size;i++){
            if(array[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer e) {
        for (int i=this.size-1;i>=0;i--){
            if(array[i].equals(e)){
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        StringBuilder sb=new StringBuilder();
        sb.append("[");
        for(int i=0;i<size;i++){
            if(i!=size-1){
                sb.append(array[i]+",");
                continue;
            }
            sb.append(array[i]);
        }
        sb.append("]");

        return sb.toString();
    }

    @Override
    public Iterator iterator() {
        return new ArrayListIterator(this);
    }
}
