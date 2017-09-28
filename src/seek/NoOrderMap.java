package seek;


/**
 * 利用链表实现的无序符号表
 * Created by pc on 2017/9/26.
 */
public class NoOrderMap<Key extends Comparable<Key>,Value> {

     private Node first;
     private int n = 0;
    //数据对象
    public class Node{
        private Key key;
        private Value value;
        private Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    /**
     * 查找方法
     * @param key 查找的key
     */
    private Node get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        for (Node i = first; first != null && i != null; i = i.next) {
            if (i.key.compareTo(key) == 0) {
                return  i;
            }
        }

        return  null;


    }

    /**
     * 插入方法
     * @param key 插入的key
     * @param value 插入的值
     */
    private void put(Key key, Value value) {
        if (key == null) throw new IllegalArgumentException("first argument to put() is null");
        if (value == null) {
            delete(key);
            return;
        }
        if (first == null) {
            first = new Node(key, value,null);
        } else {
            for (Node i = first; first != null && i != null; i = i.next) {
                if (i.key.compareTo(key) == 0) {
                     i.value = value;
                }
            }
            Node oldFirst = first;
            first = new Node(key, value, oldFirst);
            n++;
        }

    }

    private void delete(Key key) {
        if (key == null || first == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
       first =  delete(first,key);
//        if (key.compareTo(first.key) == 0) {
//            first = first.next;
//            n--;
//            return;
//        }
//        Node before = first;
//        for (Node i = first; first != null && i != null; i = i.next) {
//            if (i.key.compareTo(key) == 0) {
//               before.next = i.next;
//               i = null;
//               n--;
//               break;
//            }
//            before = i;
//        }

    }

    private Node delete(Node x, Key key) {
        if ( first == null) {
            throw new IllegalArgumentException("空表无法删除");
        }
        if (x == null) {
            return null;
        }
        if (key.compareTo(x.key) == 0) {
            return  x.next;
        }
        return x.next = delete(x.next, key);
    }

    private int size() {
        return  n;
    }

    private boolean contains(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("first argument to put() is null");
        }
        for (Node i = first; first != null && i != null; i = i.next) {
            if (i.key.compareTo(key) == 0) {
              return  true;
            }
        }
        return  false;
    }

    private boolean isEmpty() {
        return  n == 0;
    }




}
