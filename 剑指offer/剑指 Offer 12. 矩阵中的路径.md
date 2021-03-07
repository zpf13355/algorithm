### 题目

请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。

[["a","b","c","e"],
["s","f","c","s"],
["a","d","e","e"]]

但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。

 

示例 1：

输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true
示例 2：

输入：board = [["a","b"],["c","d"]], word = "abcd"
输出：false

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 代码

```java
class Solution {
    public boolean exist(char[][] board, String word) {
        //字符串word转数组
        char[] words=word.toCharArray();
        //所有可能性起点
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[i].length;j++){
                if(dfs(board,words,i,j,0)){
                    return true;
                }
            }
        }
        return false;
    }
    /*
    i表示行
    j表示列
    index当前查找word字符串的索引
    board[i][j]!=words[index]说明当前字符与矩阵中的字符不匹配此路不通(路径肯定是连续的,不会中断)
    */
    private boolean dfs(char[][] board,char[] words,int i,int j,int index){
        //递归终止
        if(i<0||i>=board.length||j<0||j>=board[0].length||board[i][j]!=words[index]){
            return false;
        }

        //查找正确 index等于待查字符串word的长度
        if(index==words.length-1){
            return true;
        }
        //标志已经使用过
        board[i][j]='\0';
        //递归：上下左右
        boolean res=dfs(board,words,i-1,j,index+1)||dfs(board,words,i+1,j,index+1)||dfs(board,words,i,j-1,index+1)||dfs(board,words,i,j+1,index+1);
        //回溯还原
        board[i][j]=words[index];
        return res;
    }
}
```

