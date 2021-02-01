###### 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。

>示例1：
>输入：1->2->4, 1->3->4
>输出：1->1->2->3->4->4

- l1为空 返回l2
- l2为空 返回l1
- 定义一个哨兵节点node表示新链表的表头
- 定义一个移动节点temp串链表
- l1和l2均不为空
	- l1.val<l2.val  temp指向l1 l1后移
	- l1.val>l2.val temp指向l2   l2后移
- l1还不为空 拼接l1剩余部分 temp指向l1
- l2还不为空 拼接l2剩余部分 temp指向l2
- 返回新链表头结点 node.next
	
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }
        if(l2==null){
            return l1; 
        }
        //亚节点
        ListNode node=new ListNode(-1);
        ListNode temp=node;
        //l1,l2均不为空
        while(l1!=null&&l2!=null){
            if(l1.val<l2.val){
                temp.next=l1;
                temp=l1;
                l1=l1.next;
            }else{
                temp.next=l2;
                temp=l2;
                l2=l2.next;
            }
        }
        //l1不为空
        if(l1!=null){
            temp.next=l1;
        }
        //l2不为空
        if(l2!=null){
            temp.next=l2;
        }
        //返回表头
        return node.next;
    }
}
```