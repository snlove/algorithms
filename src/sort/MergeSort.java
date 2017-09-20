package sort;

import edu.princeton.cs.algs4.StdOut;

/**排序模版类
 * Created by pc on 2017/8/31.
 */
public class MergeSort {

    private static Comparable[] extraArr;

    public   static  void  sort(Comparable[] a) {
        //选择排序

            extraArr = new Comparable[a.length];
            sortBootom(a,0,a.length-1);



    }

    private static void sort(Comparable[] a, int lol, int end) {
        int medium = lol + (end - lol) /2;
        if (end <= lol + 12) {
           InsertSort.sort(a,lol,end);
            return;
        }
        if (lol == end) {
            return;
        }
        sort(a,lol,medium);
        sort(a,medium+1,end);
        merge(a,lol,end);

    }

    /**
     * 自底向上的合并排序
     */
    private static void sortBootom(Comparable[] a, int lol, int end) {
        if (lol == end) {
            return;
        }
        int n = a.length;
        //每次实际长度，无法全部，将标准定为实际长度的一半，最后，2，4，6----1，2，4，len = size /2 ,2,4,8
//        for (int size = 2; size <a.length ; size = size + size) {
//            for (int i = 0; i <a.length -size ; i = i + size) {
//                int hi = Math.min(i + size - 1, a.length-1);
//                merge(a,i,hi);
//            }
//        }
//        merge(a,0,a.length-1);  将·长度变为一半，
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n-len; lo += len+len) {
                int hi = Math.min(lo+len+len-1, n-1); //每个归并的开始编号，lo,末端编号等于开始加长度减1
                merge(a, lo, hi);
            }
        }

    }
    /**
     * 合并方法
     */
    private static void merge(Comparable[] a, int lol,int end) {

        int medium = lol + (end - lol) /2;
        assert isSorted(a,lol,medium);
        assert isSorted(a,medium+1,end);
        int j = medium + 1;
        int k = lol;
        //进行选择比较放入辅助数组，左边无，添加右边，右边无，添加左边，
        for (int i = lol; i <=end ; i++) {
            if (k > medium) {
                extraArr[i] = a[j++];
            } else if (j > end) {
                extraArr[i] = a[k++];
            } else {
                if (less(a[k], a[j])) {
                    extraArr[i] = a[k++];
                } else {
                    extraArr[i] = a[j++];
                }
            }
        }
        System.arraycopy(extraArr,lol,a,lol,end - lol + 1);

    }



    /**
     *比较方法
     * ture a< b
     */
    private static  boolean  less(Comparable a, Comparable b){

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
    private static void show(Comparable[] a) {
        for (Comparable each: a) {
            StdOut.print(each + "  ");
        }

    }

    //检测数组是否进行了排序
    private static boolean isSorted(Comparable[] comparables,int lol,int end) {
        for (int i = lol+1; i <end ; i++) {
            if (less(comparables[i],comparables[i-1])) {
                return  false;
            }
        }
        return  false;
    }

    //测试方法
    public static void main(String args[]) {
        String[] a = {"g","b","a","q","c","d","e","f","z"};
        sort(a);
        assert isSorted(a,0,a.length-1);
        show(a);

    }
}
