### 题目

实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。

 

示例 1：

输入：x = 2.00000, n = 10
输出：1024.00000
示例 2：

输入：x = 2.10000, n = 3
输出：9.26100
示例 3：

输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 递归

```java
class Solution {
    public double myPow(double x, int n) {
        if(n==0){
            return 1;
        }

        //n为负数
        if(n<0){
            return 1/x*myPow(1/x,-n-1);
        }

        return (n%2==0)?myPow(x*x,n/2):x*myPow(x*x,n/2);
    }
}
```

### 迭代

```java
class Solution {
    public double myPow(double x, int n) {
        double res=1.0;
        for(int i=n;i!=0;i/=2,x*=x){
            if(i%2!=0){
                //奇数的话需要多乘一次x
                res*=x;
            }
        }

        return n<0?1.0/res:res;
    }
}
```

### 快速冥解法

```java
class Solution {
    public double myPow(double x, int n) {
        if(x==0){
            return 0;
        }
        //int可能会越界
        long b=n;
        double res=1.0;
        if(b<0){
            x=1/x;
            b=-b;
        }

        while(b>0){
            if((b&1)==1){
                //当前是奇数位
                res*=x;
            }
            x*=x;
            //b/2相当于b右移一位
            b>>=1;
        }

        return res;
    }
}
```

