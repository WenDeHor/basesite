package com.base.network.storage;

import com.base.network.exeption.StoragExeption;
import com.base.network.model.Resume;
import com.base.network.storage.serializer.StreamSerializer;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PathStorage extends AbstractStorage<Path> {

    private Path directory;
    private StreamSerializer streamSerializer;

    protected PathStorage(String dir, StreamSerializer streamSerializer) {
        Objects.requireNonNull(dir, "Directory must not be null");
        directory = Paths.get(dir);
        this.streamSerializer = streamSerializer;
        if (!Files.isDirectory(directory) || !Files.isWritable(directory)) {
            throw new IllegalArgumentException(dir + "is not directory or not writable");
        }
    }

    @Override
    protected Path getSearchKey(String uuid) {
        return directory.resolve(uuid);
    }

    @Override
    protected void doUpdate(Resume r, Path path) {
        try {
            streamSerializer.doWrite(r, new BufferedOutputStream(Files.newOutputStream(path)));
        } catch (IOException e) {
            throw new StoragExeption("Path write error ", r.getUuid(), e);
        }
    }

    @Override
    protected boolean isExist(Path path) {
        return Files.isRegularFile(path);
    }

    @Override
    protected void doSave(Resume r, Path path) {
        try {
            Files.createFile(path);
        } catch (IOException e) {
            throw new StoragExeption("Couldn*t create path " + path, getFileName(path), e);
        }
        doUpdate(r, path);
    }


    @Override
    protected void doDelate(Path path) {
        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new StoragExeption("Path delate error", getFileName(path), e);
        }
    }

    @Override
    protected Resume doGet(Path path) {
        try {
            return streamSerializer.doRead(Files.newInputStream(path));
        } catch (IOException e) {
            throw new StoragExeption("Path read error ", getFileName(path), e);
        }
    }

    @Override
    protected List<Resume> doCopiAll() {
        return getFilesList().map(path -> doGet(path)).collect(Collectors.toList());
    }

    @Override
    public void clear() {
        getFilesList().forEach(path -> doDelate(path));
    }


    @Override
    public int size() {
        return (int) getFilesList().count();
    }

    private String getFileName(Path path) {
        return path.getFileName().toString();
    }

    private Stream<Path> getFilesList() {
        try {
            return Files.list(directory);
        } catch (IOException e) {
            throw new StoragExeption("Path delate error", null, e);
        }

    }
}
