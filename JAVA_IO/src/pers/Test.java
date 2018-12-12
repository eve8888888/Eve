package pers;

import java.io.*;

/**
 * @Author: Eve
 * @Date: 2018/12/7 18:57
 * @Version 1.0
 */
//public class Test {
//    public static void main(String[] args) {
//        File file = new File("C:"+File.separator+"Users"
//                +File.separator+"Eve"+File.separator+
//                "Desktop"+File.separator+"www"+File.separator+"bit"+File.separator+
//                "java"+File.separator+"javaIO.java");
//        if(!file.getParentFile().exists()){
//            file.getParentFile().mkdirs();
//        }
//        if(!file.exists()){
//            try {
//                file.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }else {
//            System.out.println("文件已经存在");
//        }
//    }
//}
//public class Test{
//    static int count = 0;
//    public static void main(String[] args) {
//        File file = new File("C:"+File.separator+"Users"+File.separator
//                +"Eve"+File.separator+"Documents"+File.separator
//                +"Tencent Files"+File.separator+"617222911"+File.separator+"FileRecv");
//        new Thread(()->{
//            long start = System.currentTimeMillis();
//            findAllFile(file);
//            long end = System.currentTimeMillis();
//            System.out.println("共计"+(end - start)+"毫秒");
//            System.out.println(count);
//        }).start();
//
//    }
//    public static void findAllFile(File file){
//        if(file.isFile()){
//            System.out.println(file);
//            count++;
//        }else {
//            if(file.exists() && file.isDirectory()){
//                File[] files = file.listFiles();
//                for (File file1 :
//                        files) {
//                    findAllFile(file1);
//                }
//            }
//        }
//    }
//}
public class Test {
    public static void main(String[] args) throws Exception{
        //1.取得终端对象
        File file = new File("C:"+File.separator+"Users"+File.separator+"Eve"+File.separator
                +"Desktop"+File.separator+"test.txt");
        //2.取得指定文件的输出流
        OutputStream out = new FileOutputStream(file,true);
        String str = "字节输出流";
        String str2 = "Test";
        //3.进行数据输出
        out.write(str.getBytes());
        out.write(str2.getBytes());
        //4.关闭流
        out.close();
    }
}