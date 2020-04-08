package com.base.network.exeption;

public class StorageExeption extends RuntimeException {

    private final String uuid;

    public StorageExeption(String masage) {
        this(masage, null, null);
    }

    public StorageExeption(String masage, String uuid) {
        super(masage);
        this.uuid = uuid;
    }

    public StorageExeption(Exception e) {
        this(e.getMessage(), e);
    }

    public StorageExeption(String masage, Exception e) {
        this(masage, null, e);
    }

    public StorageExeption(String masage, String uuid, Exception e) {
        super(masage, e);
        this.uuid = uuid;
    }


}
