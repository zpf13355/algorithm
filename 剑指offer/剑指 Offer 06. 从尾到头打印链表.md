###  题目
输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。


>示例 1：
>输入：head = [1,3,2]
>输出：[2,3,1]


### 思路
>栈的特性:先进后出
>- 入栈：遍历链表，所有节点入栈
>- 出栈:出栈就是逆序的，然后保存到一个结果数组
>- 返回结果数组

### 代码
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
    public int[] reversePrint(ListNode head) {
        Deque<Integer> stack=new LinkedList<>();
        ListNode cur=head;
        while(cur!=null){
            stack.push(cur.val);
            cur=cur.next;
        }

        int[] res=new int[stack.size()];
        for(int i=0;i<res.length;i++){
            res[i]=stack.pop();
        }
        return res;
    }
}
```
### 复杂度
>**时间复杂度O(n)**:遍历链表
>**空间复杂度O(n)**:一个n的结果数组