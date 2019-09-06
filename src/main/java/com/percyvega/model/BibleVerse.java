package com.percyvega.model;

public class BibleVerse {

    public enum Translation {
        KJV, // for Old Testament Bible verses
        ESV, // for New Testament Bible verses
        UNUSED
    }

    private int book;
    private int chapter;
    private int verse;
    private String text;

    public BibleVerse() {
        this(42, 3, 16, "For God so loved the world, that he gave his only Son, that whoever believes in him should not perish but have eternal life.");
    }

    public BibleVerse(int book, int chapter, int verse, String text) {
        this.book = book;
        this.chapter = chapter;
        this.verse = verse;
        this.text = text;
    }

    public int getBook() {
        return book;
    }

    public void setBook(int book) {
        this.book = book;
    }

    public int getChapter() {
        return chapter;
    }

    public void setChapter(int chapter) {
        this.chapter = chapter;
    }

    public int getVerse() {
        return verse;
    }

    public void setVerse(int verse) {
        this.verse = verse;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Translation getTranslation() {
        if (book < 39) {
            return Translation.KJV;
        } else if (book < 66) {
            return Translation.ESV;
        } else {
            throw new IllegalArgumentException("Book numbers should be between 0 and 65, but is: " + book);
        }
    }

}
