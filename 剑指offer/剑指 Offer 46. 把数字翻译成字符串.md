### 题目
给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。

>示例 1:
>输入: 12258
>输出: 5
>解释: 12258有5种不同的翻译，分别是"bccfi", "bwfi", "bczi", "mcfi"和"mzi"

![在这里插入图片描述](https://img-blog.csdnimg.cn/20210402212531522.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1NjMwNzEx,size_16,color_FFFFFF,t_70#pic_center)
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210402210927318.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1NjMwNzEx,size_16,color_FFFFFF,t_70#pic_center)
>- 状态定义：列表dp,dp[i]代表以Xi结尾的数字的翻译方案数
>- 转移方程：
>1. 若Xi和Xi-1组成的两位数字可以被翻译，dp[i]=dp[i-1]+dp[i-2]
>2. 否则，dp[i]=dp[i-1]
>- 初始状态：dp[0]=dp[1]=1(无数字和1位数字的翻译方案数都是1)
>- 返回值dp[n]

>**dp[0]为什么为1**
>i=2表示两位数字翻译dp[2]=dp[1]+dp[0]=2
>两位数字就是整体翻译一种和分开翻译一种
>1位数字只有一种那么dp[0]=2-1=1因此dp[0]=1

>此处的动态规划对称的从右向左统计和从左向右结果一致

>字符串比较：xy>yx说明x>y;xy<yx说明x<y

>- 从左向右
```java
class Solution {
    public int translateNum(int num) {
        String s=String.valueOf(num);
        int[] dp=new int[s.length()+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=s.length();i++){
            String tmp=s.substring(i-2,i);
            if(tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0){
                dp[i]=dp[i-1]+dp[i-2];
            }else{
                dp[i]=dp[i-1];
            }    
        }
        return dp[s.length()];
    }
}
```

### 复杂度
>**时间复杂度O(n)**:
>**空间复杂度O(n)**":dp空间
```java
class Solution {
    public int translateNum(int num) {
        String s=String.valueOf(num);
        int a=1;
        int b=1;

        for(int i=2;i<=s.length();i++){
            String tmp=s.substring(i-2,i);
            int c=tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0?a+b:a;
            b=a;
            a=c;
        }
        return a;
    }
}
```

```java
class Solution {
    public int translateNum(int num) {
        String s=String.valueOf(num);
        int a=1;
        int b=1;

        for(int i=s.length()-2;i>-1;i--){
            String tmp=s.substring(i,i+2);
            int c=tmp.compareTo("10")>=0&&tmp.compareTo("25")<=0?a+b:a;
            b=a;
            a=c;
        }
        return a;
    }
}
```

### 复杂度
>**时间复杂度O(n)**
>**空间复杂度O(n)**:substring()方法耗费n空间