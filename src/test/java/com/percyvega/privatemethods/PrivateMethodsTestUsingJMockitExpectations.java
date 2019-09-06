package com.percyvega.privatemethods;

import com.percyvega.service.BibleVerseService;
import mockit.Injectable;
import mockit.Mock;
import mockit.MockUp;
import mockit.Tested;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;

import static org.assertj.core.api.Assertions.assertThat;

class PrivateMethodsTestUsingJMockitExpectations {

    @Injectable
    private Connection connection;

    @Tested
    private BibleVerseService bibleVerseService;

    @Disabled
    @Test
    @DisplayName("Doesn't work")
    void bibleVerseService_insertAllVerses() throws SQLException {

        new MockUp<BibleVerseService>() {
            @Mock
            private void createVerseTable() {
            }

            @Mock
            private int insertAllVerses() {
                return 10;
            }
        };

        int recordsInserted = bibleVerseService.initializeDatabase();
        assertThat(recordsInserted).isEqualTo(10);
    }

}
