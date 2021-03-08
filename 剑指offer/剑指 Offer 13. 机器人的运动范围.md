### 题目

地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

 

示例 1：

输入：m = 2, n = 3, k = 1
输出：3
示例 2：

输入：m = 3, n = 1, k = 0
输出：1

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### dfs

```java
class Solution {
    public int movingCount(int m, int n, int k) {
        //标记访问过
        boolean[][] used=new boolean[m][n];

        return dfs(m,n,k,used,0,0);
    }

    private int dfs(int m,int n,int k,boolean[][] used,int x,int y){
        if(x<0||x>=m||y<0||y>=n||(get(x)+get(y))>k||used[x][y]){
            return 0;
        }

        used[x][y]=true;
        //1表示(0,0)

        //return 1+dfs(m,n,k,used,x-1,y)+dfs(m,n,k,used,x+1,y)+dfs(m,n,k,used,x,y-1)+dfs(m,n,k,used,x,y+1);
        //优化:因为上左是经过的可以不考虑
        return 1+dfs(m,n,k,used,x,y+1)+dfs(m,n,k,used,x+1,y);
    } 

    //计算坐标各位数之和
    private int get(int num){
        int res=0;
        while(num>0){
            res+=(num%10);
            num/=10;
        }
        return res;
    }
}
```

### BFS

```java
class Solution {
    public int movingCount(int m, int n, int k) {
        Deque<int[]> queue=new LinkedList<>();
        boolean[][] used=new boolean[m][n];
        int res=0;
        //第一个元素加入
        queue.add(new int[]{0,0});

        while(queue.size()>0){
            //出栈
            int[] tmp=queue.poll();

            int x=tmp[0];
            int y=tmp[1];
            //判断
            if(x<0||x>=m||y<0||y>=n||used[x][y]||(get(x)+get(y))>k){
                continue;
            }
            //标记格子已经访问过
            used[x][y]=true;
            //满足结果格子数加1
            res++;
            //右边加入
            queue.add(new int[]{x,y+1});
            //下边加入
            queue.add(new int[]{x+1,y});
        }
        return res;
    } 
    //计算坐标各位数之和
    private int get(int num){
        int res=0;
        while(num!=0){
            res+=(num%10);
            num/=10;
        }
        return res;
    }
}
```

