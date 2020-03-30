package com.base.network.exeption;

public class StoragExeption extends RuntimeException {

    private final String uuid;

    public StoragExeption(String masage) {
        this(masage, null, null);
    }

    public StoragExeption(String masage, String uuid) {
        super(masage);
        this.uuid = uuid;
    }

    public StoragExeption(String masage, Exception e) {
        this(masage, null, e);
    }

    public StoragExeption(String masage, String uuid, Exception e) {
        super(masage, e);
        this.uuid = uuid;
    }

}
