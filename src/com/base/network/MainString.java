package com.base.network;

import java.util.Arrays;

public class MainString {
    public static void main(String[] args) {
        char[] str = {' ', ' ', 'a', 'b', ' ', ' ', ' ', ' '};
        String[] stringArrey = new String[]{"a", "b", "a", "b", "a", "b"};
        StringBuilder stringBuilder = new StringBuilder();
        for (String a: stringArrey){
           stringBuilder.append(a).append('-');
        }
        System.out.println("all stringArrey "+ stringBuilder);
        System.out.println(Arrays.toString(stringArrey));
    }
}
