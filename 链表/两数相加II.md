**### 题目**

给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。



你可以假设除了数字 0 之外，这两个数字都不会以零开头。

输出：7 -> 8 -> 0 -> 7



**### 解题思路**

**1.** 定义两个栈stack1和stack2

**2.** 分别将l1和l2压入栈中

**3.** 出栈求和 carry存十位进位数用于下次求和，cur当前和，再存个位数

**4.** 头插法建立新链表



**### 图解**

*![QQ截图20210109230243.png](https://pic.leetcode-cn.com/1610204580-pNShiX-QQ%E6%88%AA%E5%9B%BE20210109230243.png)*



**### 代码**

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //定义两个栈
        Deque<Integer> stack1=new LinkedList<>();
        Deque<Integer> stack2=new LinkedList<>();
        //l1和l2分别压入栈
        while(l1!=null){
            stack1.push(l1.val);
            l1=l1.next;
        }
        while(l2!=null){
            stack2.push(l2.val);
            l2=l2.next;
        }
        //出栈计算
        //进位数
        int carry=0;
        ListNode ans=null;
        while(!stack1.isEmpty()||!stack2.isEmpty()||carry!=0){
            int a=stack1.isEmpty()?0:stack1.pop();
            int b=stack2.isEmpty()?0:stack2.pop();
            //相加
            int cur=a+b+carry;
            //十位进位值
            carry=cur/10;
            //个位
            cur%=10;
            //头插法
            ListNode curNode=new ListNode(cur);
            curNode.next=ans;
            ans=curNode;
        }
        return ans;
    }
}




```

