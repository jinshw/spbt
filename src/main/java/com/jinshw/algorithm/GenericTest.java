package com.jinshw.algorithm;

import java.util.ArrayList;

/**
 * Created by Administrator on 2017/8/18 0018.
 */
public class GenericTest {
    public static void main(String[] args) {
//        Box<String> name = new Box<String>("corn");
//        System.out.println("name:" + name.getData());

//        Box<String> name = new Box<String>("corn");
//        Box<Integer> age = new Box<Integer>(712);
//        Box<Number> number = new Box<Number>(314);
//        getData(name);
//        getData(age);
//        getData(number);

        /*泛型方法*/
        GenericTest gm = new GenericTest();
       /* gm.f(99);
        gm.f("掌上洪城");
        gm.f(new Integer(99));
        gm.f(18.88);
        gm.f('a');
        gm.f(gm);*/
        gm.getParm(1111);
        gm.getParm("jinshw");
        gm.getParm(true);
        gm.getParm(Double.valueOf("0.23"));
        gm.getParm(new ArrayList());


    }

    public static void getData(Box<?> data) {
        System.out.println("data :" + data.getData());
    }

    public <T> void f(T x) {
        System.out.println(x.getClass().getName());
    }

    public <T> String getParm(T t) {
        System.out.println(t.getClass().getName());
        return t.getClass().getName();
    }
}


class Box<T> {
    private T data;

    public Box() {

    }

    public Box(T data) {
        setData(data);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}