package com.percyvega.staticmethods;

import com.percyvega.model.BibleVerse;
import com.percyvega.util.BibleVerseUtil;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StaticMethodsTest {

    @Test
    void bibleVerseUtil_setChapterVerseSeparator() {
        BibleVerse bibleVerse = new BibleVerse(42, 11, 35, "Jesus Wept.");

        BibleVerseUtil.setChapterVerseSeparator(".");

        String prettyPrintReference = BibleVerseUtil.getPrettyPrintReference(bibleVerse);
        assertThat(prettyPrintReference).isEqualTo("John 11.35 (ESV)");
    }

}
