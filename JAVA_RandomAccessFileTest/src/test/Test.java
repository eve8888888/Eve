package test;

import java.io.FileNotFoundException;
import java.io.RandomAccessFile;

/**
 * @Author: Eve
 * @Date: 2018/11/21 15:00
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        modify();
    }
    public static void modify(){
        RandomAccessFile raf = null;
        try {
            raf = new RandomAccessFile("test.txt","rw");
            String line = null;
            long lastpoint = 1;
            while ((line = raf.readLine())!=null){
                final long point = raf.getFilePointer();
                if(line.contains("123456")){
                    String str = line.replace("23","ab");
                    raf.seek(lastpoint);
                    raf.writeBytes(str);
                }
                lastpoint = point;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                raf.close();
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}
