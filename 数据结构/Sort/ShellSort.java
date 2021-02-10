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
    * ϣ������-����������Ż���
    * ϣ�������ֳ���С��������
    * ϣ�����򷨵Ļ���˼���ǣ���ѡ��һ���������Ѵ������ļ������м�¼�ֳɸ��飬
    * ���о���Ϊ�ļ�¼����ͬһ���ڣ�����ÿһ���ڵļ�¼��������
    * Ȼ��ȡ�ظ��������������Ĺ�����������1ʱ�����м�¼��ͳһ�����ź���
    *
    * // ���O(n^2)
    *��ã�O(n)
    *ƽ����O(n^1.3)
    *�ռ临�Ӷȣ�O(1)
    *���ȶ�
    * */
    private static void shellSort(int[] arr){
        //���鲽��
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
            for (j=i-gap;j>=0;j=j-gap){//���ǲ��������˼��
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
