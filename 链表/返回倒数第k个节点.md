#### 问题：

>实现一种算法，找出单向链表中倒数第 k 个节点。返回该节点的值。
>
>示例：
>
>输入： 1->2->3->4->5 和 k = 2
>输出：4 
>
>说明：给定的 k 保证是有效的。

#### 思想

双指针(快慢指针)。

链表。

#### 题解

    定义两个指针p,q变暗均指向链表头。
    将其中一个指针q向后移动k个位置。
    然后p和q再同时向后移动直到q移到表尾，p就是倒数第k个节点。

#### 代码

```java
/**

 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
   */
   class Solution {
   public int kthToLast(ListNode head, int k) {
       ListNode p=head;
       for(int i=0;i<k;i++){
           p=p.next;
       }
       while(p!=null){
           p=p.next;
           head=head.next;
       }
       return head.val;
   }
   }
```