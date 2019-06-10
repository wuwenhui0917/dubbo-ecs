package com.alibaba.dubbo.demo;

import java.io.Serializable;

/**
 * Created by wuwenhui on 2017/11/27.
 * since
 *
 * @version 1.0
 */
public class CallBean implements Serializable {
    private String name="wuwenhui";
    private int age ;
    private  String right;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return this.name+";"+this.age+";"+this.right;
    }
}
