### 题目

一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。

 

示例 1:

输入: [0,1,3]
输出: 2
示例 2:

输入: [0,1,2,3,4,5,6,7,9]
输出: 8

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/que-shi-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 二分

**1.** mid=nums[mid]说明[left,mid]无缺失

**2.** 否则说明在[mid+1,,right]中缺失

**3.** left=nums.length-1;nums[left]=left说明数组尾且正数组无缺失

```java
class Solution {
    public int missingNumber(int[] nums) {
        int left=0;
        int right=nums.length-1;

        while(left<right){
            int mid=(left+right)/2;

            if(nums[mid]==mid){
                //说明[i,mid]是没有缺失,缺失了肯定对应不上，本质就是下标就是值 下标和值都是从零开始
                left=mid+1;
            }else{
                right=mid;
            }
        }
        //lef和right指向同一位置
        //if(nums[left]=nums.length-1)只能说是有序但无法说明是0-n-1
        if(left==nums.length-1&&nums[left]==left){
            //说明数组本就是有序不缺失的,且指向最后一个元素
            left++;
        }
        return left;
    }
}
```

### 异或

```java
class Solution {
    public int missingNumber(int[] nums) {
        int res=nums.length;
        for(int i=0;i<nums.length;i++){
            res^=nums[i];
            res^=i;
        }
        return res;
    }
}
```

