package com.base.network.storage;

import com.base.network.exeption.StoragExeption;
import com.base.network.model.Resume;
import com.base.network.storage.serializer.StreamSerializer;

import java.io.*;

public class ObgectStreamStorage implements StreamSerializer {

    @Override
   public void doWrite(Resume r, OutputStream os) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(os)) {
            oos.writeObject(r);
        }
    }

    @Override
   public Resume doRead(InputStream is) throws IOException {
        try (ObjectInputStream ois = new ObjectInputStream(is)) {
            return (Resume) ois.readObject();
        } catch (ClassNotFoundException e) {
            throw new StoragExeption("Error read resume fo file", null, e);
        }

    }
}
