### 题目

在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

 

示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-shu-zi-chu-xian-de-ci-shu-ii-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 代码

```java
class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==0){
            return 0;
        }

        int[] bit=new int[32];
        //将每一位数妇婴二进制位的所有制存入数组
        for(int num:nums){
            int m=1;
            for(int i=31;i>=0;i--){
                if((m&num)!=0){
                    bit[i]++;
                }
                m<<=1;
            }
        }
        int res=0;
        //取模3剩余位就是只出现一次的数
        for(int i=0;i<32;i++){
            res<<=1;
            res+=(bit[i]%3);
        }

        return res;
    }
}
```

