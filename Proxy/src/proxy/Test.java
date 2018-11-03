package proxy;

interface ISubject{
    void buyLipstick();
}
class realSubject implements ISubject{
    @Override
    public void buyLipstick() {
        System.out.println("买口红");
    }
}
class proxySubject implements ISubject{
    //代理需要知道真实客户
    //意思是我不知道具体的客户是谁
    //但是找我的人一定是买口红
    private ISubject realSubject;
    public proxySubject(ISubject  realSubject){
        this.realSubject = realSubject;
    }
    public void beforeBuylipstick(){
        System.out.println("取钱、排队");
    }
    public void afterBuylipstick(){
        System.out.println("送货");
    }
    @Override
    public void buyLipstick() {
        beforeBuylipstick();
        realSubject.buyLipstick();
        afterBuylipstick();
    }
}
public class Test {
    public static void main(String[] args) {
        proxySubject proxySubject = new proxySubject(new realSubject());
        proxySubject.buyLipstick();
    }
}
/**输出
 取钱、排队
 买口红
 送货
*/