package com.app.model;

public class Word { //model

    private int x;
    private String word;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public String getWord() {
        return word;
    }

    @Override
    public String toString() {
        return word + " " + x +"\n";
    }

    public void setWord(String word) {
        this.word = word;
    }

    public Word() {
    }

    public Word(int x, String word) {
        this.x = x;
        this.word = word;
    }
}
