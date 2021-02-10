package Sort;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,2,4,6,8,10};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
    * 归并排序：
    * 归并排序（MERGE-SORT）是建立在归并操作上的一种有效的排序算法,该算法是采用分治法（Divide and
    *Conquer）的一个非常典型的应用。将已有序的子序列合并，得到完全有序的序列；
    * 即先使每个子序列有序，再使子序列段间有序。若将两个有序表合并成一个有序表，称为二路归并
    *
    * 时间复杂度：O(n*logn)
    * 空间复杂度：O(n)
    * 稳定性：稳定
    * */
    //递归版
    public static void mergeSort(int[] array) {
        mergeSortInternal(array, 0, array.length);
    }
    //array->[low,high)
    private static void mergeSortInternal(int[] array, int low, int high) {
        int size=high-low;
        if(size<=1){
            return;
        }
        int mid=(low+high)/2;
        /*
        * 左区间[low,,mid)
        * 右区间[mid,high)
        * */
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid,high);

        merge(array,low,mid,high);
    }

    //非递归
    public static void mergeSort1(int[] array) {
        for (int i = 1; i < array.length; i = i * 2) {
            for (int j = 0; j < array.length; j = j + 2 * i) {
                int low = j;
                int mid = j + i;
                if (mid >= array.length) {
                    continue;
                }

                int high = mid + i;
                if (high > array.length) {
                    high = array.length;
                }

                merge(array, low, mid, high);
            }
        }
    }
    private static void merge(int[] array, int low, int mid, int high) {
        int size=high-low;
        //额外数组
        int[] extraArray=new int[size];
        int extraIndex=0;
        //左区间的起始位置
        int leftIndex=low;
        //右区间的起始位置
        int rightIndex=mid;

        while(leftIndex<mid&&rightIndex<high){
            if(array[leftIndex]<array[rightIndex]){
                extraArray[extraIndex]=array[leftIndex];
                leftIndex++;
            }else{
                extraArray[extraIndex]=array[rightIndex];
                rightIndex++;
            }
            extraIndex++;
        }

        if (rightIndex<high){
            while (rightIndex<high){
                extraArray[extraIndex]=array[rightIndex];
                rightIndex++;
                extraIndex++;
            }
            if(leftIndex<mid){
                while(leftIndex<mid){
                    extraArray[extraIndex]=array[leftIndex];
                    leftIndex++;
                    extraIndex++;
                }
            }
            //额外数组还原
            /*
            * 新数组[]0,size)
            * 旧数组[low,high)
            */
            for (int i=0;i<size;i++){
                array[low+i]=extraArray[i];
            }
        }

    }

}
