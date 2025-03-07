package com.wowdespacito.my_blog.utils;

public class ThreadLoaclUtil {
    //提供ThreadLocal对象
    private static final ThreadLocal<Object> THREAD_LOCAL = new ThreadLocal<>();

    //根据键获取值
    @SuppressWarnings("unchecked")
    public static <T> T get() {
        return (T) THREAD_LOCAL.get();
    }

    //存储键值对
    public static <T> void set(T value) {
        THREAD_LOCAL.set(value);
    }

    //清除ThreadLocal 防止内存溢出
    public static void remove() {
        THREAD_LOCAL.remove();
    }
}
