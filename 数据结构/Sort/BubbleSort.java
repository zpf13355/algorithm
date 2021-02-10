package Sort;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,2,4,6,8,10};
        System.out.println(Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
    * 分为无序和有序两个区间
    * 在无序区间，通过相邻数的比较，将最大的数冒泡到无序区间的最后，
    * 持续这个过程，直到数组整体有序
    *
    *时间复杂度
    *最好: O(n) 有序
    *最坏: O(n^2) 逆序
    *平均: O(n^2)
    *空间复杂度
    *最好/平均/最坏：O(1)
    *具备稳定性
    * */
    private static void bubbleSort(int[] arr){
        //冒泡趟数
        for(int i=0;i<arr.length-1;i++){
            /*
            *无序区间：[0,arr.length-i)
            *有序区间：[arr.length-i,arr.length)
            *
            * */

            //isSorted用于判断数组是否已经有序
            boolean isSorted=true;
            //无序区间的比较交换
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                    isSorted=false;
                }
            }
            //一趟冒泡之后如果未发生交换说明就是有序的，直接退出
            if (isSorted){
                break;
            }
        }
    }
}
