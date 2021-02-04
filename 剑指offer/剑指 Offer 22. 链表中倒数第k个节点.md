### 题目

输入一个链表，输出该链表中倒数第k个节点。为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。

例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 2 个节点是值为 4 的节点。

 

示例：

给定一个链表: 1->2->3->4->5, 和 k = 2.

返回链表 4->5.

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/lian-biao-zhong-dao-shu-di-kge-jie-dian-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

### 思路

1. 定义两个快慢指针，slow为慢指针，fast为快指针
2. 让fast先后移k个步长(或者fast后统一k-1个步长)
3. slow和fast同时后移，直到fast==null结束(或者fast.next==null结束)
4. slow指向的节点就是倒数第k个节点

### 图解

*![链表1.png](https://pic.leetcode-cn.com/1609545461-ldSijv-%E9%93%BE%E8%A1%A81.png)*

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
    public int kthToLast(ListNode head, int k) {
/*
       ListNode fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while(fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
*/
        if(head==null){
            return 0;
        }
        ListNode slow=head;
        ListNode fast=head;
        for(int i=0;i<k;i++){
            fast=fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast=fast.next;
        }
        return slow.val;
    }

}
```



### 细节版-推荐

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
    public ListNode getKthFromEnd(ListNode head, int k) {
        //不写是可以的
    if(head == null || k <= 0) {
        return null;
    }

    ListNode fast = head;
    ListNode slow = head;
    while(k-1 != 0) {
        //每次走之前 判断当前fast是不是已经到尾巴节点了
        if(fast.next != null) {
            fast = fast.next;
            k--;
        }else{
            return null;//代表k的值过大超过链表的长度
        }
    }

    while(fast.next != null) {
        slow = slow.next;
        fast = fast.next;
    }
    return slow;
    }
}


```





