package onetoone; /**
 * Created by pc on 2017/8/14.
 */
import edu.princeton.cs.algs4.*;
public class MainSimu {
     int a  = 3;
    public static void main(String args[]) {
        Stack<String> strStack = new Stack<String>();
        String input = "it was-the best-of times-it was-the-";
        String[] inputs = input.split("-");
        for (int i = 0; i <inputs.length; i++) {
            strStack.push(inputs[i]);
        }
        StdOut.println(strStack);

    }

    public  void increment() {
        this.a++;
        StdOut.println(a);
    }
    /*
    *二位数组的转置
    * b是转置后的数组
     */
    public  static  int[][] migrate(int[][] a, int[][] b) {
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[0].length; j++) {
                   b[j][i] = a[i][j];
            }
        }
        return  b;

    }

    //不使用Math,求给定数，不大于logmN的最大整数
    public static int loga(int n, int m) {
        int a = 0;
        while(n>=m) {

            n = n/m;
            a++;
        }
        return  a;
    }

    //计算数组中每个元素出现的次数，将其放在给定长度的数组中
    public static  int[] histogram(int[] a, int M) {
        int[] b = new int[M - 1];
        int n = 0;
        int m = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j <a.length ; j++) {
                if (i == a[j]) {
                    n++;
                }
            }
            b[i] = n;
            n = 0;
        }
        return  b;
    }

    //计算最大公约数
    public static int commonDivison(int x, int y) {

        if (x == 1 || y == 1) {
            StdOut.println("x:" + x  + " y:" + y);
            return 1;
        }

        if(x < y ) {
            int temp = x;
            x = y;
            y = temp;

        }
        StdOut.println("x:" + x  + " y:" + y);
        if(x % y == 0) {
            StdOut.println("x:" + x  + " y:" + y);
            return  y;

        } else {
            x = x% y;
            StdOut.println("x:" + x );
            return  commonDivison(x,y);
        }
    }

    //二项分布计算
    public static double binomial(int N, int k, double p)
    {  if (N == 0 && k == 0) return 1.0;
       if (N < 0 || k < 0) return 0.0;
       return (1.0 - p)*binomial(N-1, k, p) + p*binomial(N-1,k-1,p);
    }

    /**
     * 判断是否互质
     *
     * @return 返回值 1互质 其他非互质
     * @params 参数
     */
    public static int gcd(int m, int n) {
        if (m == 0 || n == 0) {
            return 1;
        }
        if(m % n == 0) {
            return  n;
        } else {
            return gcd(n, m % n);
        }
    }

}
