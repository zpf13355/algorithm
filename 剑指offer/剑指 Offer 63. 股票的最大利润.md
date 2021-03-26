### 题目
假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？

>示例 1:
>输入: [7,1,5,3,6,4]
>输出: 5
>解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
>     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
>示例 2:
>输入: [7,6,4,3,1]
>输出: 0
>解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

### 解1-一次遍历
>- 循环遍历数组
>- 找最小价格并更新
>- 找最大利润(最大价格差)

```java
class Solution {
    public int maxProfit(int[] prices) {
        //最小价格
        int minPrice=Integer.MAX_VALUE;
        //最大利润
        int maxProfit=0;
        for(int i=0;i<prices.length;i++){
            
            if(prices[i]<minPrice){
                //找最小价格
                minPrice=prices[i];
            }else if(prices[i]-minPrice>maxProfit){
                //最大价格差-利润
                maxProfit=prices[i]-minPrice;
            }
        }

        return maxProfit;
    }
}
```

### 复杂度
>**时间复杂度O(n)**
>**空间复杂度O(1)**

### 解2-动态规划
>- 状态定义:列表dp,dp[i]为前i日的最大利润
>- 转移方程:
>![在这里插入图片描述](https://img-blog.csdnimg.cn/20210326225508486.png#pic_center)
>- 初始状态dp[0]=0，首日利润为0
>- 返回值dp[n-1]，n为列表长度

```java
class Solution {
    public int maxProfit(int[] prices) {
        //最小价格
        int minPrice=Integer.MAX_VALUE;
        //最大利润
        int maxProfit=0;
        for(int price:prices){
            minPrice=Math.min(minPrice,price);
            maxProfit=Math.max(maxProfit,price-minPrice);
        }
        return maxProfit;
    }
}
```
### 复杂度
>**时间复杂度O(n)**:遍历数组
>**空间复杂度O(1)**