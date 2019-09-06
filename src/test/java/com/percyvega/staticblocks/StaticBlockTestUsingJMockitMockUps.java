package com.percyvega.staticblocks;

import com.percyvega.model.BibleVerse;
import com.percyvega.util.BibleVerseUtil;
import mockit.Mock;
import mockit.MockUp;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StaticBlockTestUsingJMockitMockUps {

    private static final Logger log = LogManager.getLogger(StaticBlockTestUsingJMockitMockUps.class);

    @Test
    @DisplayName("Doesn't work. Also, why am I forced to also initialize bookNames when it was an initialized private static final String[] field")
    void bibleVerseUtil_staticBlock() {
        new MockUp<BibleVerseUtil>() {
            @Mock
            public void $clinit() {
                BibleVerseUtil.setChapterVerseSeparator(".");
                BibleVerseUtil.initializeBookNames();
            }
        };

        BibleVerse bibleVerse = BibleVerseUtil.getDefaultVerse();
        assertThat(BibleVerseUtil.getPrettyPrintReference(bibleVerse)).isEqualTo("John 3.16 (ESV)");
    }

}
