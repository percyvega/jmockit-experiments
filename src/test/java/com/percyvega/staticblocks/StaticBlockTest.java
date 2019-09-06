package com.percyvega.staticblocks;

import com.percyvega.model.BibleVerse;
import com.percyvega.util.BibleVerseUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class StaticBlockTest {

    private static final Logger log = LogManager.getLogger(StaticBlockTest.class);

    @Disabled
    @Test
    @DisplayName("Doesn't work when running as part of the test suite.")
    void bibleVerseUtil_staticBlock() {
        BibleVerse bibleVerse = BibleVerseUtil.getDefaultVerse();
        assertThat(BibleVerseUtil.getPrettyPrintReference(bibleVerse)).isEqualTo("John 3:16 (ESV)");
    }

}
