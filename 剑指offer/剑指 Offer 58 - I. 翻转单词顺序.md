- ### 题目
输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。

>示例 1：
>输入: "the sky is blue"
>输出: "blue is sky the"
>示例 2：
>输入: "  hello world!  "
>输出: "world! hello"
>解释: 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
>示例 3：
>输入: "a good   example"
>输出: "example good a"
>解释: 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。


>说明：
>无空格字符构成一个单词。
>输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
>如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。

- ### 思路

>- 先去除首尾空格
>- 逆序遍历字符串，i标记单词左边界，j标记单词右边界
>- 确定一个单词的左右边界加入单词列表res
>- 将单词拼接为字符串，并返回即可

```java
/*
	循环执行:
	1. 索引i从右向左搜索首个空格
	2. 添加单词[i+1,j+1)到res
	3. 索引i跳过两个单词间的所有空格
	4. 执行j=i此时j表示下一个单词的尾字符
*/
class Solution {
    public String reverseWords(String s) {
        //去除首尾空格
        s.trim();
        //i用于标识单词首
        int i=s.length()-1;
        //j用于标识单词尾
        int j=i;
        //结果集
        StringBuilder res=new StringBuilder();
        //逆序遍历
        while(i>=0){
            //i搜索首个空格
            while(i>=0&&s.charAt(i)!=' '){
                i--;
            }
            //单词加入结果集和一个空格  s.subString(i+1,j+1)属于左闭右开切割字符串并返回
            res.append(s.substring(i+1,j+1)+" ");

            //i跳过两个单词的所有空格找下一个单词的尾
            while(i>=0&&s.charAt(i)==' '){
                i--;
            }
            j=i;

        }
        //拼接的结果集尾有空格要去除
        return res.toString().trim();
    }
}
```

- ### 复杂度
>**时间复杂度:** O(n)	n为字符春的长度
>**空间复杂度:** O(n)StringBuilder中的字符串总长度为n