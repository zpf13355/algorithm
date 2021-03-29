### 题目
地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？

>示例 1：
>输入：m = 2, n = 3, k = 1
>输出：3
>示例 2：
>输入：m = 3, n = 1, k = 0
>输出：1

### 题解1-dfs
>- 递归参数：标记数组，m,n,k,坐标x,y
>- 终止条件：x,y越界，元素访问过，坐标之和大于k
>- 递推：
>	   1.  标记当前单元格：used[x][y]=true
>    	2. 搜索下一单元格：递归下，右两个方向
>- 返回值：1(0,0)+作坊搜索可达数+下方搜索可达数

```java
class Solution {
    public int movingCount(int m, int n, int k) {
        boolean[][] used=new boolean[m][n];
        return dfs(used,m,n,k,0,0);
    }

    public int dfs(boolean[][] used,int m,int n,int k,int x,int y){
        //递归终止
        if(x<0||x>=m||y<0||y>=n||used[x][y]||getSum(x)+getSum(y)>k){
            return 0;
        }
        //标志使用过
        used[x][y]=true;
		//朝一个方向递归完想另一个方向回溯
        return 1+dfs(used,m,n,k,x+1,y)+dfs(used,m,n,k,x,y+1);

    }
    public int getSum(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n/=10;
        }
        return sum;
    }
}
```
### 复杂度
>**时间复杂度O(mn)**: 最差遍历完所有矩阵
>**空间复杂度O(mn)**： used存储所有单元格

### 解2-BFS
>- 初始化：队列，标记数组，(0,0)加入队列
>- 迭代终止：队列为空
>- 迭代：
>    1. 单元格出队
>    2. 获取单元格的行和列值
>    3. 判断是否跳过：x,y越界，单元格使用过，下标之和大于k
>    4. 标记当前单元格
>    5. 结果自增
>    6. 当前大圆哥的下，右方单元格下标构造加入队列
>- 返回值：就是结果

```java
class Solution {
    public int movingCount(int m, int n, int k) {
        Deque<int[]> queue=new LinkedList<>();
        boolean[][] used=new boolean[m][n];
        int res=0;
        queue.add(new int[]{0,0});
        
        while(!queue.isEmpty()){
            int[] tmp=queue.remove();

            int x=tmp[0];
            int y=tmp[1];
            if(x<0||x>=m||y<0||y>=n||used[x][y]||getSum(x)+getSum(y)>k){
                continue;
            }
            used[x][y]=true;

            res++;
            //右走
            queue.add(new int[]{x+1,y});
            //下走
            queue.add(new int[]{x,y+1});

            
        }
        return res;
    }

    //求坐标和
    public int getSum(int n){
        int sum=0;
        while(n>0){
            sum+=(n%10);
            n=n/10;
        }
        return sum;
    }
}
```

### 复杂度
>**时间复杂度O(mn)**: 最差遍历完所有矩阵
>**空间复杂度O(mn)**： used存储所有单元格