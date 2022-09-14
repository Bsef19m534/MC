package com.example.alquran_basic;

public class SurahInfo {
    int surahID;
    String surahNameUr;
    String surahNameEng;
    String surahNazool;

    public int getSurahID() {
        return surahID;
    }

    public void setSurahID(int surahID) {
        this.surahID = surahID;
    }

    public String getSurahNameUr() {
        return surahNameUr;
    }

    public void setSurahNameUr(String surahNameUr) {
        this.surahNameUr = surahNameUr;
    }

    public String getSurahNameEng() {
        return surahNameEng;
    }

    public void setSurahNameEng(String surahNameEng) {
        this.surahNameEng = surahNameEng;
    }

    public String getSurahNazool() {
        return surahNazool;
    }

    public void setSurahNazool(String surahNazool) {
        this.surahNazool = surahNazool;
    }

    public SurahInfo(int surahID, String surahNameUr, String surahNameEng, String surahNazool) {
        this.surahID = surahID;
        this.surahNameUr = surahNameUr;
        this.surahNameEng = surahNameEng;
        this.surahNazool = surahNazool;
    }

}
