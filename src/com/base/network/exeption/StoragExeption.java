package com.base.network.exeption;

public class StoragExeption extends RuntimeException {
    private final String uuid;

    public StoragExeption(String uuid) {
        this.uuid = uuid;
    }

    public StoragExeption(String masage, String uuid) {
        super(masage);
        this.uuid=uuid;

    }
}
