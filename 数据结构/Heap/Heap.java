package Heap;

public class Heap {

    public static void main(String[] args) {
        int[] arr1= { 27,15,19,18,28,34,65,49,25,37 };
        //调整前
        for (int x:arr1){
            System.out.print(x+" ");
        }

        downUpdate(arr1,10,0);
        System.out.println();
        //调整后
        for (int x:arr1){
            System.out.print(x+" ");
        }
        System.out.println();
        int[] arr2= { 8,2,3,4,5,6,7 };
        //调整前
        for (int x:arr2){
            System.out.print(x+" ");
        }

        upUpdate(arr2,10,1);
        System.out.println();
        //调整后
        for (int x:arr2){
            System.out.print(x+" ");
        }
        System.out.println();
        //建堆
        int[] arr3= { 27,15,19,18,28,34,65,49,25,37 };
        creatHeap(arr3,10);
        for (int x:arr3){
            System.out.print(x+" ");
        }
    }
    //向下调整
    public static void downUpdate(int[] arr,int size,int index){
        while(true){
            //1. 判断是不是叶子节点
            int leftIndex=2*index+1;
            if(leftIndex>=size){
                return;
            }
            int rightIndex=leftIndex+1;
            int minIndex=leftIndex;
            if(rightIndex<size&&arr[leftIndex]>arr[rightIndex]){
                minIndex=rightIndex;
            }
            //4.比较小孩子和index
            if(arr[index]<=arr[minIndex]){
                return;
            }
            //5.交换
            int temp=arr[index];
            arr[index]=arr[minIndex];
            arr[minIndex]=temp;

            //6.继续向下调整
            index=minIndex;
        }
    }
    //向上调整
    public static void upUpdate(int[] arr,int size,int index){
        while(true){
            //1.判断index是不是树根 是就是结束
            if (index==0){
                return;
            }
            //2.找到index的父节点
            int parentIndex=(index-1)/2;
            //3.父节点和index比较 父节点的值小于index的值
            if (arr[parentIndex]<=arr[index]){
                return;
            }
            //4.交换节点
            int temp=arr[parentIndex];
            arr[parentIndex]=arr[index];
            arr[index]=temp;

            //4.循环向上调整
            index=parentIndex;

        }
    }
    //数组建堆 -向下调整
    /*
    * 给定的数组实则是给了一个数的层序遍历
    * 从最后一个非叶子节点-0依次向下调整即可
    * 1.找到最后一个节点的下标
    * 2.找到最后一个节点的父节点的下标
    * 3.从这个父节点到0依次向下调整
    * */
    public static void creatHeap(int[] arr,int size){
        //找到最后一个节点的下标
        int lastIndex=size-1;
        //找到最后一个节点的父节点
        int lastParentIndex=(size-1)/2;
        //[lastIndex，0]依次向下调整
        for (int i=lastIndex;i>=0;i--){
            //向下调整
            downUpdate(arr,size,i);
        }
    }


}
