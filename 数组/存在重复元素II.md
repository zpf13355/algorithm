### 题目

给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，使得 nums [i] = nums [j]，并且 i 和 j 的差的 绝对值 至多为 k。

 

示例 1:

输入: nums = [1,2,3,1], k = 3
输出: true
示例 2:

输入: nums = [1,0,1,1], k = 1
输出: true
示例 3:

输入: nums = [1,2,3,1,2,3], k = 2
输出: false

```java
class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
         Set<Integer> set=new HashSet<>();
         for(int i=0;i<nums.length;i++){
             //如果包含了当前元素就重复
             if(set.contains(nums[i])){
                 return true;
             }
             //没有包含就加入
             set.add(nums[i]);
             //加入的个数大于k说明i和j的差大于k
             if(set.size()>k){
                 //就删除这个元素
                 set.remove(nums[i-k]);
             }
         }
         return false;
    }
}



 
```

