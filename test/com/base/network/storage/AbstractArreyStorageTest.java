package com.base.network.storage;

import com.base.network.exeption.StorageExeption;
import com.base.network.model.Resume;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractArreyStorageTest extends AbstractStorageTest {

    public AbstractArreyStorageTest(Storage storage) {
        super(storage);
    }

    @Test(expected = StorageExeption.class)
    public void saveOverflove() throws Exception {
        try {
            for (int i = 4; i <= AbstractArreyStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume("max name"+1));
            }
        } catch (StorageExeption e) {
            Assert.fail(); //досрочний провал теста
        }
        storage.save(new Resume("Overflow")); //має викиути StoragExeption
    }


}