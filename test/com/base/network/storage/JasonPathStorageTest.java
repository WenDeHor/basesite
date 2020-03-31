package com.base.network.storage;

import com.base.network.storage.serializer.JsonStreamSerializor;

public class JasonPathStorageTest extends AbstractStorageTest {

    public JasonPathStorageTest() {
        super(new PathStorage(STORAGE_DIR.getAbsolutePath(), new JsonStreamSerializor()));
    }
}