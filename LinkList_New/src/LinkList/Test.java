package LinkList;

class Factory{
    public static LinkImpl factory(){
        return new LinkImpl();
    }
}
/**
 * 定义行为
 */
interface ILink{
    void add(Object obj);

    /**
     * 修改指定位置结点内容
     * @param obj
     * @return
     */
    boolean remove(Object obj);
    /**
     * 修改指定位置结点内容
     * @param index 指定结点位置
     * @param newData 变更后的结点内容
     * @return 修改前结点内容
     */
    void set(int index,Object newData);

    /**
     * 获取指定位置结点内容
     * @param index 指定结点位置
     * @return 结点内容
     */
    Object get(int index);

    /**
     * 判断指定内容是否在链表中存在
     * @param data 指定内容
     * @return -1表示不存在；1表示存在
     */
    int contains(Object data);

    /**
     * 获取链表长度
     * @return
     */
    int size();

    /**
     * 清空链表
     */
    void clear();

    /**
     * 将链表转为数组
     * @return 对象数组
     */
    Object[] toArray();

    /**
     * 打印链表
     */
    void printLink();
}

class LinkImpl implements ILink{
    private Node head;
    private Node last;
    private int size;

    private class Node{
        private Object data;
        private Node prev;
        private Node next;
        private Node(Node prev,Object data,Node next){
            this.data = data;
            this.next = next;
            this.prev = prev;
        }
    }
    @Override
    public void add(Object obj) {
        Node temp = this.last;
        Node newNode = new Node(temp,obj,null);
        this.last = newNode;
        if(this.head == null) {
            this.head = newNode;
        }else {
            temp.next = newNode;
        }
        this.size++;
    }

    @Override
    public boolean remove(Object obj) {
        if(this.contains(obj) != -1){
            Node temp = this.node(this.contains(obj));
            Node prev = temp.prev;
            Node next = temp.next;
            if (prev == null) {
                this.head = next;
            }else {
                prev.next = next;
                temp.prev = null;
            }
            if (next == null) {
                this.last = prev;
            }else {
                next.prev = prev;
                temp.next = null;
            }
            temp.data = null;
            this.size--;
        }
        return false;
    }

    @Override
    public void set(int index, Object obj) {
        if(isIndex(index)) {
            Node temp = this.node(index);
            temp.data = obj;
        }
        else
            System.out.println("输入不合法");
    }

    @Override
    public Object get(int index) {
        if(isIndex(index)) {
            return this.node(index).data;
        }
        return "输入不合法";
    }

    @Override
    public int contains(Object data) {
        int i =0;
        Node temp = head;
        if(data == null){
            while (temp != null){
                if(temp.data == null){
                    return i;
                }
                temp = temp.next;
                i++;
            }
        }
        else {
            while (temp != null){
                if(data.equals(temp.data)){
                    return i;
                }
                temp = temp.next;
                i++;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public void clear() {
        Node temp = head;
        while (temp != null){
            Node nexttemp = temp.next;
            temp.prev = temp = temp.next = null;
            temp = nexttemp;
            this.size--;
        }
    }

    @Override
    public Object[] toArray() {
        if(size == 0){
            System.out.println("链表为空");
        }
        else {
            Object[] result = new Object[size];
            int i = 0;
            Node temp = head;
            while (temp != null) {
                result[i] = temp.data;
                temp = temp.next;
                i++;
            }
            return result;
        }
        return null;
    }

    @Override
    public void printLink() {
        Object[] result = this.toArray();
        if(result != null) {
            for (Object temp :
                    result) {
                System.out.print(temp + ",");
            }
        }
        System.out.println();
    }

    /**
     * 获取指定位置的结点
     * @param index 指定位置
     * @return 结点
     */
    public Node node(int index){
        if(index < (this.size >> 1)){
            Node temp = head;
            for (int i =0;i<index;i++){
                temp = temp.next;
            }
            return temp;
        }else {
            Node temp =  last;
            for(int i = this.size - index - 1; i > 0; i--){
                temp = temp.prev;
            }
            return temp;
        }

    }

    /**
     * 判断指定位置是否合法
     * @param index
     * @return
     */
    boolean isIndex(int index){
        if(index>=0 && index < size)
            return true;
        else
            return false;
    }
}
class Test{
    public static void main(String[] args) {
        ILink Link = Factory.factory();
        Link.add("1");
        Link.add("2");
        Link.add("3");
        Link.add("4");
        Link.add(null);
        Link.add("5");
        Link.add("6");

        //Link.set(8,"777");
        //Link.clear();
        //Link.set(1,"hhhh");
        Link.remove(null);
        Link.printLink();

        //System.out.println(Link.get(6));

        //System.out.println(Link.contains(null));
    }
}