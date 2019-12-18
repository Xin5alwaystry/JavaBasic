package com.xinwu.javalearning.generic.gen02;


/**
 * 父类为泛型类
 * 1，属性
 * 2，方法
 *
 * 总结：
 * 要么同时擦除，要么子类泛型的个数大于父类（大于等于）
 * 不能子类擦除，父类泛型
 *
 * 1，属性类型
 *  根据属性的位置决定
 *  在父类中，随父类而定
 *  在子类中，随子类而定
 * 2，重写方法类型
 *  随父类而定。其实也很好理解，子类重写的父类方法，类型自然由父类的方法定。
 *
 * @param <T>
 */
public abstract class Father<T > {
    T name;
    public abstract void test(T t);
}

/**
 * 第1种情况：子类在声明时指定具体类型
 * 属性和方法都为具体类型
 */
class Son extends Father<String> {

    @Override
    public void test(String s) {

    }
}


/**
 * 第2种情况，子类为泛型类，类型在使用时确定
 * @param <T>
 */
class Son2<T> extends Father<T> {

    @Override
    public void test(T t) {

    }
}

/**
 * 第3种情况：子类为泛型类，父类不指定类型，泛型的擦除，使用Oject替换
 * @param <T>
 */
class Son3<T> extends Father {

    @Override
    public void test(Object o) {

    }
}

/**
 * 第4种情况：子类和父类都不指定类型，同时泛型擦除
 */
class Son4 extends Father {

    @Override
    public void test(Object o) {

    }
}

/**
 * 第5种情况：子类擦除，父类指定泛型。错误
 */
