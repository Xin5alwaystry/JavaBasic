package com.xinwu.javalearning.collections;


/**
 * 极简版ArrayList 模拟实现
 */
public class MockArrayList {

    private Object[] elementData;

    private int size;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return elementData.length == 0;
    }

    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    public MockArrayList() {
        this(10);
    }

    public MockArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            try {
                throw new Exception("list size can not less than 0!");
            } catch (Exception e) {
                e.printStackTrace();
            }
            elementData = new Object[initialCapacity];
        }
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            throw new RuntimeException("index is illegal!");
        }
    }

    public void add(Object o) {
        //判断是否需要数组扩容
        ensuranceCapacity(size);
        elementData[size++] = o;
    }

    public void remove(int index) {
        rangeCheck(index);
        int temp = size - index - 1; //
        if (temp > 0) {
            System.arraycopy(elementData, index + 1, elementData, index, temp);
        }
        elementData[size--] = null; //gc可回收这块内存
    }

    private void ensuranceCapacity(int size) {
        if (size == elementData.length) {
            Object[] newArray = new Object[size * 2 + 1];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

}
