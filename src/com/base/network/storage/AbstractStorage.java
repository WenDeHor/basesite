package com.base.network.storage;

import com.base.network.exeption.ExistStorageExeption;
import com.base.network.exeption.NotExistStorageExeption;
import com.base.network.model.Resume;

import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;

public abstract class AbstractStorage<SK> implements Storage {
    //    protected final Logger log = Logger.getLogger(getClass().getName());
    private static final Logger LOG = Logger.getLogger(AbstractStorage.class.getName());

    protected abstract SK getSearchKey(String uuid);

    protected abstract void doUpdate(Resume r, SK searchKey);

    protected abstract boolean isExist(SK searchKey);

    protected abstract void doSave(Resume r, SK searchKey);

    protected abstract void doDelate(SK searchKey);

    protected abstract Resume doGet(SK searchKey);

    protected abstract List<Resume> doCopiAll();

    @Override
    public void update(Resume r) {
        LOG.info("Update" + r);
        SK searchKey = getExistetSearchKay(r.getUuid());
        doUpdate(r, searchKey);
    }

    @Override
    public void save(Resume r) {
        LOG.info("Save" + r);
        SK searchKey = getNotExistetSearchKay(r.getUuid());
        doSave(r, searchKey);
    }

    @Override
    public void delete(String uuid) {
        LOG.info("Delete" + uuid);
        SK searchKey = getExistetSearchKay(uuid);
        doDelate(searchKey);
    }

    @Override
    public Resume get(String uuid) {
        LOG.info("Get" + uuid);
        SK searchKey = getExistetSearchKay(uuid);
        return doGet(searchKey);
    }

    private SK getExistetSearchKay(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (!isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " not exist");
            throw new NotExistStorageExeption(uuid);
        }
        return searchKey;
    }

    private SK getNotExistetSearchKay(String uuid) {
        SK searchKey = getSearchKey(uuid);
        if (isExist(searchKey)) {
            LOG.warning("Resume " + uuid + " already exist");
            throw new ExistStorageExeption(uuid);
        }
        return searchKey;
    }

    @Override
    public List<Resume> getAllSorted() {
        LOG.info("GetAllSorted");
        List<Resume> list = doCopiAll();
        Collections.sort(list);
        return list;
    }
}
