### 题目

在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

>示例 1:
>输入: 
>[
>  [1,3,1],
>  [1,5,1],
>  [4,2,1]
>]
>输出: 12
>解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物

### 思路
>- 题干:从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
>- f(i,j)为从棋盘左上角至单元格(i,j)的礼物最大累积价值，易得以下递推关系
>f(i,j)=max(f(i,j),f(i-1,j))+grid(i,j)

- 状态定义
>设动态规划矩阵 dpdp ，dp(i,j)dp(i,j) 代表从棋盘的左上角开始，到达单元格 (i,j)(i,j) 时能拿到礼物的最大累计价值。
- 转移方程
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210327201033523.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1NjMwNzEx,size_16,color_FFFFFF,t_70#pic_center)
- 初始状态
>dp[0][0]=grid[0][0] ，即到达单元格 (0,0)(0,0) 时能拿到礼物的最大累计价值为 grid[0][0]grid[0][0] ；

- 返回值
>dp[m-1][n-1]dp[m−1][n−1] ，m, nm,n 分别为矩阵的行高和列宽，即返回 dpdp 矩阵右下角元素。

```java
class Solution {
    public int maxValue(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //i==0且j==0 初始值
                if(i==0&&j==0){
                    continue;
                }
                
                if(i==0){
                    //i==0 j!=0 只能从上到达
                    grid[i][j]+=grid[i][j-1];
                }else if(j==0){
                     //i!=0 j==0 只能从左到达
                     grid[i][j]+=grid[i-1][j];
                }else{
                    //i!=0 j!=0 左 和 上 均可以
                    grid[i][j]+=Math.max(grid[i-1][j],grid[i][j-1]);
                }      
            }
        }

        return grid[m-1][n-1];
    }
}
```


### 复杂度
>**时间复杂度O(mn)**:遍历矩阵
>**空间复杂度:O(1)** 原地修改使用常数大小的额外空间。
>dp[i][j]至于dp[i-1][j],dp[i][j-1],grid[i][j]有关系直接在grid代替dp修改省去dp的额外空间空间复杂度降至O(1)