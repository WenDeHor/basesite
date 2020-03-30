package com.base.network.storage;

import com.base.network.exeption.ExistStorageExeption;
import com.base.network.exeption.NotExistStorageExeption;
import com.base.network.model.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.time.Month;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public abstract class AbstractStorageTest {
    protected static final File STORAGE_DIR = new File("F:\\FATHER\\BASE\\basesite\\storage");
    protected Storage storage;
    //    private static final String UUID_1 = "uuid_1";
//    private static final Resume RESUME_1 = new Resume(UUID_1);
//
//    private static final String UUID_2 = "uuid_2";
//    private static final Resume RESUME_2 = new Resume(UUID_2);
//
//    private static final String UUID_3 = "uuid_3";
//    private static final Resume RESUME_3 = new Resume(UUID_3);
//
//    private static final String UUID_4 = "uuid_4";
//    private static final Resume RESUME_4 = new Resume(UUID_4);
    private static final String UUID_1 = "uuid1";
    private static final String UUID_2 = "uuid2";
    private static final String UUID_3 = "uuid3";
    private static final String UUID_4 = "uuid4";

    private static final Resume R1;
    private static final Resume R2;
    private static final Resume R3;
    private static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");
//        R1.addContact(ContactType.MOBILE, "380123456789");
//        R1.addContact(ContactType.MAIL, "mail@mail.com");
        R1.addSection(SectionType.OBJECTIVE, new TextSection("Позиція"));
        R1.addSection(SectionType.PERSONAL, new TextSection("Особисті дані"));
        R1.addSection(SectionType.ACHIEVEMENT, new ListSection("Досягнення 1", "Досягнення 2", "Досягнення 3"));
        R1.addSection(SectionType.QUALIFICATIONCE, new ListSection("java", "SQL"));
        R1.addSection(SectionType.EXPERIENCE,
                new OrganizationSections(
                        new Organization("IT", "https:",
                                new Organization.Position(2001, Month.JANUARY, "position 1", "content 1"),
                                new Organization.Position(2002, Month.MARCH, 2005, Month.JANUARY, "position 2", "content 2"))));
        R1.addSection(SectionType.EDUCATION, new OrganizationSections(new Organization("Institute", null,
                new Organization.Position(2003, Month.SEPTEMBER, 2008, Month.APRIL, "Specialist", "Bilding"))));


//
//        R2.addContact(ContactType.MOBILE, "380123456789");
//        R2.addContact(ContactType.MAIL, "mail222@mail.com");
//        R2.addSection(SectionType.OBJECTIVE, new TextSection("Позиція2"));
//        R2.addSection(SectionType.PERSONAL, new TextSection("Особисті дані2"));
//        R2.addSection(SectionType.ACHIEVEMENT, new ListSection("Досягнення 2", "Досягнення 3", "Досягнення 4"));
//        R2.addSection(SectionType.QUALIFICATIONCE, new ListSection("java", "SQL"));
//        R2.addSection(SectionType.EXPERIENCE,
//                new OrganizationSections(
//                        new Organization("IT java", null,
//                                new Organization.Position(2003, Month.JANUARY, "position 2", "content 2"))));
//        R2.addSection(SectionType.EDUCATION, new OrganizationSections(new Organization("Institute", null,
//                new Organization.Position(2000, Month.SEPTEMBER, 2001, Month.APRIL, "Specialist2", "Bilding2"))));
    }

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
        Resume newResume = new Resume(UUID_1, "new Name");
        storage.update(newResume);
        assertTrue(newResume.equals(storage.get(UUID_1)));
    }

    @Test(expected = NotExistStorageExeption.class)
    public void updateNotExist() {
        storage.get("dummy");
    }


    @Test
    public void getAllSorted() throws Exception {
        List<Resume> list = storage.getAllSorted();
        assertEquals(3, list.size());
        assertEquals(list, Arrays.asList(R1, R2, R3));
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