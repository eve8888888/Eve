package LinkList;

/**
 * 定义一个链表类
 * 实现头插、尾插、任意位置插入、指定位置查找
 * 指定位置删除、反转、打印、取长度操作
 */

final class Link{
    private Node head;
    Link(){
        head = new Node();
    }
    /**
     * 将结点定义为一个私有内部类
     */
    private class Node{
        int data;
        Node next;
        Node(){
            next = null;
        }
        Node(int data){
            this.data = data;
        }
    }
    /**尾插 */
    public void InsertTail(int data){
        Node n = new Node(data);
        Node cur = this.head;
        while(cur.next!=null){
            cur = cur.next;
        }
        cur.next = n;
    }
    /**头插 */
    public void InsertHead(int data){
        Node n = new Node(data);
        n.next = head.next;
        head.next = n;
    }
    /**取长度 */
    public int getLenth(){
        int count = 0;
        Node cur = head;
        while(cur.next!=null){
            cur = cur.next;
            count++;
        }
        return count;
    }
    /**制定位置插入 */
    public void Insert(int data,int position){
        Node n = new Node(data);
        Node cur = this.head;
        for(int i = 0;i<position;i++){
            cur = cur.next;
        }
        n.next = cur.next;
        cur.next = n;
    }
    /**删除指定位置结点 */
    public void del(int position){
        Node cur = this.head;
        for(int i = 0;i<position;i++){
            cur = cur.next;
        }
        cur.next = cur.next.next;
    }
    /**
     * 使用头插来反转链表
     * 将下一个节点插在前面
     * 再将后面的结点删除
     */
    public void reverse(){
        Node cur = this.head;
        int i = 0;
        while(cur.next!=null){
            this.InsertHead(cur.next.data);
            cur = cur.next;
            this.del(i);
            i++;
        }
    }
    /**
     * 迭代法进行反转
     */
    public void reverse2(){
        Node prev = null;
        Node now = head.next;
        Node next = null;
        while(now!=null){
            next = now.next;
            now.next = prev;
            prev = now;
            now = next;
        }
        head.next = prev;
    }
    /**指定位置查找 */
    public int search(int position){
        Node cur = this.head;
        for(int i = 0;i<=position;i++){
            cur = cur.next;
        }
        return cur.data;
    }
    /**打印链表 */
    public void display(){
        Node cur = this.head;
        while(cur.next!=null){
            System.out.print(cur.next.data);
            cur = cur.next;
        }
    }
}
class Test{
    public static void main(String[] args) {
        Link newLink = new Link();
        System.out.println("heool");
        newLink.InsertTail(1);
        newLink.InsertTail(2);
        newLink.InsertTail(3);
        newLink.InsertTail(4);
        newLink.InsertTail(5);
        newLink.InsertTail(6);
        newLink.InsertTail(7);
        newLink.InsertTail(8);
        newLink.display();
    }
}
