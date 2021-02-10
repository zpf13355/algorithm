package Sort;

import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,2,4,6,8,10};
        System.out.println(Arrays.toString(arr));
        shellSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
    * 希尔排序-插入排序的优化版
    * 希尔排序法又称缩小增量法。
    * 希尔排序法的基本思想是：先选定一个整数，把待排序文件中所有记录分成个组，
    * 所有距离为的记录分在同一组内，并对每一组内的记录进行排序。
    * 然后，取重复上述分组和排序的工作。当到达1时，所有记录在统一组内排好序。
    *
    * // 最坏：O(n^2)
    *最好：O(n)
    *平均：O(n^1.3)
    *空间复杂度：O(1)
    *不稳定
    * */
    private static void shellSort(int[] arr){
        //分组步长
        int gap=arr.length/2;
        while(true){
            insertSortGap(arr,gap);
            if(gap==1){
                break;
            }
            gap=gap/2;
        }
    }
    private static void insertSortGap(int[] arr,int gap){
        for (int i=gap;i<arr.length;i++){
            int key=arr[i];
            int j;
            for (j=i-gap;j>=0;j=j-gap){//就是插入排序的思想
                if (key<arr[j]){
                   arr[j+gap]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+gap]=key;
        }
    }
    /*private static void swap(int[] arr,int leftIndex,int rightIndex){
        int t=arr[leftIndex];
        arr[leftIndex]=arr[rightIndex];
        arr[rightIndex]=t;
    }*/
}
