package link_two_number;

public class Test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(4);
        ListNode n3 = new ListNode(3);
        n1.next = n2;
        n2.next = n3;
        ListNode k = Solution.addTwoNumbers(n1,n1);
        while (k != null){
            System.out.println(k.val);
            k = k.next;
        }
    }
}

  //Definition for singly-linked list.
  class ListNode {
      int val;
      ListNode next;
     ListNode(int x) { val = x; }
}

class Solution {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int i,j;
        ListNode head = new ListNode(0);
        StringBuffer str = new StringBuffer();
        StringBuffer str2 = new StringBuffer();
        while(l1 != null){
            str.append(l1.val);
            l1 = l1.next;
        }
        while(l2 != null){
            str2.append(l2.val);
            l2 = l2.next;
        }
        String s = new String(str);
        String s2 = new String(str2);
        char[] c = s.toCharArray();
        for(i = 0,j = s.length() - 1;i < s.length() / 2; i++,j--){
            char temp;
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        s = new String(c);

        c = s2.toCharArray();
        for(i = 0,j = s2.length() - 1;i < s2.length() / 2; i++,j--){
            char temp;
            temp = c[i];
            c[i] = c[j];
            c[j] = temp;
        }
        s2 = new String(c);
        int sum = Integer.parseInt(s) + Integer.parseInt(s2);
        System.out.println(sum);
        ListNode n = new ListNode(0);
        while (sum >= 1){
            ListNode cur = n;
            int re = (sum % 10);
            ListNode newNode = new ListNode(re);
            while (cur.next != null){
                cur = cur.next;
            }
            cur.next = newNode;
            sum = sum / 10;
        }
        return n.next;
    }
}
