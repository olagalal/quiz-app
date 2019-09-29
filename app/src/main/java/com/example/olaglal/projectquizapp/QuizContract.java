package com.example.olaglal.projectquizapp;

import android.provider.BaseColumns;

public class QuizContract {

    public static class Entry implements BaseColumns {
        public static final String TABLE_QUEST = "quest";
        // tasks Table Columns names
        public static final String KEY_ID = "id";
        public static final String KEY_QUES = "question";
        public static final String KEY_ANSWER = "answer"; //correct option
        public static final String KEY_OPTA= "optA"; //option a
        public static final String KEY_OPTB= "optB"; //option b
        public static final String KEY_OPTC= "optC"; //option c
    }
}
