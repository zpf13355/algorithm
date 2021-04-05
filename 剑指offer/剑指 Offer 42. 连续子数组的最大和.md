### 题目
输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。

要求时间复杂度为O(n)。

>示例1:
>输入: nums = [-2,1,-3,4,-1,2,1,-5,4]
>输出: 6
>解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。

### 思路
>- 状态定义：动态规划列表dp：dp[i]表示以nums[i]结尾的连续最大子数组和
>- 转移方程：
>1. dp[i-1]>0 : dp[i]=dp[i-1]+nums[i]
>2. dp[i-1]<=0 : dp[i]=nums[i](加个负数还不如不加大) 
>- 初始状态：dp[0]=nums[0]
>- 返回值dp列表最大

- 开销额外空间
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1]+nums[i],nums[i]);
            max=Math.max(max,dp[i]);
        }

        return max;
    }
}
```
>**时间复杂度O(n)**
>**空间复杂度O(n)**

- 不开销额外空间
```java
class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            nums[i] += Math.max(nums[i - 1], 0);
            res = Math.max(res, nums[i]);
        }
        return res;
    }
}
```

>**时间复杂度O(n)**
>**空间复杂度O(1)**：