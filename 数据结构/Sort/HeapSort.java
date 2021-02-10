package Sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,2,4,6,8,10};
        System.out.println(Arrays.toString(arr));
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    private static void heapSort(int[] arr){
        //�����-���µ���
        createHeap(arr,arr.length);
        //ѡ��-���µ���
        for (int i=0;i<arr.length-1;i++){
            //�����Ѷ��Ͷѵ�
            int t=arr[0];
            arr[0]=arr[arr.length-1-i];
            arr[arr.length-1-i]=t;
            //���µ���
            downUpdate(arr,arr.length-1-i,0);
        }
    }
    //�����
    private static void createHeap(int[] arr,int size){
        //�ҵ����һ���ڵ������
        int lastIndex=size-1;
        //���һ���ڵ�ĸ��ڵ�
        int lastParentIndex=(lastIndex-1)/2;
        //�������µ���
        for (int i=lastParentIndex;i>=0;i--){
            //���µ���
            downUpdate(arr,arr.length,i);
        }
    }
    //���µ���-˵�������ڵ�����ѵ�����
    private static void downUpdate(int[] arr,int size,int index){
        //�����������ǲ�������Ľ��
        while(true){
            //�ж��ǲ���Ҷ�ӽڵ�
            int leftChildIndex=2*index+1;
            if (leftChildIndex>=size){//ֻҪ����Խ���Һ��ӱض�Խ��
                return;
            }
            //���������ӵ����ֵ
            int rightChildIndex=leftChildIndex+1;
            int maxIndex=leftChildIndex;
            if (rightChildIndex<size&&arr[leftChildIndex]<arr[rightChildIndex]){
                maxIndex=rightChildIndex;
            }
            //����Ӻ͸��ڵ�Ƚ�
            if (arr[maxIndex]<arr[index]){
                return;
            }
            //����
            int t=arr[index];
            arr[index]=arr[maxIndex];
            arr[maxIndex]=t;

            index=maxIndex;
        }
    }
}
