#### 问题描述

泰波那契序列 Tn 定义如下：
T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
给你整数 n，请返回第 n 个泰波那契数 Tn 的值。

示例 1：
输入：n = 4
输出：4
解释：
T_3 = 0 + 1 + 1 = 2
T_4 = 1 + 1 + 2 = 4

示例 2：
输入：n = 25
输出：1389537

#### 解题思路

递归耗时大
迭代思想优化

#### 代码

```
class Solution {
    public int tribonacci(int n) {
        if(0==n){
            return 0; 
        }
         if(n==2||n==1){
            return 1;
        }
        int result=0;
        int a=0;
        int b=1;
        int c=1;
        for(int i=3;i<=n;i++){
            result=a+b+c;
            a=b;
            b=c;
            c=result;
        }
        return result;
    }
}
```



 

获得授权，非商业转载请注明出处。