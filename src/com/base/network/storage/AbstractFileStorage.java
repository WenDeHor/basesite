package com.base.network.storage;

import com.base.network.exeption.StoragExeption;
import com.base.network.model.Resume;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractFileStorage extends AbstractStorage<File> {
    private File directory;

    protected AbstractFileStorage(File directory) {
        Objects.requireNonNull(directory, "Directory must not be null");
        if (!directory.isDirectory()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not directory");
        }
        if (!directory.canRead() || !directory.canWrite()) {
            throw new IllegalArgumentException(directory.getAbsolutePath() + "is not readable/writable");
        }
        this.directory = directory;
    }

    @Override
    protected File getSearchKey(String uuid) {
        return new File(directory, uuid);
    }

    @Override
    protected void doUpdate(Resume r, File file) {
        try {
            doWrite(r, file);
        } catch (IOException e) {
            throw new StoragExeption("File write error ", r.getUuid(), e);
        }
    }

    @Override
    protected boolean isExist(File file) {
        return file.exists();
    }

    @Override
    protected void doSave(Resume r, File file) {
        try {
            file.createNewFile();
            doWrite(r, file);
        } catch (IOException e) {
            throw new StoragExeption("Couldn*t create file "+ file.getAbsolutePath(), file.getName(), e);
        }
        doUpdate(r, file);
    }

    protected abstract void doWrite(Resume r, File file) throws IOException;
    protected abstract Resume doRead(File file) throws IOException;

    @Override
    protected void doDelate(File file) {
        if (!file.delete()) {
            throw new StoragExeption("File delate error ", file.getName());
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return doRead(file);
        } catch (IOException e) {
            throw new StoragExeption("File read error ", file.getName(), e);
        }
    }

    @Override
    protected List<Resume> doCopiAll() {
        File[]files=directory.listFiles();
        if(files==null){
            throw new StoragExeption("Directory read error", null);
        }
        List<Resume>list=new ArrayList<>(files.length);
        for(File file:files){
            list.add(doGet(file));
        }
        return list;
    }

    @Override
    public void clear() {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                doDelate(file);
            }
        }
    }

    @Override
    public int size() {
        String[] list = directory.list();
        if (list == null) {
            throw new StoragExeption("Directory error read", null);
        }
        return list.length;
    }
}
