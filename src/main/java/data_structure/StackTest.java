package data_structure;

/**
 * Created by yan on 2016/1/30.
 */
public class StackTest {
    private Object[] stack;
    //元素个数;
    private int size;

    //默认长度为10;
    public StackTest() {
        this(10);
    }

    //也可以自己设置长度,即容量;
    public StackTest(int len) {
        stack = new Object[len];
    }

    //返回元素个数;
    public int size() {
        return size;
    }

    //返回数组长度,即容量;
    public int capacity() {
        return stack.length;
    }

    //实现动态的数组;
    public void ensureCapacity() {
        if (size() == capacity()) {
            Object[] newStack = new Object[size() * 3 / 2 + 1];
            System.arraycopy(stack, 0, newStack, 0, size());
            stack = newStack;
        }
    }

    //入栈;
    public void push(Object o) {
        size++;
        ensureCapacity();
        stack[size - 1] = o;
    }

    //判空;
    public boolean isEmpty() {
        return size == 0;
    }

    //出栈;
    public Object pop() {
//首先要判空;
        if (isEmpty()) {
            throw new ArrayIndexOutOfBoundsException("不能为空");
        }
        Object o = stack[--size];
        stack[size] = null;
        return o;
    }

    public static void main(String[] args) {
        StackTest stack = new StackTest(3);
        String[] data = new String[]{"a", "b", "c"};
        for (int i = 0; i < data.length; i++) {
            stack.push(data[i]);
            System.out.println(data[i] + "");
        }
        System.out.println("***********");
        while (!stack.isEmpty()) {
            System.out.println(stack.pop() + "");
        }
    }
}
