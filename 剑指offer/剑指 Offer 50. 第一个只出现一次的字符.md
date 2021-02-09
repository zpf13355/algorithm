### 题目

在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。

示例:

s = "abaccdeff"
返回 "b"

s = "" 
返回 " "

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/di-yi-ge-zhi-chu-xian-yi-ci-de-zi-fu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。



**### 解题思路**

数组比哈希快：

因为哈希表是散列表，散列表每次还需要计算哈希值，会有散列冲突，还有可能扩容。但是数组你就不会遇到这几个问题了。



**### 计数排序**

**1.** 数组下标是元素 值是元素个数

**2.** 个数为1就返回字符即可



```java
class Solution {
    public char firstUniqChar(String s) {
        int[] count = new int[122];
        char[] chars = s.toCharArray();
        for(char c : chars)
            count[c]++;
        for(char c : chars){
            if(count[c] == 1)
                return c;
        }
        return ' ';
    }
}
```

```java
class Solution {
    public char firstUniqChar(String s) {
        int[] count = new int[26];
        char[] chars = s.toCharArray();
        for(char c : chars)
            count[c-'a']++;
        for(char c : chars){
            if(count[c-'a'] == 1)
                return c;
        }
        return ' ';
    }
}
```



**### 哈希**

**1.** map统计每个字符出现的次数

**2.** 次数为1的返回对应字符即可

```java
class Solution {
    public char firstUniqChar(String s) {
        Map<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }  

        for(int i=0;i<s.length();++i){
            if(map.get(s.charAt(i))==1) return s.charAt(i);
        }
        return ' ';  
    }
}
```



