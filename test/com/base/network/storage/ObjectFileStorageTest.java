package com.base.network.storage;

import com.base.network.storage.serializer.ObgectStreamSerializer;

public class ObjectFileStorageTest extends AbstractStorageTest {

    public ObjectFileStorageTest() {
        super(new FileStorage(STORAGE_DIR, new ObgectStreamSerializer()));
    }
}