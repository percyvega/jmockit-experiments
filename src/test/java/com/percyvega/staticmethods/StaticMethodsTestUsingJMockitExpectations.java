package com.percyvega.staticmethods;

import com.percyvega.model.BibleVerse;
import com.percyvega.util.BibleVerseUtil;
import mockit.Expectations;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StaticMethodsTestUsingJMockitExpectations {

    @Test
    @DisplayName("Doesn't work")
    void bibleVerseUtil_setChapterVerseSeparator() {

        new Expectations() {
            BibleVerseUtil bibleVerseUtil;

            {
                BibleVerseUtil.getChapterVerseSeparator();
                result = ".";
            }
        };

        BibleVerse bibleVerse = BibleVerseUtil.getDefaultVerse();
        String prettyPrintReference = BibleVerseUtil.getPrettyPrintReference(bibleVerse);
        assertThat(prettyPrintReference).isEqualTo("John 3.16 (ESV)");
    }

}
