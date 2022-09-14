package com.example.alquran_basic;

public class ParaInfo {
    int paraID;
    String paraNameU;
    String getParaNameE;

    public ParaInfo(int paraID, String paraNameU, String getParaNameE) {
        this.paraID = paraID;
        this.paraNameU = paraNameU;
        this.getParaNameE = getParaNameE;
    }

    @Override
    public String toString() {
        return "ParaInfo{" +
                "paraID=" + paraID +
                ", paraNameU='" + paraNameU + '\'' +
                ", getParaNameE='" + getParaNameE + '\'' +
                '}';
    }

    public int getParaID() {
        return paraID;
    }

    public void setParaID(int paraID) {
        this.paraID = paraID;
    }

    public String getParaNameU() {
        return paraNameU;
    }

    public void setParaNameU(String paraNameU) {
        this.paraNameU = paraNameU;
    }

    public String getParaNameE() {
        return getParaNameE;
    }

    public void setGetParaNameE(String getParaNameE) {
        this.getParaNameE = getParaNameE;
    }
}
