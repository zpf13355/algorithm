### 题目

输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数位于数组的前半部分，所有偶数位于数组的后半部分。

 

示例：

输入：nums = [1,2,3,4]
输出：[1,3,2,4] 
注：[3,1,2,4] 也是正确的答案之一。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/diao-zheng-shu-zu-shun-xu-shi-qi-shu-wei-yu-ou-shu-qian-mian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 解1-首尾指针

- 定义头指针 leftleft ，尾指针 rightright .
- leftleft 一直往右移，直到它指向的值为偶数
  rightright 一直往左移， 直到它指向的值为奇数
- 交换 nums[left]nums[left] 和 nums[right]nums[right] .
- 重复上述操作，直到 left == rightleft==right .

### <u>奇欧判断：x%2==1  等价于   x&1==1</u>





```java
class Solution {
    public int[] exchange(int[] nums) {
        int left=0;
        int right=nums.length-1;

        while(left<right){
            while(left<right&&nums[left]%2==1){
                left++;
            }
            while(left<right&&nums[right]%2==0){
                right--;
            }
            int tmp=nums[left];
            nums[left]=nums[right];
            nums[right]=tmp;
        }
        return nums;
    }
}
```



### 解2-快慢指针

- 定义快慢双指针 fastfast 和 lowlow ，fastfast 在前， lowlow 在后 .
- fastfast 的作用是向前搜索奇数位置，lowlow 的作用是指向下一个奇数应当存放的位置
- fastfast 向前移动，当它搜索到奇数时，将它和 nums[low]nums[low] 交换，此时 lowlow 向前移动一个位置.
- 重复上述操作，直到 fastfast 指向数组末尾 .



### <u>奇欧判断：x%2==1  等价于   x&1==1</u>



```java
class Solution {
    public int[] exchange(int[] nums) {

        int fast=0;
        int slow=0;
        while(fast<nums.length){
            if(nums[fast]%2==1){
                int tmp=nums[fast];
                nums[fast]=nums[slow];
                nums[slow]=tmp;

                slow++;
            }
            fast++;
        }
        return nums;
    }
}
```





