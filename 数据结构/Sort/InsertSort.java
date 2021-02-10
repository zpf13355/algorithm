package Sort;

import java.util.Arrays;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,2,4,6,8,10};
        System.out.println(Arrays.toString(arr));
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
    *
    * 插入排序:每次选择无序区间的第一个元素，在有序区间找到合适的位置插入
    *时间复杂度
    *最好： O(n)       有序
    *最坏： O(n^2)     逆序
    *平均： O(n^2)
    *空间复杂度
    *最好/最坏/平均：   O(1)
    *具备稳定性
    */
    private static void insertSort(int[] arr){
        /*
        * 有序：[0,i]
        * 无序：[i,arr.length)
        * */

        for (int i=0;i<arr.length-1;i++){//默认
                int key=arr[i+1];//无序区间的第一个元素
                int j=0;
                for (j=i;j>=0;j--) {//无序区间寻找合适位置
                    if (arr[j] > key) {
                        arr[j+1]=arr[j];
                    }else{
                        break;
                    }
                }
                arr[j+1]=key;
        }
    }
}
