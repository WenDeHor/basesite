package com.base.network.storage;

import com.base.network.exeption.ExistStorageExeption;
import com.base.network.exeption.NotExistStorageExeption;
import com.base.network.exeption.StoragExeption;
import com.base.network.model.Resume;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public abstract class AbstractArreyStorageTest {
    private Storage storage;
    private static final String UUID_1 = "uuid_1";
    private static final Resume RESUME_1 = new Resume(UUID_1);

    private static final String UUID_2 = "uuid_2";
    private static final Resume RESUME_2 = new Resume(UUID_2);

    private static final String UUID_3 = "uuid_3";
    private static final Resume RESUME_3 = new Resume(UUID_3);

    private static final String UUID_4 = "uuid_4";
    private static final Resume RESUME_4 = new Resume(UUID_4);

    public AbstractArreyStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();

        storage.save(RESUME_1);
        storage.save(RESUME_2);
        storage.save(RESUME_3);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void size() {
        assertSize(3);
    }

    @Test
    public void clear() {
        storage.clear();
        assertSize(0);
    }

    @Test(expected = NotExistStorageExeption.class)
    public void update() {
        Resume newResume = new Resume(UUID_1);
        storage.update(newResume);
        assertEquals(newResume, storage.get(UUID_1));
    }
    @Test(expected = NotExistStorageExeption.class)
    public void updateNotExist() {
        storage.get("dummy");
    }

    @Test
    public void getAll() throws Exception {
        Resume[] arrey = storage.getAll();
        assertEquals(3, arrey.length);
        assertEquals(RESUME_1, arrey[0]);
        assertEquals(RESUME_2, arrey[1]);
        assertEquals(RESUME_3, arrey[2]);
    }

    @Test
    public void save() {
        storage.save(RESUME_4);
        assertSize(4);
        assertGet(RESUME_4);
//        assertEquals(RESUME_4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageExeption.class)
    public void saveExist()  {
        storage.save(RESUME_1);
    }

    @Test(expected = StoragExeption.class)
    public void saveOverflove() throws Exception {
        try {
            for (int i = 4; i <= AbstractArreyStorage.STORAGE_LIMIT; i++) {
                storage.save(new Resume());
            }
        } catch (StoragExeption e) {
            Assert.fail(); //досрочний провал теста
        }
        storage.save(new Resume()); //має викиути StoragExeption
    }



    @Test(expected = NotExistStorageExeption.class)
    public void delete() {
        storage.delete(UUID_2);
        assertSize(2);
        storage.get(UUID_2);
    }

    @Test(expected = NotExistStorageExeption.class)
    public void getNotExist() {
        storage.get("dammy");
    }

    @Test(expected = NotExistStorageExeption.class)
    public void delateNotExist() {
        storage.delete("dammy");
    }

    @Test
    public void get() {
        assertGet(RESUME_1);
        assertGet(RESUME_2);
        assertGet(RESUME_3);
//        assertEquals(RESUME_1, storage.get("uuid_1"));
//        assertEquals(RESUME_2, storage.get("uuid_2"));
//        assertEquals(RESUME_3, storage.get("uuid_3"));
    }

    private void assertGet(Resume r) {
        assertEquals(r, storage.get(r.getUuid()));
    }

    private void assertSize(int size) {
        assertEquals(size, storage.size());
    }
}