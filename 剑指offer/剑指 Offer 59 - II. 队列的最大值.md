### 题目

请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。

若队列为空，pop_front 和 max_value 需要返回 -1

示例 1：

输入: 
["MaxQueue","push_back","push_back","max_value","pop_front","max_value"]
[[],[1],[2],[],[],[]]
输出: [null,null,null,2,1,2]
示例 2：

输入: 
["MaxQueue","pop_front","max_value"]
[[],[],[]]
输出: [null,-1,-1]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 思路

1. 两个队列p,q
2. p是普通队列，q是单调递减队列
3. p正常入队出队，q入队前要先把所有小于要入队元素值依次出队保证队列的单调性

- 初始化p,q队列
-  **最大值 `max_value()`** 
  1. q为空时返回-1
  2. 否则返回q的首元素
-  **入队 `push_back()`** 
  1. value正常入p
  2. 将q中所有小于value的值出队(保证对垒的单调递减性)，然后将value入队q
-  **出队 `pop_front()`** 
  1. p为空直接返回-1
  2. p不为空出队首元素
  3. 同时比较p和q的队首元素是否相等，相等q的队首元素也出队(保持队列元素一致)



### 代码

```java
class MaxQueue {
    Deque<Integer> p;
    Deque<Integer> q;
    public MaxQueue() {
        p=new LinkedList<>();
        q=new LinkedList<>();
    }
    
    public int max_value() {
        if(q.isEmpty()){
            return -1;
        }
        return q.peekFirst();
    }
    
    public void push_back(int value) {
        while(!q.isEmpty()&&q.peekLast()<value){
            q.pollLast();   
        }
        q.offer(value);
        p.offer(value);
    }
    
    public int pop_front() {
        if(p.isEmpty()){
            return -1;
        }
        int res=p.pollFirst();
        if(res==q.peekFirst()){
            q.pollFirst();
        }
        return res;
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
```

