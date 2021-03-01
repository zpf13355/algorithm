### 题目

输入一个字符串，打印出该字符串中字符的所有排列。

 

你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。

 

示例:

输入：s = "abc"
输出：["abc","acb","bac","bca","cab","cba"]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/zi-fu-chuan-de-pai-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 代码

```java
class Solution {
    public String[] permutation(String s) {
        int n=s.length();
        if(n==0){
            return new String[0];
        }
        //字符串转数组
        char[] schar=s.toCharArray();
        //结果集
        Deque<String> res=new LinkedList<>();
        //组合集
        StringBuilder path=new StringBuilder();
        
        boolean[] used=new boolean[n];

        Arrays.sort(schar);
        //深度优先搜索
        dfs(res,path,schar,used);

        return res.toArray(new String[res.size()]);

        
    }

    private void dfs(Deque<String> res,StringBuilder path,char[] schar,boolean[] used){
        //递归结束
        if(schar.length==path.length()){
            res.add(path.toString());
            return;
        }

        //循环
        for(int i=0;i<schar.length;i++){
           
            //上下层不能重复
            if(used[i]){
                continue;
            }

            //同层组合元素只能使用一次
            if(i>0&&schar[i]==schar[i-1]&&used[i-1]){
                continue;
            }

            path.append(schar[i]);
            used[i]=true;
            dfs(res,path,schar,used);
            path.deleteCharAt(path.length()-1);
            used[i]=false;
        }
    }
}
```

