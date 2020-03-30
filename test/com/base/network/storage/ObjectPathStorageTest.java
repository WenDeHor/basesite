package com.base.network.storage;

import com.base.network.storage.serializer.ObgectStreamSerializer;

public class ObjectPathStorageTest extends AbstractStorageTest {

    public ObjectPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new ObgectStreamSerializer()));
    }
}