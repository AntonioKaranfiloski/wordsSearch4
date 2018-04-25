package com.anton.example.pmpdomasna;

public class Word {
    public String words;

    public Word(){

    }

    public String getWords() {
        return words;
    }

    public void setWords(String words) {
        this.words = words;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String description;

public Word(String words, String description){
    this.words = words;
    this.description = description;
}}
