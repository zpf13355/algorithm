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
    * ��Ϊ�����������������
    * ���������䣬ͨ���������ıȽϣ���������ð�ݵ�������������
    * ����������̣�ֱ��������������
    *
    *ʱ�临�Ӷ�
    *���: O(n) ����
    *�: O(n^2) ����
    *ƽ��: O(n^2)
    *�ռ临�Ӷ�
    *���/ƽ��/���O(1)
    *�߱��ȶ���
    * */
    private static void bubbleSort(int[] arr){
        //ð������
        for(int i=0;i<arr.length-1;i++){
            /*
            *�������䣺[0,arr.length-i)
            *�������䣺[arr.length-i,arr.length)
            *
            * */

            //isSorted�����ж������Ƿ��Ѿ�����
            boolean isSorted=true;
            //��������ıȽϽ���
            for (int j=0;j<arr.length-1-i;j++){
                if(arr[j]>arr[j+1]){
                    int t=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=t;
                    isSorted=false;
                }
            }
            //һ��ð��֮�����δ��������˵����������ģ�ֱ���˳�
            if (isSorted){
                break;
            }
        }
    }
}
