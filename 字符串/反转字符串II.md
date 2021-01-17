### 题目

给定一个字符串 s 和一个整数 k，你需要对从字符串开头算起的每隔 2k 个字符的前 k 个字符进行反转。

如果剩余字符少于 k 个，则将剩余字符全部反转。
如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。


示例:

输入: s = "abcdefg", k = 2
输出: "bacdfeg"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/reverse-string-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



### 代码

```java
class Solution {
    public String reverseStr(String s, int k) {
        
   
        char[] chars=s.toCharArray();
        int len=chars.length;
        //步长2k遍历
        for(int i=0;i<len;i+=2*k){
            int start=i;
            //结束位置 i+k-1<n说明字符大于k个就饭庄k个，否则剩余字符不足k个全部翻转
            int end=((i+k-1)<len?(i+k-1):len-1);
            while(start<end){
                /*
                chars[start]^=chars[end];
                chars[end]^=chars[start];
                chars[start]^=chars[end];
                */
                char temp=' ';
                temp=chars[start];
                chars[start]=chars[end];
                chars[end]=temp;
                start++;
                end--;
            }
        }
        return new String(chars);
    }
    

}

```

