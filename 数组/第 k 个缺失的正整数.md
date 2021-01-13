### 题目

给你一个 严格升序排列 的正整数数组 arr 和一个整数 k 。

请你找到这个数组里第 k 个缺失的正整数。

 

示例 1：

输入：arr = [2,3,4,7,11], k = 5
输出：9
解释：缺失的正整数包括 [1,5,6,8,9,10,12,13,...] 。第 5 个缺失的正整数为 9 。
示例 2：

输入：arr = [1,2,3,4], k = 2
输出：6
解释：缺失的正整数包括 [5,6,7,...] 。第 2 个缺失的正整数为 6 。





### 解1

不难发现，一个不缺失元素的序列，会有arr[i]=i+1这样的关系，而在缺失元素之后，会有arr[i]>i+1，简单移项可得 arr[i]-i-1 > 0，缺失一个的时候，相差1，两个则相差2，以此类推，缺失越多，两者差距越大，我们要找第k个缺失的，换言之，只要arr[i]-i-1 == k,我们便找到了题目要找的数字。



### 图

*![QQ截图20210113110402.png](https://pic.leetcode-cn.com/1610507613-LDqBve-QQ%E6%88%AA%E5%9B%BE20210113110402.png)*



```java
class Solution {
    public int findKthPositive(int[] arr, int k) {
       int i;
       for( i=0;i<arr.length;i++){
           if(arr[i]-i-1>=k){
               return k+i;
           }
       }
       return k+i;
    }
}




```





### 解2-枚举



```java
class Solution {
    public int findKthPositive(int[] arr, int k) {
        //表示当前的数
        int current=1;
        //遍历数组的下标
        int ptr=0;
        //缺失的个数
        int count=0;
        //缺失的值
        int missVal=0;
        for(count=0;count<k;current++){
            if(current==arr[ptr]){
                ptr=(ptr+1<arr.length)?ptr+1:ptr;
            }else{
                count++;
                missVal=current;
            }
        }
        return missVal;
    }
}



```

