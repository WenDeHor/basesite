package com.base.network.util;

public class LazySinglyton {
//    int anInt;
    volatile private static LazySinglyton SINGLYTON;

    public LazySinglyton() {
    }

    private static class LazySinglytonHolder {
        private static final LazySinglyton SINGLYTON=new LazySinglyton();
    }

    public static LazySinglyton getSINGLYTON() {
        return LazySinglytonHolder.SINGLYTON;
    }
    //    public static LazySinglyton getSINGLYTON() {
//        if (SINGLYTON == null) {
//            synchronized (LazySinglyton.class) {
//                if (SINGLYTON == null) {
//                    int anInt=1; // volatile не дає переставляти операції місцями
//                    SINGLYTON = new LazySinglyton();
//                }
//            }
//        }
//        return SINGLYTON;
//    }
}
