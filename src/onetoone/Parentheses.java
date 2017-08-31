package onetoone;

import edu.princeton.cs.algs4.StdOut;

import java.util.Stack;

import static java.lang.System.in;

/**
 * Created by pc on 2017/8/22.
 */
public class Parentheses {

    private String parentheses;

    public Parentheses(String parentheses) {
        this.parentheses = parentheses;
    }

    public static void main(String args[]) {
        Parentheses parentheses = new Parentheses("[,(,],)");
        String[] input = parentheses.parentheses.split(",");
        boolean isPair = parentheses.checkParentheses(input);
        StdOut.println(isPair);
    }

    public boolean checkParentheses(String[] params) {
        Stack<String> stackString = new Stack<String>();
        String[] leftPar = {"(","[","{"};
        String[] rightPar = {")","]","}"};
        for (int i = 0; i <params.length ; i++) {
            if (checkContains(params[i],leftPar)){
                stackString.push(params[i]);
            } else {
                if(!stackString.isEmpty()) {
                    String preItem = stackString.peek();
                    if (params[i].equals(")") && preItem.equals("(")){
                        stackString.pop();
                    } else if (params[i].equals("]") && preItem.equals("[")){
                        stackString.pop();
                    } else if (params[i].equals("}") && preItem.equals("{")) {
                        stackString.pop();
                    } else {
                        stackString.push(params[i]);
                    }
                } else {
                    stackString.push(params[i]);
                }

            }
        }
        if (stackString.isEmpty()) {
            return  true;
        } else {
            return false;
        }

    }
    public boolean checkContains(String key, String[] source) {
        for (int i = 0; i <source.length ; i++) {
            if (key.equals(source[i])) {
                return  true;
            } else {
                continue;
            }
        }
        return  false;
    }
}
