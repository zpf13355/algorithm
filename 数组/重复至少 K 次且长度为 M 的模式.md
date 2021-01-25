### 题目

给你一个正整数数组 arr，请你找出一个长度为 m 且在数组中至少重复 k 次的模式。

模式 是由一个或多个值组成的子数组（连续的子序列），连续 重复多次但 不重叠 。 模式由其长度和重复次数定义。

如果数组中存在至少重复 k 次且长度为 m 的模式，则返回 true ，否则返回  false 。

 

示例 1：

输入：arr = [1,2,4,4,4,4], m = 1, k = 3
输出：true
解释：模式 (4) 的长度为 1 ，且连续重复 4 次。注意，模式可以重复 k 次或更多次，但不能少于 k 次。
示例 2：

输入：arr = [1,2,1,2,1,1,1,3], m = 2, k = 2
输出：true
解释：模式 (1,2) 长度为 2 ，且连续重复 2 次。另一个符合题意的模式是 (2,1) ，同样重复 2 次。
示例 3：

输入：arr = [1,2,1,2,1,3], m = 2, k = 3
输出：false
解释：模式 (1,2) 长度为 2 ，但是只连续重复 2 次。不存在长度为 2 且至少重复 3 次的模式。
示例 4：

输入：arr = [1,2,3,1,2], m = 2, k = 2
输出：false
解释：模式 (1,2) 出现 2 次但并不连续，所以不能算作连续重复 2 次。
示例 5：

输入：arr = [2,2,2,2], m = 2, k = 3
输出：false
解释：长度为 2 的模式只有 (2,2) ，但是只连续重复 2 次。注意，不能计算重叠的重复次数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/detect-pattern-of-length-m-repeated-k-or-more-times
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 解题思路-双指针+滑动窗口+序列判重



题目意思：右m个元素的序列重复k次即 m*k



**1.** 滑动窗口大小m*k

**2.** i标识为每个窗口的起始位置范围[0,arr.length-m*k]

**3.** j用来判断窗口中是否满足题目序列长度m重复k次

**4.** 长度为m序列两两迭代判断



*![QQ截图20210125101345.png](https://pic.leetcode-cn.com/1611540842-VghaAU-QQ%E6%88%AA%E5%9B%BE20210125101345.png)*





```java

class Solution {
    public boolean containsPattern(int[] arr, int m, int k) {
        if(arr.length<m*k){
            return false;
        }
        int i=0;
        int j=0;
       for(i=0;i<=arr.length-m*k;i++){
           for(j=i+m;j<i+m*k;j++){
               //窗口元素判断
               if(arr[j]!=arr[j-m]){
                   break;
               }  
           }
           if(j==i+m*k){
                return true;
            }
       }
       return false;
    }
}
```

