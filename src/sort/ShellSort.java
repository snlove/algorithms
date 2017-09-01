package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**排序模版类
 * Created by pc on 2017/8/31.
 */
public class ShellSort {

    public  static  void  sort(Comparable[] a) {
        //优化分割的步数
        int grap = 1;
        int N = a.length;
        while(grap < N / 3){grap = 3 * grap +1;}

        //一般分组一次插入排序
//        for (grap = N/2;grap >0; grap=grap/2) {
//            for (int i = 0; i <=grap ; i++) {
//                for(int j = i+grap; j<N && less(a[j],a[j-grap]);j=j+grap) {
//                    exch(a,j,j-grap);
//                }
//            }
//
//        }
        //无需一次，只要保证每组进行插入排序就行，例如1a,1b比较，接着进行2a,2b比较

        while (grap > 0) {
            for (int i = grap; i <N ; i++) {
                for (int j = i + 1;  j>=grap && less(j,j-grap);j= j-grap ) {
                    exch(a,j,j-grap);
                }
            }
            grap = grap/3;
        }

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
        String[] a = {"S", "H", "E", "L" ,"L" ,"S" ,"O", "R" ,"T" ,"E", "X" ,"A" ,"M" ,"P" ,"L" ,"E"};
        sort(a);
        assert isSorted(a);
        show(a);

    }
}
