### 题目

实现 strStr() 函数。

给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。

示例 1:

输入: haystack = "hello", needle = "ll"
输出: 2
示例 2:

输入: haystack = "aaaaa", needle = "bba"
输出: -1
说明:

当 needle 是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。

对于本题而言，当 needle 是空字符串时我们应当返回 0 。这与C语言的 strstr() 以及 Java的 indexOf() 定义相符。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/implement-strstr
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 题解

**1.** haystack中查找与needle第一个字符相等的起始位置

**2.** 然后两个指针i,j同时移动，遍历l2个长度的字符创是否相等

**3.** 相等就退出，否则i就回到上一次起始位置的后面继续遍历needle第一个字符相等的起始位置



### 代码

```java
class Solution {
    public int strStr(String haystack, String needle) {
        //haystack的长度
        int l1=haystack.length();
        //needle的长度
        int l2=needle.length();
        //neddle长度为0返回0
        if(l2==0){
            return 0;
        }
        int i=0;
       
        while(i<l1-l2+1){//i<l1-l2+1缩小遍历条件因为l2长度的字符要匹配
            //查找haystack中needle第一个字符相等的位置
            while(i<l1-l2+1&&haystack.charAt(i)!=needle.charAt(0)){
                i++;
            }
            int curLen=0;
            int j=0;
            //滑动窗口-判断是在经过l2长度个数的字符是否匹配
            while(i<l1&&j<l2&&haystack.charAt(i)==needle.charAt(j)){
                curLen++;
                i++;
                j++;
            }
            //匹配就结束
            if(curLen==l2){
                return i-curLen;
            }
            //返回下一次开始偏离位置继续查找与needle中的第一个字符相等的位置
            i=i-curLen+1;
        }
        return -1;
    }
}


```

