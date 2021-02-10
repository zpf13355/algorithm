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
    * ѡ������ÿһ�δ���������ѡ����󣨻���С����һ��Ԫ�أ�
    * ����������������󣨻���ǰ����ֱ��ȫ�������������Ԫ������ ��
    * ʱ�临�Ӷ�
    *���: O(n^2)
    *�: O(n^2)
    *ƽ��: O(n^2)
    *�ռ临�Ӷ�
    *���/ƽ��/���O(1)
    *���߱��ȶ���
    * */
    private static void selectSort(int[] arr){
        /*
        * ����[0,arr.length-i)
        * ����[arr.length-i,arr.length)
        * */
        for(int i=0;i<arr.length-1;i++){
            int maxIndex=0;//�������ֵ����arr[0]
            for(int j=1;j<arr.length-i;j++){//��������������ֵ
                if (arr[maxIndex]<arr[j]){
                    maxIndex=j;
                }
            }
            //���ֵ��������������Ԫ�ؽ���
            int t=arr[maxIndex];
            arr[maxIndex]=arr[arr.length-i-1];
            arr[arr.length-i-1]=t;
        }
    }
}
