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
    LinkImpl(){
        head = null;
        last = null;
        size = 0;
    }
    class Node{
        private Object data;
        private Node prev;
        private Node next;
        public Node(Node prev,Object data,Node next){
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
        return false;
    }

    @Override
    public void set(int index, Object obj) {
        if(isIndex(index)) {
            Node temp = this.node(index);
            temp.data = obj;
        }
    }

    @Override
    public Object get(int index) {
        if(isIndex(index)) {
            return this.node(index).data;
        }
        return 0;
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
                System.out.println(temp);
            }
        }
    }

    /**
     * 获取指定位置的结点
     * @param index 指定位置
     * @return 结点
     */
    public Node node(int index){
        Node temp = head;
        for (int i =0;i<index;i++){
            temp = temp.next;
        }
        return temp;
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
            System.out.println("输入不合法");
        return false;
    }
}
class Test{
    public static void main(String[] args) {
        ILink Link = Factory.factory();
        Link.add("1");
        Link.add("2");
        Link.add("3");
        Link.add(null);
        Link.add("4");
        Link.clear();
        //Link.set(1,"hhhh");
        Link.printLink();
        //System.out.println(Link.size());

        //System.out.println(Link.contains(null));
    }
}