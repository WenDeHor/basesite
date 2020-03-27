package com.base.network.exeption;

public class ExistStorageExeption extends StoragExeption{
    public ExistStorageExeption(String uuid) {
        super("Resume___"+uuid+"___already exist", uuid);
    }
}
