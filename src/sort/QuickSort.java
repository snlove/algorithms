package sort;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

   /**
   * 快速排序算法
   * Created by pc on 2017/8/31.
    */
public class QuickSort {

    public  static  void  sort(Comparable[] a) {
        //选择排序
       sort(a,0,a.length -1);
    }

       private static void sort(Comparable[] a, int lo, int hi) {
//           if (hi <= lo + 12) {
//               InsertSort.sort(a,lo,hi);
//               return;
//           }
           if (lo >= hi) {
               return;
           }
           int j = pation(a,lo,hi);
          sort(a,lo,j-1);
          sort(a,j+1,hi);
       }

       /**
        * 快速排序切分发
        * @param a 比较的数组
        * @param lo 数组的开始
        * @param hi 数组的结束
        * @return 切分标准的位置
        */
       private static int pation(Comparable[] a, int lo, int hi) {
           Comparable v = a[lo]; //切分的标准十分重要，可以采用中点法进行改进
           int i = lo ;
//           int j = hi;
           int j = hi + 1;
           while (true) {
               while (less(a[++i],v)) {
                   if (i == hi) {
                       break;
                   }
               }
               while (less(v, a[--j])) {
                   if (j == lo ) {
                       break;
                   }
               }
               if (i >= j) {  //当两个指针相等，已经穿过边界，两边已经满足条件，无法在进行扫描
                   break;
               }
               exch(a,i,j);

           }
           exch(a,lo,j);
//           while (i <= j) {
//               int result = a[i].compareTo(v);
//               if (result < 0) {
//                   i++;
//               } else {
//                   exch(a,i,j--);
//               }
//           }
//           exch(a,lo,j);
           return  j;
       }


       /**
        * 三分切分法，适用于数组中重复元素多的情况
        * 整体还是两分，其中左边是两部分，所以总共的指标，加小于的，等于不需要移动
        * @param a 比较的数组
        * @param lo 数组的开始
        * @param hi 数组的结束
        * @return 切分标准的位置
        */
       private static void sortThird(Comparable[] a, int lo, int hi) {
           if (hi <= lo) {
               return ;
           }
           Comparable v = a[lo];
           int i = lo + 1;
           int lt = lo; //相等元素的指针
           int gt = hi; //大于的指针
           while (i <= gt) {
               int result = a[i].compareTo(v);
               if (result > 0) {
                    exch(a,i,gt--);
               } else if (result < 0) {
                    exch(a,lt++,i++);

               } else {
                 i++;
               }
           }
           sortThird(a, lo, lt - 1);
           sortThird(a,gt+1,hi);
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
    private static void exch(Comparable[] a, int i, int j) {
        Comparable temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //展示方法
    private static void show(Comparable[] a) {
        for (Comparable anA : a) {
            StdOut.print(anA + "  ");
        }
    }

    //检测数组是否进行了排序
    private static boolean isSorted(Comparable[] comparables) {
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
