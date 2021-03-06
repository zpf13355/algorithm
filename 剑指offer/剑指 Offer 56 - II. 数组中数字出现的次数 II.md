### 题目
在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。

示例 1：

输入：nums = [3,4,3,3]
输出：4
示例 2：

输入：nums = [9,1,7,9,7,9,7]
输出：1

### 思路
>题干：一个数字只出现一次之外，其他数字都出现了三次
>- 一个长度32的数组bit存每个元素的二进制位，统计的是所有元素对应二进制位1的个数
>- bit的每一个值取余消去出现三次的元素的二进制位(题干就是出现三次)，最后剩余的就是只出现一次的数的二进制数，并还原为十进制返回结果

```java
class Solution {
    public int singleNumber(int[] nums) {
        if(nums.length==0){
            return -1;
        }
        //存数组每一个元素二进制位
        int[] bit=new int[32];
        //将每一位数妇婴二进制位的所有制存入数组
        for(int num:nums){
            int m=1;
            //求每一位数的二进制的1
            for(int i=31;i>=0;i--){
                
                if((m&num)!=0){
                    bit[i]++;
                }
                //左移不涉及符号位
                m<<=1;
            }
        }
        int res=0;
        //取模3剩余位就是只出现一次的数的二进制位
        //出现三次的数的二进制位余3为0就消去了
        for(int i=0;i<32;i++){
        	//下两行代码不能交换，交换会多移动一次
            res<<=1;//二进制还原十进制
            res+=(bit[i]%3);//消去出现三次的二进制位
        }

        return res;
    }
}
```

### 复杂度
>**时间复杂度O(n)**:虽然有个二重循环，外层是n次，内层是32次常数次整体是n
>**空间复杂度O(1)**:数组长度32大小常数结果就是O(1)