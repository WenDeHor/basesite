package com.base.network.storage;

import com.base.network.model.Resume;

import java.util.Arrays;

public abstract class AbstractArreyStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;

    public int size() {
        return size;
    }

    public void clear() {
        Arrays.fill(storage, 0, size, null);
//        for (int i = 0; i < size; i++) {
//            storage[i] = null;
//        }
        size = 0;
    }

    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            System.out.println("Resume" + r.getUuid() + "not exist");
        } else {
            storage[index] = r;
        }
    }

    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
//        Resume[] result = new Resume[size];
//        for (int i = 0; i < size; i++) {
//            result[i] = storage[i];
//        }
//        return result;
    }

    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index > 0) {
            System.out.println("Resume" + r.getUuid() + "already exist");
        } else if (size == storage.length) {
            System.out.println("Storage overflow");
        } else {
            isertElement(r, index);
            size++;
        }
    }


    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("ERROR");
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }

    }


    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            System.out.println("Resume" + uuid + "not exist");
            return null;
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

    protected abstract void fillDeletedElement(int index);

    protected abstract void isertElement(Resume r, int index);

}
