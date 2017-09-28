package seek;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * 二叉查找树
 * Created by pc on 2017/9/28.
 */
public class BinarySearchTree<Key extends Comparable<Key>,Value> {

    private Node root;


    //    数据结构
    public class Node {
        Node left;
        Node right;
        Key key;
        Value value;
        int n;

        public Node(Key key, Value value, int n) {
            this.key = key;
            this.value = value;
            this.n = n;
        }
    }

    /**
     * 查找方法
     *
     * @param key 查找的key
     */
    private Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("参数不可为空");
        }
        return get(root, key);

    }

    private Value get(Node x, Key key) {
        if (key == null) {
            throw new IllegalArgumentException("参数不可为空");
        }
        if (x == null) {
            return  null;
        }
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            return get(x.left, key);
        } else if (compare > 0) {
            return get(x.right, key);
        } else {
            return x.value;
        }
    }

    /**
     * 插入方法
     *
     * @param key   插入的key
     * @param value 插入的值
     */
    private void put(Key key, Value value) {
        if (key == null) {
            throw new IllegalArgumentException("参数不可为空");
        }
        if (value == null) {
            delete(key);
            return;
        }
        root = put(root, key, value);
    }

    private Node put(Node x, Key key, Value value) {
        if (x == null) {
            x = new Node(key, value, 1); //收敛的标准
        }
        int compare = key.compareTo(x.key);
        if (compare < 0) {
            x.left = put(x.left, key, value);
        } else if (compare > 0) {
            x.right = put(x.right, key, value);
        } else {
            x.value = value;
        }
        x.n = size(x.left) + size(x.right) + 1;
        return x;

    }

    private void delete(Key key) {
        if (key == null) {
            //
            return;
        }
        if (isEmpty()) {
            //
            return;
        }
        root = delete(root, key);

    }

    /**
     * step one :删除节点的步骤：找到要删除的节点 x = temp
     * step two : Node x equal min Node x.right; Node n left Node is equal  temp Node left
     * step three:
     * excpet left is null,x=x.right
     * Node right is null,x = x.left
     * @param
     * @param key
     */
    private Node delete(Node x, Key key) {
        if (x == null || key == null) {
            return null;
        }

            int compare = key.compareTo(x.key);
            if (compare < 0) {
                x.left = delete(x.left, key);
            } else if (compare > 0) {
               x.right = delete(x.right,key);
            } else {
                Node temp = x;
                if (x.left == null) {
                    x = temp.right;
                } else if (x.right == null) {
                    x = x.left;
                } else {
                    x = min(x.right);
                    x.right = deleteMin(x.right);
                    x.left = temp.left;
                }

            }
        x.n = size(x.left) + size(x.right) + 1; //每层都需要更新
        return  x;

    }


    private int size() {
        if (root == null) {
            return  0;
        } else {
            return  root.n;
        }
    }

    private int size(Node x) {
        if (x == null) {
            return  0;
        }
        return size(x.left) + size(x.right) + 1;
    }

    // resize the underlying arrays
    private void resize(int capacity) {

    }


    private boolean check() {
        return isSorted() && rankCheck();
    }

    // are the items in the array in ascending order?
    private boolean isSorted() {

    }

    // check that rank(select(i)) = i
    private boolean rankCheck() {

    }


    private boolean isEmpty() {
        return size() == 0;
    }

    public Node min() {
        return min(root);
    }

    private Node min(Node x) {
        if (x == null) {
            throw new IllegalArgumentException("空树没有最小节点");
        }
        Node temp = x;
        while (true) {
            if (temp.left == null) {
                return temp;
            }
            temp = temp.left;
        }
    }

    public void deleteMin() {
        if (isEmpty()) {
            throw new IllegalArgumentException("空");
        }
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        //非递归，利用min
//        Node min = min(x);
//        min = min.right;
//        //更新长度
//        Node temp = x;
//        while (true) {
//            if (temp.left.key.compareTo(min.key) == 0) {
//                break;
//            }
//            temp.n = temp.n -1;
//            temp = temp.left;
//        }
//        return  x;
        if (x.left == null) {
            return x.right;
        }

        x.left = deleteMin(x.left);
        x.n = size(x.left) + size(x.right) + 1;
        return  x;


    }
}
