### 题目

给定一个增序排列数组 nums ，你需要在 原地 删除重复出现的元素，使得每个元素最多出现两次，返回移除后数组的新长度。

不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



**### 解题思路**

同向指针解题步骤-快慢指针，滑动窗口

解题步骤(重点来了)

1.定义指针 明确含义

2.确定终止条件

3.确定指针运动条件

4.根据定义确定返回值

重点:循环不变量的初始、迭代、退出时保持定义一致。





这里定义了两个指针,index 与 j,其中j是隐式的放在循环体里的。

index:定义index表示不重复元素集合的右边界.用数学公式表示即[0,index)表示修改后的数组，因为左闭右开，所以index取不到

有了变量定义，按照循环不变量的要求，我们先要确定初始化的时候是严格遵守定义的。初始化时不重复元素为空, 因为左闭右开，所以index = 0的时候,

[0,0)是空集，满足要求。

**2.** 确定循环终止条件

隐式的指针j,循环的终止条件就是j循环到数组的末尾。



**3.** 确定指针运动条件

根据index的定义:不重复的元素的右边界，那么当有新的不重复的元素需要加入时index将向右移动。

如何运动呢？跟指针的定义有关系，用循环不变量的话来说:就是你得在循环的时候保持变量的定义不变。

因为这里我们定义不重复元素集合是[0,index)左闭右开，因此index这个下标是可以用来放新的不重复元素的。同时index++;保持下一个循环时任然是[0,index）左闭右开。

根据定义确定返回值

返回值是指新数组的长度，因为整个不重复元素集合是[0，index),即[0,index-1] 左闭右闭。因此一共有index-1 - 0 + 1个元素。



**### 题目**

**[**26. 删除排序数组中的重复项**](***https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/***)**

每个元素最多出现1次

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length==0){
            return 0;
        }
        //1.指针定义[0,index]是修改后的无重复排序元素-0位置元素已经纳入
        int index=1-0;
        //2.另一个循环指针从1开始终止条件nums.length 从1开始要比较重复元素nums[0]
        for(int j=1;j<nums.length;j++){
            //3.指针运动条件
            if(nums[index-1+1]!=nums[j]){
                index++;
                nums[index]=nums[j];
            }
        }
        //4.根据定义确定返回值
        return index+1;

    }
}


```



**### 题目**

**[**80. 删除排序数组中的重复项 II**](***https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/***)**

每个元素最多出现2次

```java
class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length<=2){
            return nums.length;
        }
        int index=2-1;
        for(int j=2;j<nums.length;j++){
            if(nums[index-2+1]!=nums[j]){
                index++;
                nums[index]=nums[j];
            }
        }
        return index+1;
    }
}



```





**### 题目-通用公式**

删除排序数组中的重复项 

每个元素最多出现k次

```java
class Solution {
    public int removeDuplicates(int[] nums,int k) {
            if(nums == null) return 0;
            if(nums.length <= k) return nums.length;
            
            // 1.定义[0,index] 是修改后的满足要求的数组区间,这里已经把0 1 2 ...k- 1 ,共k个数 放进去了
            int index = k - 1;
            // 2.判断终止条件
            for(int j = k;i < nums.length;j++){
                // 3.指针移动条件
                if(nums[j] != nums[index-k+1]){
                    index++;
                    nums[index] = nums[j];
                }
            }
            // 4.判断返回值
            return index + 1;
    }
}


```

