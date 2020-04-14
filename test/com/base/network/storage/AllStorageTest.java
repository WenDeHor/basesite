package com.base.network.storage;

import com.base.network.util.JsonParserTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ArrayStorageTest.class,
        SortedArrayStorageTest.class,
        ListStorageTest.class,
        MapUuidStorageTest.class,
        MapResumeStorageTest.class,
        ObjectPathStorageTest.class,
        ObjectFileStorageTest.class,
        XmlPathStorageTest.class,
        JasonPathStorageTest.class,
        DataPathStorageTest.class,
        SqlStorageTest.class,
        JsonParserTest.class
})
public class AllStorageTest {
}
