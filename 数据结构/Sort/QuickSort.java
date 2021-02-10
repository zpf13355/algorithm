package Sort;

import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,2,4,6,8,10};
        System.out.println(Arrays.toString(arr));
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
    * 快速排序
    *1. 选择一个数作为基准值
    * 2.将小于基准值的数放在它的左边，大于基准值的数放在它的右边
    * 3.然后在对左右两个区间左如上同样处理
    * 4.直到区间元素有序（剩1个元素）
    * */
    private static void quickSort(int[] arr){
        quickSortInternal(arr,0,arr.length-1);

    }
    //[lowIndex,highIndex]待排序区间
    private static void quickSortInternal(int[] arr, int lowIndex, int highIndex){
        if(lowIndex==highIndex){
            return;
        }
        if(lowIndex>highIndex){
            return;
        }
        /*
        * int size=highIndex-lowindex+!
        * if(size<=1){
        *   return;
        * }
        * */
        //方便起见选择基准值arr[lowIndex]
        //pivoteIndex代表基准值最终停留的下标
        int pivoteIndex=partition1(arr,lowIndex,highIndex);
        quickSortInternal(arr,lowIndex,pivoteIndex-1);
        quickSortInternal(arr,pivoteIndex+1,highIndex);
    }
    //挖坑法
    private static int partition(int[] arr, int left, int right) {
        int key=arr[left];
        while (left<right){
            while(left<right&&arr[right]>key){
                right--;
            }
            arr[left]=arr[right];
            while (left<right&&arr[left]<key){
                left++;
            }
            arr[right]=arr[left];

        }
        arr[left]=key;
        return left;

    }
    //Hoare法
    private static int partition1(int[] arr, int left, int right){
        int lowIndex=left;
        int highIndex=right;
        int key=arr[left];
        while(lowIndex<highIndex){
            while (lowIndex<highIndex&&arr[highIndex]>=key){
                highIndex--;
            }
            while (lowIndex<highIndex&&arr[lowIndex]<=key){
                lowIndex++;
            }
            swap(arr,lowIndex,highIndex);
        }
        swap(arr,left,lowIndex);
        return lowIndex;
    }
    private static void swap(int[] arr,int leftIndex,int rightIndex){
        int t=arr[leftIndex];
        arr[leftIndex]=arr[rightIndex];
        arr[rightIndex]=t;
    }
}
