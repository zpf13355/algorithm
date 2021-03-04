### 题目

数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。

 

你可以假设数组是非空的，并且给定的数组总是存在多数元素。

 

示例 1:

输入: [1, 2, 3, 2, 2, 2, 5, 4, 2]
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zu-zhong-chu-xian-ci-shu-chao-guo-yi-ban-de-shu-zi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

**### 解题思路0-摩尔投票算法**

**1.** count计数，major表示存活 x表示正在遍历的值

**2.** count=0说明前面的数可以组成两两不同的一对数进行抵消

  从新确定 count=1 major=x

**3.** coun!=0 

  major==x count++

  major1=x count--



**### 图解**

*![QQ截图20210105114633.png](https://pic.leetcode-cn.com/1609818689-hDWuWH-QQ%E6%88%AA%E5%9B%BE20210105114633.png)*



**### 视频讲解**

**[**https://www.bilibili.com/video/BV1it411V784?from=search&seid=15482777560008932265**](***b站讲解摩尔投票***)**

**### 代码**

```java
class Solution {
    public int majorityElement(int[] nums) {
        int major=0;
        int cnt=0;
        for(int x:nums){
            if(cnt==0){
                major=x;
                cnt=1;
            }else{
                if(major==x){
                    cnt++;
                }else{
                    cnt--;
                }
            }
        }

        if(cnt>0){
            int t=0;
            for(int x:nums){
                if(x==major){
                    t++;
                }
            }
            if(t>nums.length/2){
                return major;
            }
        }

        return -1;
    }
}
```

