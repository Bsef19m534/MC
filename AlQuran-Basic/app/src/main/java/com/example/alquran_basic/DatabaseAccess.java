package com.example.alquran_basic;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.HashMap;

public class DatabaseAccess {
    private final SQLiteOpenHelper openHelper;
    private SQLiteDatabase db;
    private static DatabaseAccess instance;
    Cursor c = null;

    //private constructor
    private DatabaseAccess(Context context){
        this.openHelper = new DatabaseOpenHelper(context);
    }

    //return single instance
    public static DatabaseAccess getInstance(Context context){
        if(instance==null){
            instance = new DatabaseAccess(context);
        }
        return instance;
    }

    //open the database
    public void open(){
        this.db = openHelper.getReadableDatabase();
    }

    //close the database
    public void close(){
        if(db!=null){
            this.db.close();
        }
    }

    //return surah info
    public ArrayList<SurahInfo> getSurahInfo(){
        Cursor cursorCourses = db.rawQuery("SELECT SurahID, SurahNameU, SurahNameE, Nazool FROM tsurah",null);
        ArrayList<SurahInfo> surahArrayList = new ArrayList<>();

        if(cursorCourses.moveToFirst()){
            do {
                surahArrayList.add(new SurahInfo(Integer.parseInt(cursorCourses.getString(0)),
                        cursorCourses.getString(1),cursorCourses.getString(2),cursorCourses.getString(3)));
            }while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return surahArrayList;
    }

    public ArrayList<ParaInfo> getParaInfo() {
        Cursor cursorCourses = db.rawQuery("SELECT paraID, paraNameU, paraNameE FROM tpara",null);
        ArrayList<ParaInfo> paraArrayList = new ArrayList<>();

        if(cursorCourses.moveToFirst()){
            do {
                paraArrayList.add(new ParaInfo(Integer.parseInt(cursorCourses.getString(0)),
                        cursorCourses.getString(1),cursorCourses.getString(2)));
            }while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return paraArrayList;
    }

    public ArrayList<AyahInfo> getAyahInfoBySurah(int surahNum) {
        Cursor cursorCourses = db.rawQuery("SELECT AyaNo, ArabicText FROM tayah WHERE SuraID = " + surahNum,null);
        ArrayList<AyahInfo> ayahArrayList = new ArrayList<>();

        if(surahNum!=1) {
            ayahArrayList.add(new AyahInfo(0, "بِسۡمِ اللّٰہِ الرَّحۡمٰنِ الرَّحِیۡمِ"));
        }
        if(cursorCourses.moveToFirst()){
            do {
                ayahArrayList.add(new AyahInfo(Integer.parseInt(cursorCourses.getString(0)),
                        cursorCourses.getString(1)));
            }while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return ayahArrayList;
    }

    public ArrayList<AyahInfo> getAyahInfoByPara(int paraNum) {
        Cursor cursorCourses = db.rawQuery("SELECT AyaNo, ArabicText FROM tayah WHERE ParaID = " + paraNum,null);
        ArrayList<AyahInfo> ayahArrayList = new ArrayList<>();

        if(cursorCourses.moveToFirst()){
            do {
                int ayahNo = Integer.parseInt(cursorCourses.getString(0));
                String ayahText = cursorCourses.getString(1);
                if(ayahNo==1){
                    ayahArrayList.add(new AyahInfo(0, "بِسۡمِ اللّٰہِ الرَّحۡمٰنِ الرَّحِیۡمِ"));
                }
                ayahArrayList.add(new AyahInfo(ayahNo,ayahText));
            }while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return ayahArrayList;
    }

    public ArrayList<TranslationInfo> getTranslation(String ayah){
        Cursor cursorCourses = db.rawQuery("SELECT FatehMuhammadJalandhri, MehmoodulHassan, DrMohsinKhan, MuftiTaqiUsmani from tayah where ArabicText = \"" + ayah +"\"", null);
        ArrayList<TranslationInfo> translation = new ArrayList<>();

        if(cursorCourses.moveToFirst()){
            do {
                translation.add(new TranslationInfo("FatehMuhammadJalandhri",cursorCourses.getString(0)));
                translation.add(new TranslationInfo("MehmoodulHassan",cursorCourses.getString(1)));
                translation.add(new TranslationInfo("DrMohsinKhan",cursorCourses.getString(2)));
                translation.add(new TranslationInfo("MuftiTaqiUsmani",cursorCourses.getString(3)));
            }while (cursorCourses.moveToNext());
        }
        cursorCourses.close();
        return translation;
    }
}
