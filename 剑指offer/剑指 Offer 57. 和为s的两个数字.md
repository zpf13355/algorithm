### 题目

输入一个递增排序的数组和一个数字s，在数组中查找两个数，使得它们的和正好是s。如果有多对数字的和等于s，则输出任意一对即可。

 

示例 1：

输入：nums = [2,7,11,15], target = 9
输出：[2,7] 或者 [7,2]
示例 2：

输入：nums = [10,26,30,31,47,60], target = 40
输出：[10,30] 或者 [30,10]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

###双指针-快

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int left=0;
        int right=nums.length-1;
        while(left<right){
            if(nums[left]+nums[right]==target){
                return new int[]{nums[left],nums[right]};
            }else if(nums[left]+nums[right]>target){
                right--;
            }else{
                left++;
            }
        }
        return new int[0];
    }
}
```

### 二分-慢

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
       

        for(int i=0;i<nums.length;i++){
            int left=i+1; 
            int right=nums.length-1;
            int e=target-nums[i];
            while(left<=right){
                int mid=left+(right-left)/2;
                if(nums[mid]==e){
                    return new int[]{nums[mid],nums[i]};
                }else if(nums[mid]>e){
                    right=mid-1;
                }else{
                    left=mid+1;
                }
            }
        }
        return new int[0];
    }
}
```

### 哈希-最慢

```java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Set<Integer> set=new HashSet<>();

        //数组导入集合
        for(int x:nums){
            set.add(x);
        }

        for(int x:nums){
            int e=target-x;
            if(set.contains(e)){
                return new int[]{x,e};
            }
        }
        return new int [0];
    }
}
```

