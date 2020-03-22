package com.base.network.comparator;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class MainTest {
    public static void main(String[] args) {
        //       TODO #1
        PersonComparator pcomp = new PersonComparator();
        Set<Person> people = new TreeSet<Person>(pcomp);
        people.add(new Person("Tom", 5));
        people.add(new Person("Nick", 10));
        people.add(new Person("Alice", 4));
        people.add(new Person("Bill", 1));

        for (Person p : people) {
            System.out.println("name:" + p.getName() + ", age=" + p.getAge());
        }
        System.out.println();
        //       TODO #2
        Comparator<Person> comp = Comparator.comparing(Person::getName).thenComparing(Person::getAge).reversed();
        Set<Person> people2 = new TreeSet<Person>(comp);
        people2.add(new Person("Tom", 5));
        people2.add(new Person("Nick", 10));
        people2.add(new Person("Alice", 4));
        people2.add(new Person("Bill", 1));
        people2.add(new Person("Tom", 6));
        people2.add(new Person("Nick", 8));
        people2.add(new Person("Alice", 5));
        people2.add(new Person("Bill", 3));
        people2.add(new Person("Tom", 21));
        people2.add(new Person("Nick", 11));
        people2.add(new Person("Alice", 40));
        people2.add(new Person("Bill", 101));

        for (Person pa : people2) {
            System.out.println("name:" + pa.getName() + ", age=" + pa.getAge());
        }
    }
}
