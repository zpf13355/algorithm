### 题目

用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )

 

示例 1：

输入：
["CQueue","appendTail","deleteHead","deleteHead"]
[[],[3],[],[]]
输出：[null,null,3,-1]
示例 2：

输入：
["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
[[],[],[5],[2],[],[]]
输出：[null,-1,null,null,5,2]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 题解

- addTail

  stack1直接入栈即可

- deleteHead

  1. stack2不为空，栈顶元素出栈即可
  2. stack2为空
     1. stack1为空返回-1即可
     2. stack1不为空，将stack1中所有的元素一次pop出来然后在push到stack2中

  

  

  - 最后Sstack2弹出栈顶元素即可

  

  



### 代码

```java
class CQueue {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    public CQueue() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }
    
    public void appendTail(int value) {
        stack1.push(value);
    }
    
    public int deleteHead() {
        if(stack2.isEmpty()){
            if(stack1.isEmpty()){
                return -1;
            }else{
                while(!stack1.isEmpty()){
                    stack2.push(stack1.pop());
                }
            }
        }
        return stack2.pop();
    }
}
```

