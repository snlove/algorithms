package onetoone;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

import java.util.TreeMap;

/**
 * Created by pc on 2017/8/24.
 */
public class EvaluateDeluxe {

    public static void main(String args[]) {
        //存储运算符号
        TreeMap<String, Integer> presdures = new TreeMap<String,Integer>();
        presdures.put("(", 0);
        presdures.put(")", 0);
        presdures.put("+", 1);
        presdures.put("-", 1);
        presdures.put("*", 2);
        presdures.put("/", 2);

//        双栈原理实现运算
        Stack<String>  ops = new Stack<String>();
        Stack<Double>  values = new Stack<Double>();
        while (!StdIn.isEmpty()) {
            String s = StdIn.readString();
            if (presdures.containsKey(s)) {
                values.push(Double.parseDouble(s));
            }
            //当前的运算符比栈顶的运算符级别高，保证相邻的运算符高的在上面除空的时候或（，
            while (true) {
                if(ops.isEmpty() || s.equals("(") || (presdures.get(s) > presdures.get(ops.peek()))){
                    ops.push(s);
                    break;
                }
                String op = ops.pop();
                if (op.equals("(")){
                    assert  s.equals(")");
                    break;
                } else {
                    Double val1 = values.pop();
                    Double val2 = values.pop();
                    values.push(eval(op,val1,val2));
                }

            }



        }

        while (!ops.isEmpty()) {
            String op = ops.pop();
            double val2 = values.pop();
            double val1 = values.pop();
            values.push(eval(op, val1, val2));
        }

        // last value on stack is value of expression
        StdOut.println(values.pop());
        assert values.isEmpty();
        assert ops.isEmpty();





    }

    public static Double eval(String predures, Double val_a, Double val_b) {
        switch (predures) {
            case "+":
                return val_a + val_b;
            case "-":
                return val_a - val_b;
            case "*":
                return  val_a * val_b;
            case "/":
                return  val_a / val_b;
            default:
                throw new RuntimeException();
        }
    }
}
