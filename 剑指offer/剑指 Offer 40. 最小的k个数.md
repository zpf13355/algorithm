### 题目

输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。

 

示例 1：

输入：arr = [3,2,1], k = 2
输出：[1,2] 或者 [2,1]
示例 2：

输入：arr = [0,1,2,1], k = 1
输出：[0]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 解1-堆
>- 建立一个大小为k的大根堆
>- 若堆的大小小于k，直接将元素数加入到堆中
>- 否则判断当前数字与大根堆堆顶元素的大小关系:
>   1. 如果当前数字比大根堆堆顶还大，这个数就直接跳过；
>  2. 反之如果当前数字比大根堆堆顶小，先poll掉堆顶，再将该数字放入堆中。

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k==0||arr.length==0){
            return new int[0];
        }

        //Queue<Integer> queue=new PriorityQueue<>((v1, v2) -> v2 - v1);
        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(
            new Comparator<Integer>() {
                public int compare(Integer num1, Integer num2) {
                    return num2 - num1;
                }
            });
        //遍历数组加入堆
        for(int x:arr){
            //堆的大小小于k,元素直接加入堆
           if(queue.size()<k){
               queue.offer(x);
           }else if(x<queue.peek()){
               //堆的大小大于等于k，大顶堆堆顶就是最大值，当前元素小于堆顶，就移除堆顶，加入当前元素
               queue.poll();
               queue.offer(x);
           }
        }
        //将堆中元素移到数组
        int[] res=new int[k];
        int index=0;
        for(int x:queue){
            res[index++]=x;
        }

        return res;
    }
}
```

### 解2-快排
>- 若 j = p，我们就找到了最小的 k 个数，就是左侧的数组；
>- 若 j<m ，则最小的 k个数一定都在左侧数组中，我们只需要对左侧数组递归地 parition 即可；
>- 若 j>m，则左侧数组中的 m 个数都属于最小的 k 个数，我们还需要在右侧数组中寻找最小的 k-m个数，对右侧数组递归地 partition 即可。

```java
class Solution {
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0 || arr.length == 0) {
            return new int[0];
        }
        // 最后一个参数表示我们要找的是下标为k-1的数
        return quickSearch(arr, 0, arr.length - 1, k - 1);
    }
    private int[] quickSearch(int[] arr,int l,int r,int p){
        int j=paration(arr,l,r);
        if(j==p){
            return Arrays.copyOf(arr,j+1);
        }

        return j>p?quickSearch(arr,l,j-1,p):quickSearch(arr,j+1,r,p);
    }
	//Hoare法
    private int paration(int[] arr,int l,int r){
        int i=l;
        int j=r;
        int key=arr[l];
        while(i<j){
            //最左边为基准值必须从最右边查找
            //选择左边为基准值就必须先从最右边找
            //下面两行交换就会出错
            /*
            * 1 3 5 7 9
            * key 1
            * i=0 arr[i]=1
            * j=9 arr[j]=9
            *
            * 选择最左边第一个值作为基准值
            * 如果从左边开始寻找，一直向右找大于等于1的值 找到3
            * 然后从右边找小于等于1的值 找到i=j就退出 也是3
            * 自身交换 然后再3 1 交换成  3  1   5 7 9
            *都不满足基准值1左边是小于它的值右边是大于它的值
            * 故推翻
            * */
            while(i<j&&arr[j]>=key){
                j--;
            }
            while(i<j&&arr[i]<=key){
                i++;
            }
            int tmp=arr[i];
            arr[i]=arr[j];
            arr[j]=tmp;
        }
        arr[l]=arr[i];
        arr[i]=key;

        return j;
    }
        
}

```



