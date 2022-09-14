package com.example.alquran_basic;

public class AyahInfo {
    int ayahID;
    String ayahText;

    public AyahInfo(int ayahID, String ayahText) {
        this.ayahID = ayahID;
        this.ayahText = ayahText;
    }

    @Override
    public String toString() {
        return "AyahInfo{" +
                "ayahID=" + ayahID +
                ", ayahText='" + ayahText + '\'' +
                '}';
    }

    public int getAyahID() {
        return ayahID;
    }

    public void setAyahID(int ayahID) {
        this.ayahID = ayahID;
    }

    public String getAyahText() {
        return ayahText;
    }

    public void setAyahText(String ayahText) {
        this.ayahText = ayahText;
    }
}
