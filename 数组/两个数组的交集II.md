**### 题**

给定两个数组，编写一个函数来计算它们的交集。



 



示例 1：



输入：nums1 = [1,2,2,1], nums2 = [2,2]

输出：[2,2]

示例 2:



输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]

输出：[4,9]





我们可以不考虑输出结果的顺序。



**### 解1-哈希表**



*![QQ截图20210119082759.png](https://pic.leetcode-cn.com/1611017070-qpumgy-QQ%E6%88%AA%E5%9B%BE20210119082759.png)*





**### 代码1**



```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       
       if(nums1.length>nums2.length){
           return intersect(nums2,nums1);
       }

       Map<Integer,Integer> map=new HashMap<>();
       for(int x:nums1){
           int count=map.getOrDefault(x,0)+1;
           map.put(x,count);
       }

       int index=0;
       int[] res=new int[nums1.length];

       for(int x:nums2){
           int count=map.getOrDefault(x,0);
           if(count>0){
               res[index]=x;
               count--;
               index++;
               if(count>0){
                   map.put(x,count);
               }else{
                   map.remove(x);
               }
           }
       }

       return Arrays.copyOfRange(res,0,index);
    }
}



```





**### 解2-双指针+排序**

**1.** 当两者不同时，小的那个数组前进

**2.** 两者相同的时候，两者同时前进，且记录当前数字

**3.** 当一数组遍历完成时候推出循环（难点，有一个数组遍历完便可以结束循环）

```java
class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
       int i=0;
       int j=0;
       int k=0;
       Arrays.sort(nums1);
       Arrays.sort(nums2);
       while(i<nums1.length&&j<nums2.length){
           if(nums1[i]==nums2[j]){
               nums1[k]=nums1[i];
               k++;
               i++;
               j++;
           }else if(nums1[i]>nums2[j]){
               j++;
           }else{
               i++;
           }
       }

       return Arrays.copyOfRange(nums1,0,k);

    }
}

```







如果两个数组是有序的，则可以便捷地计算两个数组的交集。采用方法2已排序的数组，则只需 O(n) 的时间复杂度

**>**



如果 nums1 的大小比 nums2 小很多，哪种方法更优？

**>***方法1将较小的数组哈希计数，随后在另一个数组中根据哈希来寻找。*



如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？



**>***如果nums2的元素存储在磁盘上，磁盘内存是有限的，并且你不能一次加载所有的元素到内存中。那么就无法高效地对 nums2进行排序，因此推荐使用方法一而不是方法二。在方法一中，nums2只关系到查询操作，因此每次读取 nums2中的一部分数据，并进行处理即可*