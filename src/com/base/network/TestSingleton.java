package com.base.network;


public class TestSingleton {
    private static TestSingleton instance;

    public TestSingleton() {
    }

    public synchronized static TestSingleton getInstance() {
        if (instance == null) {
            instance = new TestSingleton();
        }
        return instance;

    }

    public static void main(String[] args) {
        TestSingleton.getInstance().toString();
        Singleton instance = Singleton.valueOf("INSTANCE");
        System.out.println(instance.name());
        System.out.println(instance.ordinal()); // порядковий номер в методі enum
    }
    public enum Singleton{
        INSTANCE
    }
}
