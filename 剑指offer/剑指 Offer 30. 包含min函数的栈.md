### 题目

定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，调用 min、push 及 pop 的时间复杂度都是 O(1)。

 

示例:

MinStack minStack = new MinStack();
minStack.push(-2);
minStack.push(0);
minStack.push(-3);
minStack.min();   --> 返回 -3.
minStack.pop();
minStack.top();      --> 返回 0.
minStack.min();   --> 返回 -2.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/bao-han-minhan-shu-de-zhan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 辅助栈

```java
class MinStack {
    Deque<Integer> stack1;
    Deque<Integer> stack2;
    /** initialize your data structure here. */
    public MinStack() {
        stack1=new LinkedList<>();
        stack2=new LinkedList<>();
    }
    
    public void push(int x) {
        stack1.push(x);
        if(stack2.isEmpty()||stack2.peek()>=x){
            stack2.push(x);
        }
    }
    
    public void pop() {
        if(stack1.pop().equals(stack2.peek())){
            stack2.pop();
        }
    }
    
    public int top() {
        return stack1.peek();
    }
    
    public int min() {
        if(!stack2.isEmpty()){
            return stack2.peek();
        }
        return 0;
        
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
```

### 单栈

```java
class MinStack {
    int min=Integer.MAX_VALUE;

    Deque<Integer> stack;
    /** initialize your data structure here. */
    public MinStack() {
        stack=new LinkedList<>();
    }
    
    public void push(int x) {
        if(x<=min){
            stack.push(min);//弹栈时对最小值进行更新
            min=x;
        }
        stack.push(x);
    }
    
    public void pop() {
        if(stack.pop()==min){
            min=stack.pop();
        }
    }
    
    public int top() {
        return stack.peek();
    }
    
    public int min() {
        return min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */
```

### 差值法

```java
public class MinStack {
    //int值非常大时作差可能会越界可能只能用long
    long min;
    Stack<Long> stack = new Stack<>();

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.push(0L);
            min = x;
        } else {
            //这里入栈的是入栈的值和最小值的差值，有可能为负，也有可能为正。
            stack.push(x - min);
            if (x < min)
                min = x;
        }
    }

    public void pop() {
        if (stack.isEmpty())
            return;
        long pop = stack.pop();
        //因为入栈的是差值，当出栈的为负数的时候，说明栈中最小值已经出栈了，
        //这里要重新更新最小值
        if (pop < 0)
            min -= pop;
    }

    public int top() {
        long top = stack.peek();
        if (top > 0) {
            //栈顶元素如果是正的，说明栈顶元素压栈的时候是比栈中最小值大的，根据
            //top=x - min，可以计算x=top+min
            return  (int)(top + min);
        } else {
            //当栈顶元素是负数的时候，说明栈顶元素压栈的时候是比栈中最小值小的，
            //而压栈完之后他会更新最小值min，所以如果在使用上面公式肯定是不行
            //的。如果栈顶元素压栈的时候比最小值小，他会更新最小值，这个最小值
            //就是我们要压栈的值，所以这里直接返回min就行了。
            return  (int)(min);
        }
    }

    public int getMin() {
        return  (int)min;
    }
}


```

