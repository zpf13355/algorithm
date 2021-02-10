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
        //建大堆-向下调整
        createHeap(arr,arr.length);
        //选择-向下调整
        for (int i=0;i<arr.length-1;i++){
            //交换堆顶和堆底
            int t=arr[0];
            arr[0]=arr[arr.length-1-i];
            arr[arr.length-1-i]=t;
            //向下调整
            downUpdate(arr,arr.length-1-i,0);
        }
    }
    //建大堆
    private static void createHeap(int[] arr,int size){
        //找到最后一个节点的索引
        int lastIndex=size-1;
        //最后一个节点的父节点
        int lastParentIndex=(lastIndex-1)/2;
        //依次向下调整
        for (int i=lastParentIndex;i>=0;i--){
            //向下调整
            downUpdate(arr,arr.length,i);
        }
    }
    //向下调整-说明其他节点满足堆的条件
    private static void downUpdate(int[] arr,int size,int index){
        //给定的数组是层序遍历的结果
        while(true){
            //判断是不是叶子节点
            int leftChildIndex=2*index+1;
            if (leftChildIndex>=size){//只要左孩子越界右孩子必定越界
                return;
            }
            //找两个孩子的最大值
            int rightChildIndex=leftChildIndex+1;
            int maxIndex=leftChildIndex;
            if (rightChildIndex<size&&arr[leftChildIndex]<arr[rightChildIndex]){
                maxIndex=rightChildIndex;
            }
            //最大孩子和父节点比较
            if (arr[maxIndex]<arr[index]){
                return;
            }
            //交换
            int t=arr[index];
            arr[index]=arr[maxIndex];
            arr[maxIndex]=t;

            index=maxIndex;
        }
    }
}
