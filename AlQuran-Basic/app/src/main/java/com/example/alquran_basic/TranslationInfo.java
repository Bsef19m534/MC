package com.example.alquran_basic;

public class TranslationInfo {
    String translator;
    String translation;

    public TranslationInfo(String translator, String translation) {
        this.translator = translator;
        this.translation = translation;
    }

    public String getTranslation() {
        return translation;
    }

    public void setTranslation(String translation) {
        this.translation = translation;
    }

    public String getTranslator() {
        return translator;
    }

    public void setTranslator(String translator) {
        this.translator = translator;
    }
}
