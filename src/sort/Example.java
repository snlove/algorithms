package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

/**排序模版类
 * Created by pc on 2017/8/31.
 */
public class Example {

    public  static  void  sort(Comparable[] a) {
          //选择排序
        int index= 0;
        for (int i = 0; i <a.length ; i++) {
            index = i;
            for (int j = i+1; j <a.length ; j++) {
                if (less(a[index],a[j])){

                } else {
                    index = j;
                }
            }
            exch(a,i,index);
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
        String[] a = {"g","b","a","q","c","d","e","f",};
        sort(a);
        assert isSorted(a);
        show(a);

    }
}
