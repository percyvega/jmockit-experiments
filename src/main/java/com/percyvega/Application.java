package com.percyvega;

import com.percyvega.model.BibleVerse;
import com.percyvega.service.BibleVerseService;
import com.percyvega.util.BibleVerseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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
            log.info("Random verse: {}", BibleVerseUtil.verseWithReferencePrettyPrint(randomBibleVerse));

            List<BibleVerse> allVerses = bibleVerseService.getAllBibleVerses();
            int i = 0;
            for (BibleVerse bibleVerse : allVerses) {
                log.info("Verse {} found in the database: {}", ++i, BibleVerseUtil.verseWithReferencePrettyPrint(bibleVerse));
            }

        } catch (SQLException ex) {
            log.error(ex.getMessage(), ex);
        }
    }

}
