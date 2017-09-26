package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**
 * 堆排序的使用
 * Created by pc on 2017/8/31.
 */
public class HeapSort {

    public  static  void  sort(Comparable[] a) {
        int j = a.length /2;
        int n = a.length; //用于表示堆的索引的长度，比数组长度大，充1开始，
        while (j > 1) {
           sink(a,j,n);
           j--;
        }
        while (n > 1) {
           n =  delMax(a, n);
        }

    }

    /**
     * 下沉操作
     * @param a 要进行下沉的表示堆的数组
     * @param k 要进行下沉的堆的第k个节点
     * @param n 要进行下沉的堆的长度
     */
    private static void  sink(Comparable[] a, int k, int n) {
        //数组的0 为实际堆的1
        int j = 0;
        while(2* k <= n) {
             j = 2 * k;
            if(j < n && less(a[j-1],a[j])){
                j++;
            }
            if (!less(a[k-1], a[j-1])) {
                break;
            }
            exch(a,k-1,j-1);
            k = j;
        }


    }

    private static  int  delMax(Comparable[] a, int n) {
        exch(a,0,n-1);
        n--;
        sink(a,1,n);
        return  n;
    }

    /**
     *比较方法
     * ture a< b
     */
    public static  boolean  less(Comparable a, Comparable b){
        return a.compareTo(b) < 0;
    }

    /**
     * 交换方法
     */
    public static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //展示方法
    public static void show(Comparable[] a) {
        for (int i = 0; i <a.length; i++) {
            StdOut.print(a[i] + "  ");
        }
    }

    //检测数组是否进行了排序
    public static boolean isSorted(Comparable[] comparables) {
        for (int i = 1; i <comparables.length ; i++) {
            if (less(comparables[i],comparables[i-1])) {
                return  false;
            }
        }
        return  false;
    }

    //测试方法
    public static void main(String args[]) {
        String[] a = {"g","b","a","q","c","d","e","f",};
        sort(a);
        assert isSorted(a);
        show(a);

    }
}
