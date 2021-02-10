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
        //���ϵ���
        upUpdate(arr,size,size-1);
    }
    //���ϵ���
    public static void upUpdate(Integer[] arr,int size,int index){
        while(true){
            //1.�ж�index�ǲ������� �Ǿ��ǽ���
            if (index==0){
                return;
            }
            //2.�ҵ�index�ĸ��ڵ�
            int parentIndex=(index-1)/2;
            //3.���ڵ��index�Ƚ� ���ڵ��ֵС��index��ֵ
            if (arr[parentIndex]<=arr[index]){
                return;
            }
            //4.�����ڵ�
            int temp=arr[parentIndex];
            arr[parentIndex]=arr[index];
            arr[index]=temp;

            //4.ѭ�����ϵ���
            index=parentIndex;

        }
    }
    public Integer remove(){
        if(size==0){
            throw new RuntimeException("����");
        }
        int e=arr[0];
        arr[0]=arr[size-1];
        //���µ���
        downUpdate(arr,size,0);
        return e;
    }
    //���µ���
    public static void downUpdate(Integer[] arr,int size,int index){
        while(true){
            //1. �ж��ǲ���Ҷ�ӽڵ�
            int leftIndex=2*index+1;
            if(leftIndex>=size){
                return;
            }
            int rightIndex=leftIndex+1;
            int minIndex=leftIndex;
            if(rightIndex<size&&arr[leftIndex]>arr[rightIndex]){
                minIndex=rightIndex;
            }
            //4.�Ƚ�С���Ӻ�index
            if(arr[index]<=arr[minIndex]){
                return;
            }
            //5.����
            int temp=arr[index];
            arr[index]=arr[minIndex];
            arr[minIndex]=temp;

            //6.�������µ���
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
