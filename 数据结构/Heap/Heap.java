package Heap;

public class Heap {

    public static void main(String[] args) {
        int[] arr1= { 27,15,19,18,28,34,65,49,25,37 };
        //����ǰ
        for (int x:arr1){
            System.out.print(x+" ");
        }

        downUpdate(arr1,10,0);
        System.out.println();
        //������
        for (int x:arr1){
            System.out.print(x+" ");
        }
        System.out.println();
        int[] arr2= { 8,2,3,4,5,6,7 };
        //����ǰ
        for (int x:arr2){
            System.out.print(x+" ");
        }

        upUpdate(arr2,10,1);
        System.out.println();
        //������
        for (int x:arr2){
            System.out.print(x+" ");
        }
        System.out.println();
        //����
        int[] arr3= { 27,15,19,18,28,34,65,49,25,37 };
        creatHeap(arr3,10);
        for (int x:arr3){
            System.out.print(x+" ");
        }
    }
    //���µ���
    public static void downUpdate(int[] arr,int size,int index){
        while(true){
            //1. �ж��ǲ���Ҷ�ӽڵ�
            int leftIndex=2*index+1;
            if(leftIndex>=size){
                return;
            }
            int rightIndex=leftIndex+1;
            int minIndex=leftIndex;
            if(rightIndex<size&&arr[leftIndex]>arr[rightIndex]){
                minIndex=rightIndex;
            }
            //4.�Ƚ�С���Ӻ�index
            if(arr[index]<=arr[minIndex]){
                return;
            }
            //5.����
            int temp=arr[index];
            arr[index]=arr[minIndex];
            arr[minIndex]=temp;

            //6.�������µ���
            index=minIndex;
        }
    }
    //���ϵ���
    public static void upUpdate(int[] arr,int size,int index){
        while(true){
            //1.�ж�index�ǲ������� �Ǿ��ǽ���
            if (index==0){
                return;
            }
            //2.�ҵ�index�ĸ��ڵ�
            int parentIndex=(index-1)/2;
            //3.���ڵ��index�Ƚ� ���ڵ��ֵС��index��ֵ
            if (arr[parentIndex]<=arr[index]){
                return;
            }
            //4.�����ڵ�
            int temp=arr[parentIndex];
            arr[parentIndex]=arr[index];
            arr[index]=temp;

            //4.ѭ�����ϵ���
            index=parentIndex;

        }
    }
    //���齨�� -���µ���
    /*
    * ����������ʵ���Ǹ���һ�����Ĳ������
    * �����һ����Ҷ�ӽڵ�-0�������µ�������
    * 1.�ҵ����һ���ڵ���±�
    * 2.�ҵ����һ���ڵ�ĸ��ڵ���±�
    * 3.��������ڵ㵽0�������µ���
    * */
    public static void creatHeap(int[] arr,int size){
        //�ҵ����һ���ڵ���±�
        int lastIndex=size-1;
        //�ҵ����һ���ڵ�ĸ��ڵ�
        int lastParentIndex=(size-1)/2;
        //[lastIndex��0]�������µ���
        for (int i=lastIndex;i>=0;i--){
            //���µ���
            downUpdate(arr,size,i);
        }
    }


}
