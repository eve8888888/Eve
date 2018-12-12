package pers;

import javafx.scene.effect.SepiaTone;

import java.io.*;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Author: Eve
 * @Date: 2018/12/9 10:11
 * @Version 1.0
 */

class PrintUtil{
    private OutputStream out;
    public PrintUtil(OutputStream out){
        this.out = out;

    }
    public void print(String str){
        try {
            this.out.write(str.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void println(String str){
        this.print(str + "\r\n");
    }
    public void print(int data){
        this.print(String.valueOf(data));
    }
}
public class Test {
    public static void main(String[] args) throws Exception {
        String sourceFilePath =
                "C:\\Users\\Eve\\Documents\\Tencent Files\\617222911\\FileRecv\\www.sc115.com-ppt4057.pptx";
        String destFilePath = "C:\\Users\\Eve\\Desktop\\new.pptx";
        //copyFile(sourceFilePath, destFilePath);
        Set<String> s = new TreeSet<>();
        s.add("A");
        s.add("B");
        s.add("C");
        System.out.println(s.toString());
    }
    public static void copyFile(String sourceFilePath,String destFilePath) throws Exception{
        File sourceFile = new File(sourceFilePath);
        File destFile = new File(destFilePath);
        OutputStream out = new FileOutputStream(destFile);
        InputStream in = new FileInputStream(sourceFile);
        int len = 0;
        byte[] data = new byte[1024 * 4];
        long start = System.currentTimeMillis();
        while ((len = in.read(data)) != -1){
            out.write(data,0,len);
        }
        long end = System.currentTimeMillis();
        System.out.println("耗时"+(end - start) + "毫秒");
        in.close();
        out.close();
    }
}
