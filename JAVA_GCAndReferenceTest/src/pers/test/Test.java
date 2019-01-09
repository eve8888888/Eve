package pers.test;

import java.lang.ref.PhantomReference;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

/**
 * @Author: Eve
 * @Date: 2019/1/5 11:40
 * @Version 1.0
 */
public class Test {
    private static int _1MB = 1024 * 1024;
    private byte[] bytes = new byte[2 * _1MB];
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
//        Test test = new Test();
//        WeakReference weakReference = new WeakReference(test);
//        //SoftReference softReference = new SoftReference(test);
//        test = null;
//        System.gc();

    }
}
