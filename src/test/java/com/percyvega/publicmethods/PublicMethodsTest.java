package com.percyvega.publicmethods;

import com.percyvega.model.BibleVerse;
import com.percyvega.util.BibleVerseUtil;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

class PublicMethodsTest {

    @Test
    void bibleVerse_getTranslation() {
        BibleVerse defaultVerse = BibleVerseUtil.getDefaultVerse();
        assertThat(defaultVerse.getTranslation()).isEqualTo(BibleVerse.Translation.ESV);
    }

    @Test
    void bibleVerseService_getCount() throws SQLException {
        // We can't test this as a simple unit test, only as an integration test
    }
}
