package com.base.network.exeption;

public class ExistStorageExeption extends StorageExeption {
    public ExistStorageExeption(String uuid) {
        super("Resume___"+uuid+"___already exist", uuid);
    }
}
