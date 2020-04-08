package com.base.network.exeption;

public class NotExistStorageExeption extends StorageExeption {
    public NotExistStorageExeption(String uuid) {
        super("Resume___"+uuid+"___not exist", uuid);
    }
}
