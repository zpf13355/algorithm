### 题目

给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。

示例:

输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
输出: [3,3,5,5,6,7] 
解释: 

  滑动窗口的位置                最大值
---------------               -----
[1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7


提示：

你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 思路

单调栈+滑动窗口



### 代码

```java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums.length==0||k==0){
            return new int[0];
        }

        Deque<Integer> deque=new LinkedList<>();
        int[] res=new int[nums.length-k+1];
        for(int i=0;i<k;i++){ //先形成一个窗口
            while(!deque.isEmpty()&&deque.peekLast()<nums[i]){
                //队列的小值删除
                deque.removeLast();
            }
            //大值往队列增
            deque.addLast(nums[i]);
        }

        res[0]=deque.peekFirst();

        for(int i=k;i<nums.length;i++){
            //队列中的元素包含窗口的首元素,则删除，因为下一个窗口不需要
            if(deque.peekFirst()==nums[i-k]){
                deque.removeFirst();
            }

            while(!deque.isEmpty()&&deque.peekLast()<nums[i]){
                deque.removeLast();
                
            }
            
            deque.addLast(nums[i]);
            //是单调队列，首元素就是窗口最大值
            res[i-k+1]=deque.peekFirst();
        }
        return res;
    }
}
```

