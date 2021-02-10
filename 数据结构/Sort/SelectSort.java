package Sort;

import java.util.Arrays;

public class SelectSort {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,2,4,6,8,10};
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
    * 选择排序：每一次从无序区间选出最大（或最小）的一个元素，
    * 存放在无序区间的最后（或最前），直到全部待排序的数据元素排完 。
    * 时间复杂度
    *最好: O(n^2)
    *最坏: O(n^2)
    *平均: O(n^2)
    *空间复杂度
    *最好/平均/最坏：O(1)
    *不具备稳定性
    * */
    private static void selectSort(int[] arr){
        /*
        * 无序：[0,arr.length-i)
        * 有序：[arr.length-i,arr.length)
        * */
        for(int i=0;i<arr.length-1;i++){
            int maxIndex=0;//假设最大值就是arr[0]
            for(int j=1;j<arr.length-i;j++){//找无序区间的最大值
                if (arr[maxIndex]<arr[j]){
                    maxIndex=j;
                }
            }
            //最大值和无序区间的最后元素交换
            int t=arr[maxIndex];
            arr[maxIndex]=arr[arr.length-i-1];
            arr[arr.length-i-1]=t;
        }
    }
}
