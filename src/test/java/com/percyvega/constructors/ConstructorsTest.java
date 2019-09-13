package com.percyvega.constructors;

import com.percyvega.model.BibleVerse;
import com.percyvega.util.BibleVerseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConstructorsTest {

    private static final Logger log = LogManager.getLogger(ConstructorsTest.class);

    @Test
    void bibleVerse_constructor1() {
        BibleVerse bibleVerse = new BibleVerse();
        log.info(BibleVerseUtil.verseWithReferencePrettyPrint(bibleVerse));

        assertThat(bibleVerse.getBook()).isEqualTo(42);
        assertThat(bibleVerse.getChapter()).isEqualTo(3);
        assertThat(bibleVerse.getVerse()).isEqualTo(16);
        assertThat(bibleVerse.getText()).isEqualTo("For God so loved the world, that he gave his only Son, that whoever believes in him should not perish but have eternal life.");
        assertThat(bibleVerse.getTranslation()).isEqualTo(BibleVerse.Translation.ESV);
    }

    @Test
    void bibleVerse_constructor1_fromUtil() {
        BibleVerse bibleVerse = BibleVerseUtil.getDefaultVerse();
        log.info(BibleVerseUtil.verseWithReferencePrettyPrint(bibleVerse));

        assertThat(bibleVerse.getBook()).isEqualTo(42);
        assertThat(bibleVerse.getChapter()).isEqualTo(3);
        assertThat(bibleVerse.getVerse()).isEqualTo(16);
        assertThat(bibleVerse.getText()).isEqualTo("For God so loved the world, that he gave his only Son, that whoever believes in him should not perish but have eternal life.");
        assertThat(bibleVerse.getTranslation()).isEqualTo(BibleVerse.Translation.ESV);
    }

    @Test
    void bibleVerse_constructor2() {
        BibleVerse bibleVerse = new BibleVerse(1, 1, 1, "In the beginning, God created the heavens and the earth.");
        log.info(BibleVerseUtil.verseWithReferencePrettyPrint(bibleVerse));

        assertThat(bibleVerse.getBook()).isEqualTo(1);
        assertThat(bibleVerse.getChapter()).isEqualTo(1);
        assertThat(bibleVerse.getVerse()).isEqualTo(1);
        assertThat(bibleVerse.getText()).isEqualTo("In the beginning, God created the heavens and the earth.");
        assertThat(bibleVerse.getTranslation()).isEqualTo(BibleVerse.Translation.KJV);
    }

}
