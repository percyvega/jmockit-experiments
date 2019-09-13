package com.percyvega.util;

import com.percyvega.model.BibleVerse;

public abstract class BibleVerseUtil {

    public static final String VERSE_WITH_REFERENCE_SEPARATOR = " - ";

    private static String chapterVerseSeparator;

    private static String[] bookNames;

    static {
        setChapterVerseSeparator(":");
        initializeBookNames();
    }

    private BibleVerseUtil() {
    }

    public static void initializeBookNames() {
        bookNames = new String[]{
                "Genesis", "Exodus", "Leviticus", "Numbers",
                "Deuteronomy", "Joshua", "Judges", "Ruth",
                "1 Samuel", "2 Samuel", "1 Kings", "2 Kings",
                "1 Chronicles", "2 Chronicles", "Ezra", "Nehemiah",
                "Esther", "Job", "Psalm", "Proverbs",
                "Ecclesiastes", "Song of Solomon", "Isaiah", "Jeremiah",
                "Lamentations", "Ezekiel", "Daniel", "Hosea",
                "Joel", "Amos", "Obadiah", "Jonah",
                "Micah", "Nahum", "Habakkuk", "Zephaniah",
                "Haggai", "Zechariah", "Malachi", "Matthew",
                "Mark", "Luke", "John", "Acts",
                "Romans", "1 Corinthians", "2 Corinthians", "Galatians",
                "Ephesians", "Philippians", "Colossians", "1 Thessalonians",
                "2 Thessalonians", "1 Timothy", "2 Timothy", "Titus",
                "Philemon", "Hebrews", "James", "1 Peter",
                "2 Peter", "1 John", "2 John", "3 John",
                "Jude", "Revelation"};
    }

    public static void setChapterVerseSeparator(String separator) {
        chapterVerseSeparator = separator;
    }

    public static String getChapterVerseSeparator() {
        return chapterVerseSeparator;
    }

    public static String getPrettyPrintReference(BibleVerse bibleVerse) {
        return bookNames[bibleVerse.getBook()] + " " +
                bibleVerse.getChapter() + getChapterVerseSeparator() + bibleVerse.getVerse() +
                " (" + bibleVerse.getTranslation() + ")";
    }

    public static BibleVerse getDefaultVerse() {
        return new BibleVerse();
    }

    public static String verseWithReferencePrettyPrint(BibleVerse bibleVerse) {
        return bibleVerse.getText() + VERSE_WITH_REFERENCE_SEPARATOR + getPrettyPrintReference(bibleVerse);
    }
}
