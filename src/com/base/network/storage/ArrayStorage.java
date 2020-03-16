package com.base.network.storage;

import com.base.network.model.Resume;


public class ArrayStorage extends AbstractArreyStorage {

    protected int getIndex(String uuid) {
        for (int i = 0; i < size; i++) {
            if (uuid.equals(storage[i].getUuid())) {
//          if (uuid==storage[i].getUuid()) {
                return i;
            }
        }
        return -1; //not element
    }

    @Override
    protected void fillDeletedElement(int index) {
        storage[index] = storage[size - 1];
    }

    @Override
    protected void isertElement(Resume r, int index) {
        storage[size] = r;
    }
}
