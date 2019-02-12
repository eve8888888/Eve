package pers.test;

import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;

import java.util.Arrays;

/**
 * @Author: Eve
 * @Date: 2019/2/12 14:08
 * @Version 1.0
 */
class Swap{
    public static void swap(int[] a,int i,int j){
        if(a[i] != a[j]){
            a[i] ^= a[j];
            a[j] ^= a[i];
            a[i] ^= a[j];
        }else {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }
}
class BubbleSort{
    public static void sort(int[] demo){
        for (int i = 0; i < demo.length; i++) {
            for (int j = 0; j < demo.length - i - 1; j++) {
                if (demo[j] > demo[j+1]){
                    Swap.swap(demo,j,j + 1);
                }
            }
        }
    }
}

class BubbleSort2{
    public static void sort(int[] demo){
        int left = 0, right = demo.length - 1;
        while (left < right){
            for (int i = left; i < right; i++) {
                if(demo[i] > demo[i+1]){
                    Swap.swap(demo,i,i+1);
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if(demo[i] < demo[i-1]){
                    Swap.swap(demo,i,i-1);
                }
            }
            left++;
        }
    }
}

class SelectSort{
    public static void sort(int[] demo){
        int k = 0;
        while (k < demo.length){
            int min = k;
            for (int i = k+1; i < demo.length; i++) {
                if(demo[i] < demo[min]){
                    min = i;
                }
            }
            if(min != k){
                Swap.swap(demo,min,k);
            }
            k++;
        }
    }
}
class SelectSort2 {
    public static void sort(int[] demo){
        int left = 0;
        int right = demo.length - 1;
        while (left < right){
            int min = left;
            int max = right;
            for (int i = left + 1; i <= right; i++) {
                if(demo[i] < demo[min]){
                    min = i;
                }
                if(demo[i] > demo[max]){
                    max = i;
                }
            }
            if(min != left){
                Swap.swap(demo,min,left);
            }
            if(max != right){
                Swap.swap(demo,max,right);
            }
            left++;
            right--;
        }
    }
}
class InsertionSort{
    public static void sort(int[] demo){
        for (int i = 1; i < demo.length; i++) {
            int get = demo[i];
            int end = i - 1;
            while (end >= 0 && get < demo[end]){
                demo[end+1] = demo[end];
                end--;
            }
            demo[end + 1] = get;
        }
    }
}
class QuickSort{
    public static void sort(int[] demo){
        int left = 0;
        int right = demo.length - 1;
        int mid = demo[left];
        int i = left;
        int j = right;
        while (i < j){
            while (i < j){
                if(demo[j] < mid){

                }
            }
        }
    }
}
public class Test {
    public static void main(String[] args) {
        int[] demo = {2,5,1,7,0,6,9,4,3,8};
        long start = System.currentTimeMillis();
        InsertionSort.sort(demo);
        System.out.println(Thread.currentThread().getName());
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(demo));
        System.out.println(end - start);
    }

}

