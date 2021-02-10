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
    * ��������
    *1. ѡ��һ������Ϊ��׼ֵ
    * 2.��С�ڻ�׼ֵ��������������ߣ����ڻ�׼ֵ�������������ұ�
    * 3.Ȼ���ڶ�������������������ͬ������
    * 4.ֱ������Ԫ������ʣ1��Ԫ�أ�
    * */
    private static void quickSort(int[] arr){
        quickSortInternal(arr,0,arr.length-1);

    }
    //[lowIndex,highIndex]����������
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
        //�������ѡ���׼ֵarr[lowIndex]
        //pivoteIndex�����׼ֵ����ͣ�����±�
        int pivoteIndex=partition1(arr,lowIndex,highIndex);
        quickSortInternal(arr,lowIndex,pivoteIndex-1);
        quickSortInternal(arr,pivoteIndex+1,highIndex);
    }
    //�ڿӷ�
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
    //Hoare��
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
