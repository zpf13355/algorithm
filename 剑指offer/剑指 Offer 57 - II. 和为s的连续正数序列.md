### 题目
输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。


>示例 1：
>输入：target = 9
>输出：[[2,3,4],[4,5]]
>示例 2：
>输入：target = 15
>输出：[[1,2,3,4,5],[4,5,6],[7,8]]

### 思路-双指针+滑动窗口
>- 初始化：左边界left=1;右边界right=2;窗口和s=3
>- 循环i>=j跳出(题目要求至少两个元素)
>   1. s==target,滑动窗口序列加入结果集, left后移
>   2. s> target left后移 窗口和s减去左边界
>   3. s<target right后移 窗口和加上右边界
>- 返回结果集


```java
class Solution {
    public int[][] findContinuousSequence(int target) {
        int left=1;
        int right=2;
        int s=3;
        List<int[]> list=new ArrayList<>();
        while(left<right){
            if(s==target){
                int[] res=new int[right-left+1];
                for(int k=left;k<=right;k++){
                    res[k-left]=k;
                }
                list.add(res);
            }
            //相等也要后移
            if(s>=target){
                s-=left;
                left++;
            }else{
                right++;
                s+=right;
            }
        } 
        //二维数组必须指定第一维大小
        return list.toArray(new int[0][]);
    }
}
```

### 复杂度
>**时间复杂度O(n)**
>**空间复杂度O(1)**: left,right,s均是常数阶