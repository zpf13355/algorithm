### 题目

写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。

 

示例:

输入: a = 1, b = 1
输出: 2

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bu-yong-jia-jian-cheng-chu-zuo-jia-fa-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 代码

```java
class Solution {
    public int add(int a, int b) {
        while(b!=0){//进位为0时就退出
            //进位
            int c=(a&b)<<1;
            //a=非进位和
            a^=b;
            //b=进位
            b=c;
        }
        return a;
    }
}
```

