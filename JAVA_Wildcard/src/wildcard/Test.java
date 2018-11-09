package wildcard;

/**
 * @Author: Eve
 * @Date: 2018/11/9 15:24
 * @Version 1.0
 */
class Message<T> {
    private T message ;
    public T getMessage() {
        return message;
    }
    public void setMessage(T message) {
        this.message = message;
    }
}
public class Test {
    public static void main(String[] args) {
        Message<String> message = new Message<>() ;
        message.setMessage("HELLO");
        fun(message);
    }
    public static void fun(Message<? super String> temp){
        temp.setMessage("hh");
        System.out.println(temp.getMessage());
    }
}

class myClass<T extends Number>{

}