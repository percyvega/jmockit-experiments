package com.percyvega.staticmethods;

import com.percyvega.model.BibleVerse;
import com.percyvega.util.BibleVerseUtil;
import mockit.Mock;
import mockit.MockUp;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StaticMethodsTestUsingJMockitMockUps {

    @Test
    void bibleVerseUtil_setChapterVerseSeparator() {
        new MockUp<BibleVerseUtil>() {
            @Mock
            public String getChapterVerseSeparator() {
                return ".";
            }
        };

        BibleVerse bibleVerse = BibleVerseUtil.getDefaultVerse();
        String prettyPrintReference = BibleVerseUtil.getPrettyPrintReference(bibleVerse);
        assertThat(prettyPrintReference).isEqualTo("John 3.16 (ESV)");
    }
}
