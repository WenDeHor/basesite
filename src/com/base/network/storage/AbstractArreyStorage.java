package com.base.network.storage;

import com.base.network.exeption.StoragExeption;
import com.base.network.model.Resume;

import java.util.Arrays;
import java.util.List;

public abstract class AbstractArreyStorage extends AbstractStorage {
    public static final int STORAGE_LIMIT = 10000;
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


    @Override
    protected void doUpdate(Resume r, Object searchKey) {
        storage[(Integer) searchKey] = r;
    }

    //    public void update(Resume r) {
//        int index = getSearchKay(r.getUuid());
//        if (index != -1) {
//            throw new NotExistStorageExeption(r.getUuid());
//        } else {
//            storage[index] = r;
//        }
//    }
    @Override
    public List<Resume> doCopiAll() {
        return Arrays.asList(Arrays.copyOfRange(storage, 0, size));
//        Resume[] result = new Resume[size];
//        for (int i = 0; i < size; i++) {
//            result[i] = storage[i];
//        }
//        return result;
    }

    @Override
    protected void doSave(Resume r, Object searchKey) {
        if (size == storage.length) {
            throw new StoragExeption("Storage overflow", r.getUuid());
        } else {
            isertElement(r, (Integer) searchKey);
            size++;
        }
    }

//    public void save(Resume r) {
//        int index = getSearchKay(r.getUuid());
//        if (index >= 0) {
//            throw new ExistStorageExeption(r.getUuid());
//        } else if (size == storage.length) {
//            throw new StoragExeption("Storage overflow", r.getUuid());
//        } else {
//            isertElement(r, index);
//            size++;
//        }
//    }


    @Override
    protected void doDelate(Object searchKey) {
        fillDeletedElement((Integer) searchKey);
        storage[size - 1] = null;
        size--;
    }

//    public void delete(String uuid) {
//        int index = getSearchKay(uuid);
//        if (index < 0) {
//            throw new NotExistStorageExeption(uuid);
//        } else {
//            fillDeletedElement(index);
//            storage[size - 1] = null;
//            size--;
//        }
//
//    }

    @Override
    protected Resume doGet(Object searchKey) {
        return storage[(Integer) searchKey];
    }

//    public Resume get(String uuid) {
//        int index = getSearchKay(uuid);
//        if (index < 0) {
//            throw new NotExistStorageExeption(uuid);
//        }
//        return storage[index];
//    }

    @Override
    protected boolean isExist(Object searchKey) {
        return (Integer) searchKey >= 0;
    }

    protected abstract void fillDeletedElement(int index);

    protected abstract void isertElement(Resume r, int index);

    protected abstract Integer getSearchKey(String uuid);


}
