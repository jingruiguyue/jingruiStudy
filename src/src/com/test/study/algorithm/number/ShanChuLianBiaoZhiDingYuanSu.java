package src.com.test.study.algorithm.number;

/**
 * 删除链表倒数的指定元素，并返回头结点
 */
public class ShanChuLianBiaoZhiDingYuanSu {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        int length = getLength(head);
        ListNode cur = dummy;
        for (int i = 1; i < length - n + 1; ++i) {
            cur = cur.next;
        }
        cur.next = cur.next.next;
        ListNode ans = dummy.next;
        return ans;
    }

    public int getLength(ListNode head) {
        int length = 0;
        while (head != null) {
            ++length;
            head = head.next;
        }
        return length;
    }
    class ListNode{
        ListNode next;
        int val;
        ListNode(int val, ListNode next){
            this.val = val;
            this.next = next;
        }
    }
}
