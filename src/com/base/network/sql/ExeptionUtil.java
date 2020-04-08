package com.base.network.sql;

import com.base.network.exeption.ExistStorageExeption;
import com.base.network.exeption.StorageExeption;
import org.postgresql.util.PSQLException;

import java.sql.SQLException;

public class ExeptionUtil {

    public ExeptionUtil() {
    }

    public static StorageExeption convertExeption(SQLException e) {
        if (e instanceof PSQLException) {
            if (e.getSQLState().equals("23505")) {
                return new ExistStorageExeption(null);
            }
        }
        return new StorageExeption(e);
    }

}
