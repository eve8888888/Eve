package pers;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;

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
//                "Desktop"+File.separator+
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
//        File file = new File("D:\\");
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
//                if (files!=null) {
//                    for (File file1 :
//                            files) {
//                        findAllFile(file1);
//                    }
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
        PrintStream printStream = new PrintStream(file);
        printStream.print("这是打印流");
        //4.关闭流
        printStream.close();
        InputStream in = new FileInputStream(file);
        byte[] b = new byte[1024];
        while (in.read(b) != -1){
            System.out.print(new String(b));
        }
        in.close();
        file.delete();
    }
}
//public class Test {
//    public static void main(String[] args) throws Exception{
//        //1.取得终端对象
//        File file = new File("C:"+File.separator+"Users"+File.separator+"Eve"+File.separator
//                +"Desktop"+File.separator+"test.txt");
//        //2.取得指定文件的输出流
//        Writer writer = new FileWriter(file);
//        Writer writer1 = new OutputStreamWriter(new FileOutputStream(file));
//        String str = "字符输出流";
//        //3.进行数据输出
//        writer.write(str);
//        //4.关闭流
//        writer.close();
//        Reader reader = new FileReader(file);
//        char[] c = new char[1];
//        while (reader.read(c) != -1){
//            System.out.print(c);
//        }
//        reader.close();
//        file.delete();
//    }
//}
//public class Test {
//    public static void main(String[] args) throws Exception{
//        String str = "HELLO　WORLD";
//        InputStream in = new ByteArrayInputStream(str.getBytes());
//        OutputStream out = new ByteArrayOutputStream();
//        int temp = 0;
//        while ((temp = in.read())!=-1){
//            out.write(Character.toLowerCase(temp));
//        }
//        System.out.println(out);
//    }
//}