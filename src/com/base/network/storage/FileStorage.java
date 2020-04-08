package com.base.network.storage;

import com.base.network.exeption.StorageExeption;
import com.base.network.model.Resume;
import com.base.network.storage.serializer.StreamSerializer;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FileStorage extends AbstractStorage<File> {
    private File directory;
    private StreamSerializer streamSerializer;

    protected FileStorage(File directory, StreamSerializer streamSerializer) {
        Objects.requireNonNull(directory, "Directory must not be null");
        this.streamSerializer=streamSerializer;
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
            streamSerializer.doWrite(r, new BufferedOutputStream(new FileOutputStream(file)));
        } catch (IOException e) {
            throw new StorageExeption("File write error ", r.getUuid(), e);
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
        } catch (IOException e) {
            throw new StorageExeption("Couldn*t create file " + file.getAbsolutePath(), file.getName(), e);
        }
        doUpdate(r, file);
    }



    @Override
    protected void doDelate(File file) {
        if (!file.delete()) {
            throw new StorageExeption("File delate error ", file.getName());
        }
    }

    @Override
    protected Resume doGet(File file) {
        try {
            return streamSerializer.doRead(new BufferedInputStream(new FileInputStream(file)));
        } catch (IOException e) {
            throw new StorageExeption("File read error ", file.getName(), e);
        }
    }

    @Override
    protected List<Resume> doCopiAll() {
        File[] files = directory.listFiles();
        if (files == null) {
            throw new StorageExeption("Directory read error");
        }
        List<Resume> list = new ArrayList<>(files.length);
        for (File file : files) {
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
            throw new StorageExeption("Directory error read");
        }
        return list.length;
    }
}
