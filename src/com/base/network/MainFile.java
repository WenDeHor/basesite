package com.base.network;

import java.io.File;
import java.io.IOException;
import java.util.Objects;

public class MainFile {
    public static void main(String[] args) {

        System.out.println();
        System.out.println("111111111111111111");
        String directory = "./src/com/base/network";
        File file = new File(directory);
        try {
            System.out.println(file.getCanonicalPath());
        } catch (IOException e) {
            throw new RuntimeException("Error", e);
        }
        System.out.println();
        System.out.println("22222222222222222");
        File dir = new File("F:\\FATHER\\BASE\\basesite\\src\\com\\base\\network");
        System.out.println(dir.isDirectory()); // перевірка чи дана адреса до папки

        System.out.println();
        System.out.println("3333333333333333");
        for (String name : Objects.requireNonNull(dir.list())) { // з перевіркою на нуль
            System.out.println(name);
        }

        System.out.println();
        System.out.println("4444444444444");
//        FileInputStream fis = null;
//        try (FileInputStream fileInputStream = new FileInputStream(directory)) {
//            System.out.println(fis.read());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
        System.out.println();
        System.out.println("55555555555555");
        printDirectoryDeeply(dir);

//        FileInputStream fis=null;
//        try {
//            fis = new FileInputStream(filePath);
//            System.out.println(fis.read());
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }finally {
//            if(fis!=null){
//                try {
//                    fis.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//        }


    }
 // Виводемо назви папок та файлів які в них
    public static void printDirectoryDeeply(File dir) {
        File[] files = dir.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    System.out.println("File: " + file.getName());
                } else if (file.isDirectory()) {
                    System.out.println("Directory: " + file.getName());
                    printDirectoryDeeply(file);
                }
            }
        }
    }
}
