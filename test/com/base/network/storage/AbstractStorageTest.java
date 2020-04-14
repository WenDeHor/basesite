package com.base.network.storage;

import com.base.network.Config;
import com.base.network.exeption.ExistStorageExeption;
import com.base.network.exeption.NotExistStorageExeption;
import com.base.network.model.ContactType;
import com.base.network.model.Resume;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static com.base.network.TestData.*;
import static org.junit.Assert.assertEquals;

public abstract class AbstractStorageTest {
    protected static final File STORAGE_DIR = Config.get().getStorageDir();

    protected Storage storage;

    public AbstractStorageTest(Storage storage) {
        this.storage = storage;
    }

    @Before
    public void setUp() throws Exception {
        storage.clear();

        storage.save(R1);
        storage.save(R2);
        storage.save(R3);
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

    @Test
    public void update() {
        Resume newResume = new Resume(UUID_1, "newName");
        R1.setContact(ContactType.MOBILE, "54789");
        R1.setContact(ContactType.MAIL, "sdfsdfsdf@mail.com");

        storage.update(newResume);
        assertEquals(newResume, storage.get(UUID_1));
    }

    @Test(expected = NotExistStorageExeption.class)
    public void updateNotExist() {
        storage.get("dummy");
    }


    @Test
    public void getAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        List<Resume>sortResume=Arrays.asList(R1,R2,R3);
        Collections.sort(sortResume);
        assertEquals(sortResume, list);
    }

    //    @Test
//    public void getAll() throws Exception {
//        Resume[] arrey = storage.getAllSorted();
//        assertEquals(3, arrey.length);
//        assertEquals(RESUME_1, arrey[0]);
//        assertEquals(RESUME_2, arrey[1]);
//        assertEquals(RESUME_3, arrey[2]);
//    }
    @Test
    public void save() {
        storage.save(R4);
        assertSize(4);
        assertGet(R4);
//        assertEquals(RESUME_4, storage.get(UUID_4));
    }

    @Test(expected = ExistStorageExeption.class)
    public void saveExist() {
        storage.save(R1);
    }

    @Test(expected = NotExistStorageExeption.class)
    public void delete() {
        storage.delete(UUID_1);
        assertSize(2);
        storage.get(UUID_1);
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
        assertGet(R1);
        assertGet(R2);
        assertGet(R3);
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