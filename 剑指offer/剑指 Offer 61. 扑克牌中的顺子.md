### 题目

从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

 

示例 1:

输入: [1,2,3,4,5]
输出: True


示例 2:

输入: [0,0,1,2,5]
输出: True

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 



### 代码

```java
class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            //跳过大小王
            if(num==0){
                continue;
            }
            max=Math.max(num,max);
            min=Math.min(num,min);

            //出现重复元素结束
            if(set.contains(num)){
                return false;
            }
            set.add(num);
        }
        return max-min<5;
    }
}
```

