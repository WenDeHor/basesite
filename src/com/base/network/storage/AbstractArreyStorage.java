package com.base.network.storage;

import com.base.network.exeption.ExistStorageExeption;
import com.base.network.exeption.NotExistStorageExeption;
import com.base.network.exeption.StoragExeption;
import com.base.network.model.Resume;

import java.util.Arrays;

public abstract class AbstractArreyStorage implements Storage {
    protected static final int STORAGE_LIMIT = 10000;
    protected Resume[] storage = new Resume[STORAGE_LIMIT];
    protected int size = 0;
    @Override
    public int size() {
        return size;
    }
    @Override
    public void clear() {
        Arrays.fill(storage, 0, size, null);
//        for (int i = 0; i < size; i++) {
//            storage[i] = null;
//        }
        size = 0;
    }
    @Override
    public void update(Resume r) {
        int index = getIndex(r.getUuid());
        if (index != -1) {
            throw new NotExistStorageExeption(r.getUuid());
        } else {
            storage[index] = r;
        }
    }
    @Override
    public Resume[] getAll() {
        return Arrays.copyOfRange(storage, 0, size);
//        Resume[] result = new Resume[size];
//        for (int i = 0; i < size; i++) {
//            result[i] = storage[i];
//        }
//        return result;
    }
    @Override
    public void save(Resume r) {
        int index = getIndex(r.getUuid());
        if (index >= 0) {
            throw new ExistStorageExeption(r.getUuid());
        } else if (size == storage.length) {
            throw new StoragExeption("Storage overflow", r.getUuid());
        } else {
            isertElement(r, index);
            size++;
        }
    }

    @Override
    public void delete(String uuid) {
        int index = getIndex(uuid);
        if (index <= 0) {
            throw new NotExistStorageExeption(uuid);
        } else {
            fillDeletedElement(index);
            storage[size - 1] = null;
            size--;
        }

    }

    @Override
    public Resume get(String uuid) {
        int index = getIndex(uuid);
        if (index < 0) {
            throw new NotExistStorageExeption(uuid);
        }
        return storage[index];
    }

    protected abstract int getIndex(String uuid);

    protected abstract void fillDeletedElement(int index);

    protected abstract void isertElement(Resume r, int index);

}
