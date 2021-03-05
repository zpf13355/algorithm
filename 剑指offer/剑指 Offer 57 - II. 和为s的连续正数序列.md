### 题目

输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。

序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。

 

示例 1：

输入：target = 9
输出：[[2,3,4],[4,5]]
示例 2：

输入：target = 15
输出：[[1,2,3,4,5],[4,5,6],[7,8]]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 参考

https://leetcode-cn.com/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof/solution/jian-zhi-offer-57-ii-he-wei-s-de-lian-xu-t85z/

### 代码

```java
class Solution {
    public int[][] findContinuousSequence(int target) {
        int left=1;
        int right=2;
        int s=3;
        List<int[]> list=new ArrayList<>();
        while(left<right){
            if(s==target){
                int[] res=new int[right-left+1];
                for(int k=left;k<=right;k++){
                    res[k-left]=k;
                }
                list.add(res);
            }
            //等于left也要后移一步
            if(s>=target){
                s-=left;
                left++;
            }else{
                right++;
                s+=right;
            }
        }
        return list.toArray(new int[0][]);
    }
}
```

