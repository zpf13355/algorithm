### 题目描述

输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

 示例 1：

输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]
示例 2：

输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/shun-shi-zhen-da-yin-ju-zhen-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 思路

1. 空值处理： 当 matrix 为空时，直接返回空列表 [] 即可。
2. 初始化： 矩阵 左、右、上、下 四个边界 l , r , t , b ，用于打印的结果列表 res 。
3. 循环打印： “从左向右、从上向下、从右向左、从下向上” 四个方向循环，每个方向打印中做以下三件事 （各方向的具体信息见下表） ；
4. 根据边界打印，即将元素按顺序添加至列表 res 尾部；
   边界向内收缩 11 （代表已被打印）；
   判断是否打印完毕（边界是否相遇），若打印完毕则跳出。
5. 返回值： 返回 res 即可。

### 图解

![QQ截图20210203204908](C:\Users\Administrator\Desktop\QQ截图20210203204908.png)

![QQ截图20210203204936](C:\Users\Administrator\Desktop\QQ截图20210203204936.png)





### 代码

```java
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        //空数组
        if(matrix.length==0){
            return new int[0];
        }
        //行数
        int row=matrix.length;
        //列数
        int col=matrix[0].length;
        //上下左右边界
        //l,r也是左右列的边界
        int l=0;
        int r=col-1;
        //t,b也是上下行的边界
        int t=0;
        int b=row-1;
        //结果集
        int[] res=new int[row*col];
        //结果集下标
        int index=0;
        while(true){
            //从左向右打印
            for(int i=l;i<=r;i++){
                res[index++]=matrix[t][i];
            }
            if(++t>b){
                break;
            }
            //从上向下打印
            for(int i=t;i<=b;i++){
                res[index++]=matrix[i][r];
            }
            if(l>--r){
                break;
            }
            for(int i=r;i>=l;i--){
                res[index++]=matrix[b][i];
            }
            if(t>--b){
                break;
            }
            for(int i=b;i>=t;i--){
                res[index++]=matrix[i][l];
            }
            if(++l>r){
                break;
            }
        }
        return res;
    }
}
```



