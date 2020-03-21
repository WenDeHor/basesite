package com.base.network.storage;

import com.base.network.exeption.ExistStorageExeption;
import com.base.network.exeption.NotExistStorageExeption;
import com.base.network.model.Resume;

public abstract class AbstractStorage implements Storage {

    protected abstract Object getSearchKey(String uuid);

    protected abstract void doUpdate(Resume r, Object searchKey);

    protected abstract boolean isExist(Object searchKey);

    protected abstract void doSave(Resume r, Object searchKey);

    protected abstract void doDelate(Object searchKey);

    protected abstract Resume doGet(Object searchKey);

    @Override
    public void update(Resume r) {
        Object searchKey = getExistetSearchKay(r.getUuid());
        doUpdate(r, searchKey);
    }

    @Override
    public void save(Resume r) {
        Object searchKey = getNotExistetSearchKay(r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public void delete(String uuid) {
        Object searchKey = getExistetSearchKay(uuid);
        doDelate(searchKey);
    }

    @Override
    public Resume get(String uuid) {
        Object searchKey = getExistetSearchKay(uuid);
        return doGet(searchKey);
    }

    private Object getExistetSearchKay(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            throw new NotExistStorageExeption(uuid);
        }
        return searchKey;
    }

    private Object getNotExistetSearchKay(String uuid) {
        Object searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            throw new ExistStorageExeption(uuid);
        }
        return searchKey;
    }


}
