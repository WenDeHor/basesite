package com.base.network;

import com.base.network.model.Resume;
import com.base.network.storage.ArrayStorage;
import com.base.network.storage.Storage;


public class MainTestArrayStorage {
    private static final Storage ARRAY_STORAGE = new ArrayStorage();
    private static final String UUID1 = "uuid1";
    private static final String UUID2 = "uuid2";
    private static final String UUID3 = "uuid3";

    public static void main(String[] args) {
        final Resume r1 = new Resume(UUID1);
        final Resume r2 = new Resume(UUID2);
        final Resume r3 = new Resume(UUID3);


        ARRAY_STORAGE.save(r1);
        ARRAY_STORAGE.save(r2);
        ARRAY_STORAGE.save(r3);


        System.out.println("Get r1: " + ARRAY_STORAGE.get(r1.getUuid()));
        System.out.println("Size: " + ARRAY_STORAGE.size());

//        System.out.println("Get dummy: " + ARRAY_STORAGE.get("dummy"));

        System.out.println("");
        printAll();

        System.out.println("");
        System.out.println("dalate uuid1");
        ARRAY_STORAGE.delete(r1.getUuid());
        printAll();

        System.out.println("");
        System.out.println("clear");
        ARRAY_STORAGE.clear();
        printAll();

        System.out.println("Size: " + ARRAY_STORAGE.size());
    }

    static void printAll() {

        for (Resume r : ARRAY_STORAGE.getAllSorted()) {
            System.out.println(r);
        }
    }

}
