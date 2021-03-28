求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。

>示例 1：
>输入: n = 3
>输出: 6
>示例 2：
>输入: n = 9
>输出: 45

### 思路
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210328185120912.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1NjMwNzEx,size_16,color_FFFFFF,t_70#pic_center)
```java
class Solution {
    int res=0;
    public int sumNums(int n) {
        boolean x=n>1&&sumNums(n-1)>0;
        res+=n;
        return res;
    }
}
```

### 复杂度
>**时间复杂度O(n)**: n次递归
>**空间复杂度O(n)**: 递归深度n