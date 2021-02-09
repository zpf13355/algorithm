#### 思路

### 二分

1. mid=nums[mid]说明[left,mid]无缺失
2. 否则说明在[mid+1,,right]中缺失
3. left=nums.length-1;nums[left]=left说明数组尾且正数组无缺失

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

### 异或-面试不建议

相同为0不同为1

先异或值再异或下标，值和下标相同就抵消

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



