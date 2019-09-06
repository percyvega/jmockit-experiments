package com.percyvega.privatemethods;

import com.percyvega.service.BibleVerseService;
import mockit.Expectations;
import mockit.Mocked;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PrivateMethodsTestUsingJMockitMockUps {

    @Test
    @DisplayName("Doesn't work. Deencapsulation.invoke is no longer available (since the latest version of JMockit)")
    void bibleVerseService(@Mocked BibleVerseService bibleVerseService) {
        new Expectations() {{

        }};
    }

}
