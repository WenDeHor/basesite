package com.base.network;

import com.base.network.model.Resume;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MainReflection {
    public static void main(String[] args) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Resume resume = new Resume("dammy");
        Class<? extends Resume> resumeClass = resume.getClass();
        Field filds = resumeClass.getDeclaredFields()[0];
        filds.setAccessible(true);

        System.out.println("1--" + filds.getName());//взнаємо назви полів
        System.out.println("2--" + filds.get(resume)); //взнаємо існуюче значення
        filds.set(resume, "new_uuid"); //значення міняємо
        System.out.println("3--" + resume);

        Method method = resumeClass.getMethod("toString");
        Object invoke = method.invoke(resume);
        System.out.println(invoke);
    }
}
