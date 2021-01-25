### 题目

统计一个数字在排序数组中出现的次数。

 

示例 1:

输入: nums = [5,7,7,8,8,10], target = 8
输出: 2
示例 2:

输入: nums = [5,7,7,8,8,10], target = 6
输出: 0

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zai-pai-xu-shu-zu-zhong-cha-zhao-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 代码

```java
class Solution {
    public int search(int[] nums, int target) {
        return find(nums,target)-find(nums,target-1);
    }
    //二分搜索尾
    public static int find(int[] nums,int tag){
        int i=0;
        int j=nums.length-1;
        while(i<=j){
            int mid=i+(j-i)/2;
            if(nums[mid]<=tag){
                i=mid+1;
            }else{
                j=mid-1;
            }
        }
        return i;
    }
}
```

