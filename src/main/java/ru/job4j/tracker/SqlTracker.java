package ru.job4j.tracker;

import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class SqlTracker implements Store, AutoCloseable {

    private Connection connection;

    public void init() {
        try (InputStream in = SqlTracker.class.getClassLoader().getResourceAsStream("app.properties")) {
            Properties config = new Properties();
            config.load(in);
            Class.forName(config.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    config.getProperty("url"),
                    config.getProperty("username"),
                    config.getProperty("password")
            );
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    @Override
    public Item add(Item item) {
        try (PreparedStatement ps = connection.prepareStatement("insert into items(name, created) values (?, ?);",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.execute();
            try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    item.setId(generatedKeys.getInt(1));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    @Override
    public boolean replace(int id, Item item) {
        boolean rsl = false;
        try (PreparedStatement ps = connection
                .prepareStatement("update items set name = ?, created = ? where id = ?;")) {
            ps.setString(1, item.getName());
            ps.setTimestamp(2, Timestamp.valueOf(item.getCreated()));
            ps.setInt(3, id);
            rsl = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public boolean delete(int id) {
        boolean rsl = false;
        try (PreparedStatement ps = connection.prepareStatement("delete from items where id = ?;")) {
            ps.setInt(1, id);
            rsl = ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findAll() {
        List<Item> rsl = new ArrayList<>();
        String sql = "select * from items;";
        try (Statement s = connection.createStatement()) {
            try (ResultSet rs = s.executeQuery(sql)) {
                while (rs.next()) {
                    Item item = new Item();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setCreated(rs.getTimestamp("created").toLocalDateTime());
                    rsl.add(item);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        try (PreparedStatement ps = connection.prepareStatement("select * from items where name = ?;")) {
            ps.setString(1, key);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                while (rs.next()) {
                    Item item = new Item();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setCreated(rs.getTimestamp("created").toLocalDateTime());
                    rsl.add(item);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rsl;
    }

    @Override
    public Item findById(int id) {
        Item item = null;
        try (PreparedStatement ps = connection.prepareStatement("select * from items where id = ?;")) {
            ps.setInt(1, id);
            ps.execute();
            try (ResultSet rs = ps.getResultSet()) {
                if (rs.next()) {
                    item = new Item();
                    item.setId(rs.getInt("id"));
                    item.setName(rs.getString("name"));
                    item.setCreated(rs.getTimestamp("created").toLocalDateTime());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return item;
    }
}
