package onetoone;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;

/**
 * Created by pc on 2017/8/23.
 */
public class JosePhus {

    public static void main(String[] args) {
        int m = 3;
        int n = 7;

        // initialize the queue
        Queue<Integer> queue = new Queue<Integer>();
        for (int i = 0; i < n; i++) {
            queue.enqueue(i);
        }


        while (!queue.isEmpty()) {
            for (int i = 0; i <m-1 ; i++) {
                queue.enqueue(queue.dequeue());
            }
            StdOut.print(queue.dequeue() + "  ");
        }


    }
}
