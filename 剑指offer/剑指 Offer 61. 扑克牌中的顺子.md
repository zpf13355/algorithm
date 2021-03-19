### 题目
从扑克牌中随机抽5张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。

>示例 1:
>输入: [1,2,3,4,5]
>输出: True
> 示例 2:
>输入: [0,0,1,2,5]
>输出: True

### 解1-set
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210319212736950.png#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210319212747695.png#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210319212755927.png#pic_center)
>- 遍历数组跳过大小王
>- set判重
>- 获取最大值和最小值
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

### 复杂度
>**时间复杂度O(1)**: O(N)=O(5)=O(1) 遍历数组O(n)
>**空间复杂度O(1)**: O(N)=O(5)=O(1) set的O(n)额外空间

### 解2-排序
```java
class Solution {
    public boolean isStraight(int[] nums) {
        //大小王个数
        int jok=0;
        //排序
        Arrays.sort(nums);
        for(int i=0;i<4;i++){
            //统计大小王个数
            if(nums[i]==0){
                jok++;
            }else if(nums[i]==nums[i+1]){
                //有重复元素直接返回
                return false;
            }
        }
        //最大值和最小值之差小于5就是顺子
        return nums[4]-nums[jok]<5;
    }
}
```
### 复杂度
>**时间复杂度O(1)**:O(NlogN)=O(5log5)=O(1) ： 其中 NN 为 numsnums 长度，本题中 N \equiv 5N≡5 ；数组排序使用 O(N \log N)O(NlogN) 时间。
>**空间复杂度O(1)**: 变量 jokr 使用 O(1)O(1) 大小的额外空间。



### 



