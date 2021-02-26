package com.company;

public class WordCount implements WordFrequency {
    private String word;
    private int frequency;

    public WordCount(String word, int frequency) {
        this.word = word;
        this.frequency = frequency;
    }


    public WordCount() {
    }

    public void setWord(String word) {
        this.word = word;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    @Override
    public String getWord() {
        return word;
    }


    @Override
    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "WordCount{" +
                "word='" + word + '\'' +
                ", n=" + frequency +
                '}';
    }

}
