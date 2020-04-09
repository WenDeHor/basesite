package com.base.network;

import com.base.network.model.*;

import java.time.Month;
import java.util.UUID;

public class TestData {

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
    public static final String UUID_1 = UUID.randomUUID().toString();
    public static final String UUID_2 = UUID.randomUUID().toString();
    public static final String UUID_3 = UUID.randomUUID().toString();
    public static final String UUID_4 = UUID.randomUUID().toString();

    public static final Resume R1;
    public static final Resume R2;
    public static final Resume R3;
    public static final Resume R4;

    static {
        R1 = new Resume(UUID_1, "Name1");
        R2 = new Resume(UUID_2, "Name2");
        R3 = new Resume(UUID_3, "Name3");
        R4 = new Resume(UUID_4, "Name4");
        R1.addContact(ContactType.MOBILE, "380123456789");
        R1.addContact(ContactType.MAIL, "mail@mail.com");
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



        R2.addContact(ContactType.MOBILE, "380123456789");
        R2.addContact(ContactType.MAIL, "mail222@mail.com");
        R2.addSection(SectionType.OBJECTIVE, new TextSection("Позиція2"));
        R2.addSection(SectionType.PERSONAL, new TextSection("Особисті дані2"));
        R2.addSection(SectionType.ACHIEVEMENT, new ListSection("Досягнення 2", "Досягнення 3", "Досягнення 4"));
        R2.addSection(SectionType.QUALIFICATIONCE, new ListSection("java", "SQL"));
        R2.addSection(SectionType.EXPERIENCE,
                new OrganizationSections(
                        new Organization("IT java", null,
                                new Organization.Position(2003, Month.JANUARY, "position 2", "content 2"))));
        R2.addSection(SectionType.EDUCATION, new OrganizationSections(new Organization("Institute", null,
                new Organization.Position(2000, Month.SEPTEMBER, 2001, Month.APRIL, "Specialist2", "Bilding2"))));
    }
}
