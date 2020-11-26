#### 问题

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。这个链表的倒数第3个节点是值为4的节点。

 示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.

#### 类型

1.双指针(快慢指针)
2.单链表

#### 解题思路

> 1.定义两个指针fomer（快指针）和latter（慢指针），初始均指向head
> 2.快指针fomer移动k个节点，然后快指针fomer和慢指针latter同时向后遍历，直到快指针fomer到达链表尾截止
> 3.慢指针latter指向的位置就是倒数第k个节点。

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
       public ListNode getKthFromEnd(ListNode head, int k) {
           ListNode fomer=head,latter=head;
           for(int i=0;i<k;i++){
               fomer=fomer.next;
           }
           while(fomer!=null){
               fomer=fomer.next;
               latter=latter.next;
           }
           return latter;
       }
   }
```



