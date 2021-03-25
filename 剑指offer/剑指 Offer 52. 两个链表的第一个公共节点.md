### 题目
输入两个链表，找出它们的第一个公共节点。

如下面的两个链表：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210325194518690.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1NjMwNzEx,size_16,color_FFFFFF,t_70#pic_center)

在节点 c1 开始相交。


示例 1：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210325194530971.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1NjMwNzEx,size_16,color_FFFFFF,t_70#pic_center)
输入：intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
输出：Reference of the node with value = 8
输入解释：相交节点的值为 8 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [4,1,8,4,5]，链表 B 为 [5,0,1,8,4,5]。在 A 中，相交节点前有 2 个节点；在 B 中，相交节点前有 3 个节点。


示例 2：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210325194542950.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1NjMwNzEx,size_16,color_FFFFFF,t_70#pic_center)

输入：intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
输出：Reference of the node with value = 2
输入解释：相交节点的值为 2 （注意，如果两个列表相交则不能为 0）。从各自的表头开始算起，链表 A 为 [0,9,1,2,4]，链表 B 为 [3,2,4]。在 A 中，相交节点前有 3 个节点；在 B 中，相交节点前有 1 个节点。


示例 3：
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210325194551392.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1NjMwNzEx,size_16,color_FFFFFF,t_70#pic_center)


输入：intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
输出：null
输入解释：从各自的表头开始算起，链表 A 为 [2,6,4]，链表 B 为 [1,5]。由于这两个链表不相交，所以 intersectVal 必须为 0，而 skipA 和 skipB 可以是任意值。
解释：这两个链表不相交，因此返回 null。

注意：
如果两个链表没有交点，返回 null.
在返回结果后，两个链表仍须保持原有的结构。
可假定整个链表结构中没有循环。
程序尽量满足 O(n) 时间复杂度，且仅用 O(1) 内存。

### 思路
![在这里插入图片描述](https://img-blog.csdnimg.cn/20210325194609736.png?x-oss-process=image/watermark,type_ZmFuZ3poZW5naGVpdGk,shadow_10,text_aHR0cHM6Ly9ibG9nLmNzZG4ubmV0L3FxXzQ1NjMwNzEx,size_16,color_FFFFFF,t_70#pic_center)
>- headA到第一个公共节点前， 共a-c个节点
>- headB到第一个公共节点前，共b-c个节点
>- 两个指针A，B分别指向headA,和headB的头结点
> 1. A遍历完headA然后在走a-c个节点到达第一个公共节点
>  2. B遍历完headB然后走b-c个节点到达第一个公共节点
>  3. 等式(a-c)+b=(b-c)+a成立A。B指针重合
>        1.  若两链表 有 公共尾部 (即 c > 0 ) ：指针 A , B 同时指向「第一个公共节点。
>        2. 若两链表 无 公共尾部 (即 c = 0c=0 ) ：指针 A , B 同时指向 null

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode A=headA;
        ListNode B=headB;
        while(A!=B){
            A=A!=null?A.next:headB;
            B=B!=null?B.next:headA;
        }

        return A;
    }
}
```

### 复杂度
>**时间复杂度O(a+b)**:a.b分别为headA和headB链表的节点个数
>**空间复杂度O(1)**:A,B都是常数阶