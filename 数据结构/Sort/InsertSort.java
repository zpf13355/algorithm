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
    * ��������:ÿ��ѡ����������ĵ�һ��Ԫ�أ������������ҵ����ʵ�λ�ò���
    *ʱ�临�Ӷ�
    *��ã� O(n)       ����
    *��� O(n^2)     ����
    *ƽ���� O(n^2)
    *�ռ临�Ӷ�
    *���/�/ƽ����   O(1)
    *�߱��ȶ���
    */
    private static void insertSort(int[] arr){
        /*
        * ����[0,i]
        * ����[i,arr.length)
        * */

        for (int i=0;i<arr.length-1;i++){//Ĭ��
                int key=arr[i+1];//��������ĵ�һ��Ԫ��
                int j=0;
                for (j=i;j>=0;j--) {//��������Ѱ�Һ���λ��
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
