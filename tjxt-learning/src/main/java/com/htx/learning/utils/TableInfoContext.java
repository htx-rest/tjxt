package com.htx.learning.utils;

/**
 * @Author: htx
 * @GZH:二哈学习之路
 * @Date:2024/9/25
 * @Desc:
 */
public class TableInfoContext {
    private static final ThreadLocal<String> TL = new ThreadLocal<>();

    public static void setInfo(String info) {
        TL.set(info);
    }

    public static String getInfo() {
        return TL.get();
    }

    public static void remove() {
        TL.remove();
    }
}
