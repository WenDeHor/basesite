package com.base.network;

import com.base.network.model.Resume;

import java.util.*;

public class MainCollections {

    private static final String UUID_1 = "uuid_1";
    private static final Resume RESUME_1 = new Resume(UUID_1, "Name1");

    private static final String UUID_2 = "uuid_2";
    private static final Resume RESUME_2 = new Resume(UUID_2, "Name2");

    private static final String UUID_3 = "uuid_3";
    private static final Resume RESUME_3 = new Resume(UUID_3, "Name3");

    private static final String UUID_4 = "uuid_4";
    private static final Resume RESUME_4 = new Resume(UUID_4, "Name4");

    public static void main(String[] args) {
        Collection<Resume> colection = new ArrayList<>();
        colection.add(RESUME_1);
        colection.add(RESUME_2);
        colection.add(RESUME_3);
//TODO #1
        for (Resume r : colection) {
            System.out.println(r);
        }
        System.out.println(colection.toString());
//TODO #2
        colection.removeIf(r -> Objects.equals(r.getUuid(), UUID_1));
//TODO #3
        Iterator<Resume> iterator = colection.iterator();
        while (iterator.hasNext()) {
            Resume r = iterator.next();
            if (Objects.equals(r.getUuid(), UUID_1)) {
                iterator.remove();
            }
            System.out.println(colection.toString());
        }

        System.out.println("MAP bad for");
        Map<String, Resume> map = new HashMap<String, Resume>();
        map.put(UUID_1, RESUME_1);
        map.put(UUID_2, RESUME_2);
        map.put(UUID_3, RESUME_3);

        for (String uuid: map.keySet()){
            System.out.println(map.get(uuid));
        }

        System.out.println("MAP is good");
               for (Map.Entry<String,Resume>entry:map.entrySet()){ // звертаємся по ключах і значеннях
            System.out.println("value = "+entry.getKey().toUpperCase()+", "+"kay = "+entry.getValue());
        }
//        List<Resume> resumes = Arrays.asList(RESUME_1, RESUME_3, RESUME_3);
//        resumes.remove(1);
//        System.out.println(resumes);
    }
}
