package com.base.network.model.exeption;

public class NotExistStorageExeption extends StoragExeption {
    public NotExistStorageExeption(String uuid) {
        super("Resume___"+uuid+"___not exist", uuid);
    }
}
