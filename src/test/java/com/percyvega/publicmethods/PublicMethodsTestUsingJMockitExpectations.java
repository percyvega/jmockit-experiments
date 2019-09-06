package com.percyvega.publicmethods;

import com.percyvega.model.BibleVerse;
import com.percyvega.service.BibleVerseService;
import com.percyvega.util.BibleVerseUtil;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;
import java.sql.Statement;

import static com.percyvega.model.BibleVerse.Translation.UNUSED;
import static org.assertj.core.api.Assertions.assertThat;

class PublicMethodsTestUsingJMockitExpectations {

    @Test
    void bibleVerse_getTranslation(@Mocked BibleVerse mockedBibleVerse) {
        new Expectations() {{
            mockedBibleVerse.getTranslation();
            result = BibleVerse.Translation.UNUSED;
        }};

        assertThat(mockedBibleVerse.getTranslation()).isEqualTo(UNUSED);

        BibleVerse bibleVerse = BibleVerseUtil.getDefaultVerse();
        assertThat(bibleVerse.getTranslation()).isEqualTo(UNUSED);
    }

    @Disabled
    @Test
    @DisplayName("Doesn't work")
    void bibleVerseService_getCount(@Mocked BibleVerseService bibleVerseService) throws SQLException {
        new Expectations() {{
            bibleVerseService.getCount((Statement) any);
            result = 2;
            bibleVerseService.getRandomInt(anyInt);
            result = 1;
        }};

        Statement statement = null;
        int verseIndex = bibleVerseService.getRandomVerseIndex(statement);
        assertThat(verseIndex).isEqualTo(1);
    }
}
