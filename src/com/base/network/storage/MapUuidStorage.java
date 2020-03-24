package com.base.network.storage;

import com.base.network.model.Resume;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUuidStorage extends AbstractStorage<String> {
    private Map<String, Resume> map = new HashMap<>();

    @Override
    protected String getSearchKey(String uuid) {
        return uuid;
    }

    @Override
    protected void doUpdate(Resume r, String searchKey) {
        map.put(searchKey, r);
    }

    @Override
    protected boolean isExist(String searchKey) {
        return map.containsKey(searchKey); // перевірка чи є ключ
    }

    @Override
    protected void doSave(Resume r, String searchKey) {
        map.put(searchKey, r);
    }

    @Override
    protected void doDelate(String searchKey) {
        map.remove(searchKey);

    }

    @Override
    protected Resume doGet(String searchKey) {
        return map.get(searchKey);
    }

    @Override
    public void clear() {
        map.clear();

    }

    @Override
    public List<Resume> doCopiAll() {
        return new ArrayList<>(map.values());
    }

    @Override
    public int size() {
        return map.size();
    }
}
