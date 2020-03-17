package com.base.network.exeption;

public class NotExistStorageExeption extends StoragExeption {
    public NotExistStorageExeption(String uuid) {
        super("Recume"+uuid+"not exist", uuid);
    }
}
