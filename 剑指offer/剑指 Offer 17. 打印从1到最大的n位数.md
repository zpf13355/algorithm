### 题目

输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。

示例 1:

输入: n = 1
输出: [1,2,3,4,5,6,7,8,9]


说明：

用返回一个整数列表来代替打印
n 为正整数

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 参考

https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/solution/jian-zhi-offerer-shua-zi-fu-chuan-mo-ni-fdq0d/

### 代码

```java
class Solution {
    public int[] printNumbers(int n) {
        List<Integer> list=new ArrayList<>();
        StringBuilder path=new StringBuilder();
        dfs(list,path,0,n);

        int[] res=new int[list.size()];
        //list转数组
        for(int i=0;i<list.size();i++){
            res[i]=list.get(i);
        }
        return res;
    }

    private void dfs(List<Integer> list,StringBuilder path,int index,int n){
        //递归终止
        if(index==n){
            //取出字符串左边多余0
            while(path.length()!=0&&path.charAt(0)=='0'){
                path.deleteCharAt(0);
            }
            //加入结果集
            if(path.length()!=0){
                list.add(Integer.valueOf(path.toString()));
            }
            return;
        }
        //循环
        for(int i=0;i<10;i++){
            path.append(i);
            dfs(list,path,index+1,n);
            //回溯
            if(path.length()!=0){
                path.deleteCharAt(path.length()-1);
            }
        }
    }
}
```

