### 题目

字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。

 

示例 1：

输入: s = "abcdefg", k = 2
输出: "cdefgab"
示例 2：

输入: s = "lrloseumgh", k = 6
输出: "umghlrlose"

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 接口调用

```java
class Solution {
    public String reverseLeftWords(String s, int n) {
        return s.substring(n, s.length()) + s.substring(0, n);
    }
}
```

### 字符串翻转

```java
class Solution {
    public static String reverseLeftWords(String s, int n) {
        //前半部分逆置
        String s1=reverse(s,0,n-1);
//        //后半部分逆置
     String s2=reverse(s1,n,s.length()-1);
//        //整体逆置
String s3=reverse(s2,0,s.length()-1);
        return s3;
    }

    //字符串逆置
    private static String reverse(String s,int begin,int end){
        char[] arr=s.toCharArray();
        while(begin<end){
            char temp=arr[begin];
            arr[begin]=arr[end];
            arr[end]=temp;
            begin++;
            end--;
        }
        
        StringBuilder str = new StringBuilder();
        for (char sc : arr) {
            str.append(sc);
        }
        //s=str.toString()字符串常量就是不可修改量 写法就是错误的
        return str.toString();

    }
}
```

