package Sort;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr={1,3,5,7,9,2,4,6,8,10};
        System.out.println(Arrays.toString(arr));
        mergeSort(arr);
        System.out.println(Arrays.toString(arr));
    }
    /*
    * �鲢����
    * �鲢����MERGE-SORT���ǽ����ڹ鲢�����ϵ�һ����Ч�������㷨,���㷨�ǲ��÷��η���Divide and
    *Conquer����һ���ǳ����͵�Ӧ�á���������������кϲ����õ���ȫ��������У�
    * ����ʹÿ��������������ʹ�����жμ������������������ϲ���һ���������Ϊ��·�鲢
    *
    * ʱ�临�Ӷȣ�O(n*logn)
    * �ռ临�Ӷȣ�O(n)
    * �ȶ��ԣ��ȶ�
    * */
    //�ݹ��
    public static void mergeSort(int[] array) {
        mergeSortInternal(array, 0, array.length);
    }
    //array->[low,high)
    private static void mergeSortInternal(int[] array, int low, int high) {
        int size=high-low;
        if(size<=1){
            return;
        }
        int mid=(low+high)/2;
        /*
        * ������[low,,mid)
        * ������[mid,high)
        * */
        mergeSortInternal(array,low,mid);
        mergeSortInternal(array,mid,high);

        merge(array,low,mid,high);
    }

    //�ǵݹ�
    public static void mergeSort1(int[] array) {
        for (int i = 1; i < array.length; i = i * 2) {
            for (int j = 0; j < array.length; j = j + 2 * i) {
                int low = j;
                int mid = j + i;
                if (mid >= array.length) {
                    continue;
                }

                int high = mid + i;
                if (high > array.length) {
                    high = array.length;
                }

                merge(array, low, mid, high);
            }
        }
    }
    private static void merge(int[] array, int low, int mid, int high) {
        int size=high-low;
        //��������
        int[] extraArray=new int[size];
        int extraIndex=0;
        //���������ʼλ��
        int leftIndex=low;
        //���������ʼλ��
        int rightIndex=mid;

        while(leftIndex<mid&&rightIndex<high){
            if(array[leftIndex]<array[rightIndex]){
                extraArray[extraIndex]=array[leftIndex];
                leftIndex++;
            }else{
                extraArray[extraIndex]=array[rightIndex];
                rightIndex++;
            }
            extraIndex++;
        }

        if (rightIndex<high){
            while (rightIndex<high){
                extraArray[extraIndex]=array[rightIndex];
                rightIndex++;
                extraIndex++;
            }
            if(leftIndex<mid){
                while(leftIndex<mid){
                    extraArray[extraIndex]=array[leftIndex];
                    leftIndex++;
                    extraIndex++;
                }
            }
            //�������黹ԭ
            /*
            * ������[]0,size)
            * ������[low,high)
            */
            for (int i=0;i<size;i++){
                array[low+i]=extraArray[i];
            }
        }

    }

}
