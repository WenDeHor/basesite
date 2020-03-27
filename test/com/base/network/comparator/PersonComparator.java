package com.base.network.comparator;

import java.util.Comparator;

class PersonComparator implements Comparator<Person> {

    public int compare(Person a, Person b){

        return a.getAge().compareTo(b.getAge());
    }
}
