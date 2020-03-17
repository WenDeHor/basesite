package com.base.network.exeption;

public class ExistStorageExeption extends StoragExeption{
    public ExistStorageExeption(String uuid) {
        super("Resume"+uuid+"already exist", uuid);
    }
}
