### 题目

一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。

 

示例 1：

输入：nums = [4,1,4,6]
输出：[1,6] 或 [6,1]
示例 2：

输入：nums = [1,2,10,4,1,4,3,3]
输出：[2,10] 或 [10,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 代码

```java
class Solution {
    public int[] singleNumbers(int[] nums) {
        int x=0;
        int y=0;
        int m=1;
        int n=0;
        //遍历异或：结果就是两个不同数字的异或值
        for(int num:nums){
            n^=num;
        }

        //找出异或结果中二进制第一个出现为1的位置
        while((n&m)==0){
            m<<=1;
        }

        //分组:此位置与结果为0分为第一组，结果1分为第2组
        //两个不同的元素刺猬置势必不同分为不同组，相同势必分为同一组
        for(int num:nums){
            if((m&num)==0){
                x^=num;
            }else{
                y^=num;
            }
        }

        return new int[]{x,y};

    }
}
```

