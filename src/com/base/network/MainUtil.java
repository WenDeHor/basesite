package com.base.network;

public class MainUtil {
    public static void main(String[] args) {
        System.out.println(Integer.valueOf(-1)==Integer.valueOf(-1));
        System.out.println(Integer.valueOf(-1)==new Integer(-1));
        int resuli=getInt();
        System.out.println(resuli);

    }
    private static Integer getInt(){
        return -1;

    }
}
