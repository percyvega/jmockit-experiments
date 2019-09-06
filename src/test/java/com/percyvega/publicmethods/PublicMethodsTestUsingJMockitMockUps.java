package com.percyvega.publicmethods;

import com.percyvega.model.BibleVerse;
import com.percyvega.service.BibleVerseService;
import com.percyvega.util.BibleVerseUtil;
import mockit.Mock;
import mockit.MockUp;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static org.assertj.core.api.Assertions.assertThat;

class PublicMethodsTestUsingJMockitMockUps {

    @Test
    void bibleVerse_getTranslation() {
        new MockUp<BibleVerse>() {
            @Mock
            public BibleVerse.Translation getTranslation() {
                return BibleVerse.Translation.UNUSED;
            }
        };

        BibleVerse defaultVerse = BibleVerseUtil.getDefaultVerse();
        assertThat(defaultVerse.getTranslation()).isEqualTo(BibleVerse.Translation.UNUSED);
    }

    @Test
    void bibleVerseService_getCount() throws SQLException {
        new MockUp<BibleVerseService>() {
            @Mock
            public int getCount(Statement statement) {
                return 5;
            }

            @Mock
            public int getRandomInt(int count) {
                return 2;
            }
        };

        BibleVerseService bibleVerseService = new BibleVerseService(null);
        int verseIndex = bibleVerseService.getRandomVerseIndex(null);
        assertThat(verseIndex).isEqualTo(2);
    }
}
