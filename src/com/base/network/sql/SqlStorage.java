package com.base.network.sql;

import com.base.network.exeption.NotExistStorageExeption;
import com.base.network.exeption.StoragExeption;
import com.base.network.model.Resume;
import com.base.network.storage.Storage;

import java.sql.*;
import java.util.List;

public class SqlStorage implements Storage {
    public final ConnectionFactory connectionFactory;

    public SqlStorage(String dbUrl, String dbUser, String dbPassword) {
        connectionFactory = () -> DriverManager.getConnection(dbUrl, dbUser, dbPassword);
    }


    @Override
    public void clear() {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("DELETE from resume");
            ps.execute();
        } catch (SQLException e) {
            throw new StoragExeption(e);
        }
    }

    @Override
    public void save(Resume r) {
     try (Connection connection = connectionFactory.getConnection()) {
      PreparedStatement ps = connection.prepareStatement("INSERT INTO resume (uuid, full_name) values (?,?)");
      ps.setString(1, r.getUuid());
      ps.setString(2, r.getFullName());
      ps.execute();
     } catch (SQLException e) {
      throw new StoragExeption(e);
     }
    }

    @Override
    public void update(Resume r) {

    }

    @Override
    public Resume get(String uuid) {
        try (Connection connection = connectionFactory.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("Select * from resume r where r.uuid=?");
            ps.setString(1, uuid);
            ResultSet rs = ps.executeQuery();
            if (!rs.next()) {
                throw new NotExistStorageExeption(uuid);
            }
            Resume r = new Resume(uuid, rs.getString("full_name"));
            ps.execute();
            return r;
        } catch (SQLException e) {
            throw new StoragExeption(e);
        }
    }

    @Override
    public void delete(String uuid) {

    }

    @Override
    public List<Resume> getAllSorted() {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }
}
