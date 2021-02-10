package Heap;

public class MyPriorityQueue {
    Integer[] arr;
    int size;
    public MyPriorityQueue(){
        arr=new Integer[100];
        size=0;
    }
    public void add(Integer e){
        arr[size]=e;
        size++;
        //向上调整
        upUpdate(arr,size,size-1);
    }
    //向上调整
    public static void upUpdate(Integer[] arr,int size,int index){
        while(true){
            //1.判断index是不是树根 是就是结束
            if (index==0){
                return;
            }
            //2.找到index的父节点
            int parentIndex=(index-1)/2;
            //3.父节点和index比较 父节点的值小于index的值
            if (arr[parentIndex]<=arr[index]){
                return;
            }
            //4.交换节点
            int temp=arr[parentIndex];
            arr[parentIndex]=arr[index];
            arr[index]=temp;

            //4.循环向上调整
            index=parentIndex;

        }
    }
    public Integer remove(){
        if(size==0){
            throw new RuntimeException("空了");
        }
        int e=arr[0];
        arr[0]=arr[size-1];
        //向下调整
        downUpdate(arr,size,0);
        return e;
    }
    //向下调整
    public static void downUpdate(Integer[] arr,int size,int index){
        while(true){
            //1. 判断是不是叶子节点
            int leftIndex=2*index+1;
            if(leftIndex>=size){
                return;
            }
            int rightIndex=leftIndex+1;
            int minIndex=leftIndex;
            if(rightIndex<size&&arr[leftIndex]>arr[rightIndex]){
                minIndex=rightIndex;
            }
            //4.比较小孩子和index
            if(arr[index]<=arr[minIndex]){
                return;
            }
            //5.交换
            int temp=arr[index];
            arr[index]=arr[minIndex];
            arr[minIndex]=temp;

            //6.继续向下调整
            index=minIndex;
        }
    }

    public static void main(String[] args) {
        MyPriorityQueue myPriorityQueue=new MyPriorityQueue();
        myPriorityQueue.add(3);
        myPriorityQueue.add(5);
        myPriorityQueue.add(2);
        myPriorityQueue.add(7);
        System.out.println(myPriorityQueue.remove());
        System.out.println(myPriorityQueue.remove());
        System.out.println(myPriorityQueue.remove());
        System.out.println(myPriorityQueue.remove());
    }
}
