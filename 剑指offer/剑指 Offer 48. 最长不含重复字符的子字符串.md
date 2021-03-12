### 题目

请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。

 

示例 1:

输入: "abcabcbb"
输出: 3 
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:

输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:

输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 代码

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s==null){
            return 0;
        }
        Map<Character,Integer> map=new HashMap<>();

        int i=-1;

        int res=0;
        for(int j=0;j<s.length();j++){
            if(map.containsKey(s.charAt(j))){
                //跟新i值
                i=Math.max(i,map.get(s.charAt(j)));
            }

            map.put(s.charAt(j),j);
            //更新结果集
            res=Math.max(res,j-i);
        }

        return res;
    }
}
```

