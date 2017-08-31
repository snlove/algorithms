package onetoone;

/**
 * Created by pc on 2017/8/15.
 */
public class Martrix {
    //向量点乘
    static double dot(double[] x, double[] y){
        double sum = 0.0;
        if (x.length != y.length) {
            throw new IllegalArgumentException("两个向量长度不一无法进行点积相乘");
        }
        for (int i = 0; i <x.length ; i++) {
                sum = sum + x[i]*y[i];

        }
        return sum;

    }

    /**
     * 矩阵和矩阵之积
     * @param a
     * @param b
     * @return
     */
     static double[][] mult(double[][] a, double[][] b){
         if (a[0].length != b.length) {
             throw new IllegalArgumentException("两个矩阵不满足相乘的条件");
         }
         double[][] c = new double[a.length-1][b[0].length-1];
         int m = a.length;
         int p = b.length;
         int n = b[0].length;
         double sum = 0;
         for (int i = 0; i <m; i++) {
             for (int j = 0; j <n ; j++) {
                 for (int k = 0; k <p ; k++) {
                     sum = sum + a[i][k]*b[k][j];
                 }
                 c[i][j] = sum;
                 sum = 0;
             }
         }
         return  c;
     }

    /**
     * 转置矩阵
     * @param a
     * @return
     */
    static double[][] transpose(double[][] a){
        double[][] b = new double[a[0].length-1][a.length-1];
        for (int i = 0; i <a.length ; i++) {
            for (int j = 0; j <a[0].length; j++) {
                b[j][i] = a[i][j];
            }
        }
        return  b;
    }

    /**
     * 矩阵和向量之积
     * @param a
     * @param x
     * @return
     */
     static double[] mult(double[][] a, double[] x){
         if (a[0].length != x.length) {
             throw new IllegalArgumentException("两个矩阵不满足相乘的条件");
         }
         double[] c = new double[a.length-1];
         int m = a.length;
         int p = x.length;
         double sum = 0;
         for (int i = 0; i <m; i++) {
                 for (int k = 0; k <p ; k++) {
                     sum = sum + a[i][k]*x[k];
                 }
                 c[i] = sum;
                 sum = 0;

         }
         return  c;
     }

    /**
     * 向量和矩阵之积
     * @param y
     * @param a
     * @return
     */
     static double[] mult(double[] y, double[][] a) {
         if (y.length != a.length) {
             throw new IllegalArgumentException("两个矩阵不满足相乘的条件");
         }
         double[] c = new double[a[0].length-1];
         int p = y.length;
         int n = a[0].length;
         double sum = 0;

             for (int j = 0; j <n ; j++) {
                 for (int k = 0; k <p ; k++) {
                     sum = sum + y[k]*a[k][j];
                 }
                 c[j] = sum;
                 sum = 0;
             }
         return  c;
     }
}
