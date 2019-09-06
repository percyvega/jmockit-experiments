package com.percyvega.constructors;

import com.percyvega.model.BibleVerse;
import com.percyvega.util.BibleVerseUtil;
import mockit.Invocation;
import mockit.Mock;
import mockit.MockUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ConstructorsTestUsingJMockitMockUps {

    private static final Logger log = LogManager.getLogger(ConstructorsTestUsingJMockitMockUps.class);

    @Test
    void bibleVerse_constructor1() {
        new MockUp<BibleVerse>() {
            @Mock
            public void $init(Invocation invocation) {
                BibleVerse bibleVerse = invocation.getInvokedInstance();
                bibleVerse.setBook(39);
                bibleVerse.setChapter(1);
                bibleVerse.setVerse(1);
                bibleVerse.setText("The book of the genealogy of Jesus Christ, the son of David, the son of Abraham.");
            }
        };

        BibleVerse bibleVerse = new BibleVerse();
        log.info(BibleVerseUtil.bibleVerseToString(bibleVerse));

        assertThat(bibleVerse.getBook()).isEqualTo(39);
        assertThat(bibleVerse.getChapter()).isEqualTo(1);
        assertThat(bibleVerse.getVerse()).isEqualTo(1);
        assertThat(bibleVerse.getText()).isEqualTo("The book of the genealogy of Jesus Christ, the son of David, the son of Abraham.");
        assertThat(bibleVerse.getTranslation()).isEqualTo(BibleVerse.Translation.ESV);
    }

    @Test
    void bibleVerse_constructor1_fromUtil() {
        new MockUp<BibleVerse>() {
            @Mock
            public void $init(Invocation invocation) {
                BibleVerse bibleVerse = invocation.getInvokedInstance();
                bibleVerse.setBook(39);
                bibleVerse.setChapter(1);
                bibleVerse.setVerse(1);
                bibleVerse.setText("The book of the genealogy of Jesus Christ, the son of David, the son of Abraham.");
            }
        };

        BibleVerse bibleVerse = BibleVerseUtil.getDefaultVerse();
        log.info(BibleVerseUtil.bibleVerseToString(bibleVerse));

        assertThat(bibleVerse.getBook()).isEqualTo(39);
        assertThat(bibleVerse.getChapter()).isEqualTo(1);
        assertThat(bibleVerse.getVerse()).isEqualTo(1);
        assertThat(bibleVerse.getText()).isEqualTo("The book of the genealogy of Jesus Christ, the son of David, the son of Abraham.");
        assertThat(bibleVerse.getTranslation()).isEqualTo(BibleVerse.Translation.ESV);
    }

    @Test
    void bibleVerse_constructor2() {
        new MockUp<BibleVerse>() {
            @Mock
            public void $init(Invocation invocation, int book, int chapter, int verse, String text) {
                BibleVerse bibleVerse = invocation.getInvokedInstance();
                bibleVerse.setBook(39);
                bibleVerse.setChapter(1);
                bibleVerse.setVerse(1);
                bibleVerse.setText("The book of the genealogy of Jesus Christ, the son of David, the son of Abraham.");
            }
        };

        BibleVerse bibleVerse = new BibleVerse(0, 0, 0, null);
        log.info(BibleVerseUtil.bibleVerseToString(bibleVerse));

        assertThat(bibleVerse.getBook()).isEqualTo(39);
        assertThat(bibleVerse.getChapter()).isEqualTo(1);
        assertThat(bibleVerse.getVerse()).isEqualTo(1);
        assertThat(bibleVerse.getText()).isEqualTo("The book of the genealogy of Jesus Christ, the son of David, the son of Abraham.");
        assertThat(bibleVerse.getTranslation()).isEqualTo(BibleVerse.Translation.ESV);
    }

}
