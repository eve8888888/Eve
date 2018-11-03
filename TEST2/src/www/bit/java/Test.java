package www.bit.java;
//饿汉式单例_先new为敬
//class Singleton{
//    private static final Singleton SINGLETON = new Singleton();//类内部实例化一个对象
//    private Singleton(){}//构造方法私有化
//    public static Singleton getSingleton(){//通过get方法返回
//        return SINGLETON;
//    }
//    public void test(){
//        System.out.println("This is singleton" + this);
//    }
//}

//懒汉式单例——用时再new
//class Singleton{
//    private static  Singleton SINGLETON ;//类内部实例化一个对象
//    private Singleton(){}//构造方法私有化
//    public static Singleton getSingleton(){//通过get方法返回
//        //延迟加载
//        if(SINGLETON == null){
//            SINGLETON = new Singleton();
//        }
//        return SINGLETON;
//    }
//    public void test(){
//        System.out.println("This is singleton" + this);
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        Singleton singleton = Singleton.getSingleton();
//        singleton.test();
//    }
//}



public class Test{
    public static void main(String[] args) {
        int[] a = {1,2,3,4,5,6,7,8};
        //System.out.println(twoSum(a,15));
        for (int var :
                twoSum(a, 15)) {
            System.out.println(var);
        }
    }
    public static int[] twoSum(int[] nums, int target) {
        for(int i =0;i<nums.length;i++){
            for(int j = i;j<nums.length;j++){
                if(nums[j] == target - nums[i])
                    return new int[]{i,j};
            }
        }
        return new int[]{};
    }
}


//class Test{
//    public static void main(String[] args) {
//        //System.out.println(tao(9));
//        int sum = 1;
//        for (int i = 9;i>0;i--){
//            sum = (sum+1) * 2;
//        }
//        System.out.println(sum);
//    }
//
//    public static int tao(int day){
//        if(day == 1){
//            return 1;
//        }
//        else {
//            return 2 * (tao(day - 1)+1);
//        }
//    }
//}






