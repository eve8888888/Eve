package link_two_number;

public class Test {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(9);
        ListNode n3 = new ListNode(3);
//        n1.next = n2;
//        n2.next = n3;
        ListNode k = Solution.addTwoNumbers(n2,n2);
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
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}


//class Solution {
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode head = new ListNode(0);
//        int jinwei =0;
//        ListNode newNode;
//        while(l1!= null && l2!= null){
//            if(l1.val==0 && l2.val == 0 &&l1.next ==null &&l2.next == null){
//                newNode = new ListNode(0);
//                return newNode;
//            }
//            int temp = l1.val + l2.val;
//            if(temp > 10){
//                jinwei = temp / 10;
//            }
//            temp = temp % 10;
//            ListNode cur = head;
//            if(temp == 0) {
//                newNode = new ListNode(temp);
//                jinwei = 1;
//            }
//            else {
//                newNode = new ListNode(temp + jinwei);
//                jinwei = 0;
//            }
//            while (cur.next != null){
//                cur = cur.next;
//            }
//            cur.next = newNode;
//            if(l1.next == null || l2.next == null) {
//                if (jinwei == 1) {
//                    newNode = new ListNode(jinwei);
//                    while (cur.next != null) {
//                        cur = cur.next;
//                    }
//                    cur.next = newNode;
//                }
//            }
//            l1 = l1.next;
//            l2 = l2.next;
//        }
//        return head.next;
//    }
//}


//class Solution {
//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        int i,j;
//        ListNode head = new ListNode(0);
//        StringBuffer str = new StringBuffer();
//        StringBuffer str2 = new StringBuffer();
//        while(l1 != null){
//            str.append(l1.val);
//            l1 = l1.next;
//        }
//        while(l2 != null){
//            str2.append(l2.val);
//            l2 = l2.next;
//        }
//        String s = new String(str);
//        String s2 = new String(str2);
//        char[] c = s.toCharArray();
//        for(i = 0,j = s.length() - 1;i < s.length() / 2; i++,j--){
//            char temp;
//            temp = c[i];
//            c[i] = c[j];
//            c[j] = temp;
//        }
//        s = new String(c);
//
//        c = s2.toCharArray();
//        for(i = 0,j = s2.length() - 1;i < s2.length() / 2; i++,j--){
//            char temp;
//            temp = c[i];
//            c[i] = c[j];
//            c[j] = temp;
//        }
//        s2 = new String(c);
//        int sum = Integer.parseInt(s) + Integer.parseInt(s2);
//        System.out.println(sum);
//        ListNode n = new ListNode(0);
//        while (sum >= 1){
//            ListNode cur = n;
//            int re = (sum % 10);
//            ListNode newNode = new ListNode(re);
//            while (cur.next != null){
//                cur = cur.next;
//            }
//            cur.next = newNode;
//            sum = sum / 10;
//        }
//        return n.next;
//    }
//}
