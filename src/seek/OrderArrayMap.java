package seek;

import java.util.Iterator;

/**
 * 利用数组实现的有序符号表
 * Created by pc on 2017/9/26.
 */
public class OrderArrayMap<Key extends Comparable<Key>, Value> {

    private Key[] keys;
    private Value[] values;
    private int n = 0;

    public OrderArrayMap(Key[] keys, Value[] values) {
        this.keys = keys;
        this.values = values;
    }

    /**
     * 查找方法
     *
     * @param key 查找的key
     */
    private Value get(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("非法参数");
        }
        if (isEmpty()) return null;
        int i = rank(key); //引文长度跟数组顺序的差别，所以i + 1 -1 就是相等的编号
        //查找到后i,排除大于不存在和开始的情况的情况
        if (i < n && key.compareTo(keys[i]) == 0) {
            return values[i];
        }
        return null;

    }

    /**
     * 插入方法
     *
     * @param key   插入的key
     * @param value 插入的值
     */
    private void put(Key key, Value value) {
        if (key == null || value == null) {
            throw new IllegalArgumentException("非法参数");
        }
        int i = rank(key);
        //是否存在
        if (i < n && key.compareTo(keys[i]) == 0) {
            values[i] = value;
            return;
        }
        if (n == keys.length) {
            resize(keys.length * 2);
        }

        for (int j = n; j > i; j--) {
            keys[j] = keys[j - 1];
            values[j] = values[j - 1];
        }
        keys[i] = key;
        values[i] = value;
        n++;
        assert check();

    }

    private void delete(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("非法参数");
        }
        if (isEmpty()) return;
        int i = rank(key);
        if (i == n || keys[i].compareTo(key) != 0) {
            return;
        }
        for (int j = i; j < n - 1; j++) {
            keys[j] = keys[j + 1];
            values[j] = values[j + 1];
        }
        keys[n - 1] = null;
        values[n - 1] = null;
        n--;
        if (n > 0 && n == keys.length / 4) {
            resize(keys.length / 2);
        }


    }


    private int size() {
        return n;
    }

    // resize the underlying arrays
    private void resize(int capacity) {
        assert capacity >= n;
        Key[] tempk = (Key[]) new Comparable[capacity];
        Value[] tempv = (Value[]) new Comparable[capacity];
        for (int i = 0; i < n; i++) {
            tempk[i] = keys[i];
            tempv[i] = values[i];
        }
        values = tempv;
        keys = tempk;
    }


    private boolean check() {
        return isSorted() && rankCheck();
    }

    // are the items in the array in ascending order?
    private boolean isSorted() {
        for (int i = 1; i < size(); i++)
            if (keys[i].compareTo(keys[i - 1]) < 0) return false;
        return true;
    }

    // check that rank(select(i)) = i
    private boolean rankCheck() {
        for (int i = 0; i < size(); i++)
            if (i != rank(select(i))) return false;
        for (int i = 0; i < size(); i++)
            if (keys[i].compareTo(select(rank(keys[i]))) != 0) return false;
        return true;
    }


    private boolean isEmpty() {
        return n == 0;
    }

    private Key min() {
        return keys[0];
    }

    private Key max() {
        return keys[n-1];
    }

    private Key floor(Key key) {
        return null;
    }

    private Key ceiling(Key key) {
        return null;
    }

    /**
     * 二分查找寻找相等的，
     * 逐次比较
     *
     * @param key
     * @return 因为返回的是相等的说以长度等于 k - 1 + 1 = k,其他的大于是lo最后n，小于开始的为0
     */
    private int rank(Key key) {
        if (key == null) {
            throw new IllegalArgumentException("非法参数");
        }
        int lo = 0;
        int hi = keys.length -1;
        while (lo <= hi) {
            int medium = lo + (hi - lo) / 2;
            int compare = key.compareTo(keys[medium]);
            if (compare > 0) {
                lo = medium + 1;
            } else if (compare < 0) {
                hi = medium - 1;
            } else {
                return medium;
            }

        }
        return lo;
    }

    private Key select(int i) {
        if (i > n || i < 0) {
            throw new IllegalArgumentException("超出符号表范围");
        }
        return  keys[i];
    }

    private void deleteMin() {

    }

    private void deleteMax() {

    }

    private int size(Key lol, Key hi) {
        if (lol == null || hi == null) {
            throw new IllegalArgumentException("参数不能为空");
        }
        if (lol.compareTo(hi) < 0) {
            throw  new IllegalArgumentException("范围不正确");
        }
        int lol_i = rank(lol);
        int hi_i = rank(hi);
        boolean lol_in = lol_i < n && lol.compareTo(keys[lol_i]) == 0;
        boolean hi_in = hi_i < n && hi.compareTo(keys[hi_i]) == 0;
        if (hi_in) {
            return  hi_i - lol_i + 1;
        } else {
//           return   hi_i - lol_i; //rank返回的特殊 没有就是0，大于全部的话是n,就是编号大一
           return  n  - lol_i;
        }

    }

//    private Iterator<Key> keys(Key lol, Key hi) {
//
//    }
//
//    private Iterator<Key> keys() {
//
//    }


}
