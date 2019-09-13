package com.percyvega.service;

import com.percyvega.model.BibleVerse;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BibleVerseService {

    private final Connection connection;

    public BibleVerseService(Connection connection) {
        this.connection = connection;
    }

    public int initializeDatabase() throws SQLException {
        createVerseTable();
        int recordsInserted = insertAllVerses();
        return recordsInserted;
    }

    private void createVerseTable() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            String sql = "CREATE TABLE VERSE (" +
                    " book INTEGER, " +
                    " chapter INTEGER, " +
                    " verse INTEGER, " +
                    " text VARCHAR(255) " +
                    ")";
            statement.executeUpdate(sql);

        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
    }

    private int insertAllVerses() throws SQLException {
        int recordsInserted = 0;

        try (Statement statement = connection.createStatement()) {
            String sql = "INSERT INTO VERSE VALUES (46, 5, 7, 'For we walk by faith, not by sight.')";
            statement.executeUpdate(sql);
            recordsInserted++;
            sql = "INSERT INTO VERSE VALUES (45, 16, 14, 'Let all that you do be done in love.')";
            statement.executeUpdate(sql);
            recordsInserted++;
            sql = "INSERT INTO VERSE VALUES (19, 16, 3, 'Commit your work to the Lord, and your plans will be established.')";
            statement.executeUpdate(sql);
            recordsInserted++;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }

        return recordsInserted;
    }

    public BibleVerse getRandomVerse() throws SQLException {
        try (Statement statement = connection.createStatement()) {
            int randomVerseIndex = getRandomVerseIndex(statement);
            return getAllBibleVerses().get(randomVerseIndex);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
    }

    public int getRandomVerseIndex(Statement statement) throws SQLException {
        int count = getCount(statement);
        return getRandomInt(count);
    }

    public int getCount(Statement statement) throws SQLException {
        int count = 0;
        ResultSet resultSet = statement.executeQuery("SELECT COUNT(*) count FROM VERSE");
        if (resultSet.next()) {
            count = resultSet.getInt("count");
        }
        return count;
    }

    public int getRandomInt(int count) {
        return new Random().nextInt(count);
    }

    public List<BibleVerse> getAllBibleVerses() throws SQLException {
        List<BibleVerse> bibleVerses = new ArrayList<>();
        try (Statement statement = connection.createStatement()) {
            ResultSet resultSet = statement.executeQuery("SELECT * FROM VERSE");
            while (resultSet.next()) {
                BibleVerse bibleVerse = new BibleVerse(
                        resultSet.getInt("book"),
                        resultSet.getInt("chapter"),
                        resultSet.getInt("verse"),
                        resultSet.getString("text"));

                bibleVerses.add(bibleVerse);
            }
            return bibleVerses;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException(e);
        }
    }
}
