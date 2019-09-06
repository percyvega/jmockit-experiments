package com.percyvega;

import com.percyvega.model.BibleVerse;
import com.percyvega.service.BibleVerseService;
import com.percyvega.util.BibleVerseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.List;

public class Application {

    private static final Logger log = LogManager.getLogger(Application.class);

    public static void main(String[] args) {

        String url = "jdbc:h2:mem:";

        try (Connection connection = DriverManager.getConnection(url)) {

            BibleVerseService bibleVerseService = new BibleVerseService(connection);

            int recordsInserted = bibleVerseService.initializeDatabase();
            log.info("Database initialized with " + recordsInserted + " records.");

            BibleVerse randomBibleVerse = bibleVerseService.getRandomVerse();
            log.info(randomBibleVerse);

            List<BibleVerse> allVerses = bibleVerseService.getAllBibleVerses();
            for (BibleVerse bibleVerse : allVerses) {
                log.info(BibleVerseUtil.bibleVerseToString(bibleVerse));
            }
        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

}
