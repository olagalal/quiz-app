package com.example.olaglal.projectquizapp;

public class Question {
    private int ID;
    private String QUESTION;
    private String OPTA;
    private String OPTB;
    private String OPTC;
    private String ANSWER;

    public Question() {
        ID = 0;
        QUESTION = "";
        OPTA = "";
        OPTB = "";
        OPTC = "";
        ANSWER = "";
    }

    public Question(String q, String a, String b, String c,
                    String an) {

        QUESTION = q;
        OPTA = a;
        OPTB = b;
        OPTC = c;
        ANSWER = an;
    }

    public int getID() {
        return ID;
    }

    public String getQUESTION() {
        return QUESTION;
    }

    public String getOPTA() {
        return OPTA;
    }

    public String getOPTB() {
        return OPTB;
    }

    public String getOPTC() {
        return OPTC;
    }

    public String getANSWER() {
        return ANSWER;
    }

    public void setID(int id) {
        ID = id;
    }

    public void setQUESTION(String q) {
        QUESTION = q;
    }

    public void setOPTA(String a) {
        OPTA = a;
    }

    public void setOPTB(String b) {
        OPTB = b;
    }

    public void setOPTC(String c) {
        OPTC = c;
    }

    public void setANSWER(String an) {
        ANSWER = an;
    }

}
