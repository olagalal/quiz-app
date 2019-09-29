package com.example.olaglal.projectquizapp;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.olaglal.projectquizapp.QuizContract.Entry.*;

public class DbHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "triviaQuiz";

    // table name
    private SQLiteDatabase dbase;

    public DbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        dbase = db;
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_QUEST + " ( "
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + KEY_QUES
                + " TEXT, " + KEY_ANSWER + " TEXT, " + KEY_OPTA + " TEXT, "
                + KEY_OPTB + " TEXT, " + KEY_OPTC + " TEXT)";
        db.execSQL(sql);
        addQuestions();
        //db.close();
    }

    private void addQuestions() {
        Question q1 = new Question("1, 3, 5, 7, 8, 9, 11 Which one doesn't belong to this series? ", "1", "5 ", "8", "8");
        this.addQuestion(q1);
        Question q2 = new Question("Which one of the 3 is least like the other?", "Dog", "Snake", "Mouse", "Sanke");
        this.addQuestion(q2);
        Question q3 = new Question("29, 27, 24, 20, 15 What is next?", "7", "9", "10", "9");
        this.addQuestion(q3);
        Question q4 = new Question("Which one of the five choices makes the best comparison? PEACH is to HCAEP as 46251 is to", "25641", "26451", "15264", "15264");
        this.addQuestion(q4);
        Question q5 = new Question("2, 10, 12, 60, 62, 310, .. What is next?", "312", "360", "1550", "312");
        this.addQuestion(q5);
        Question q6 = new Question("2, 4, 8, 16, 32, 64 .. What is next?", "140", "128", "256", "128");
        this.addQuestion(q6);
        Question q7 = new Question("Mary, who is sixteen years old, is four times as old as her brother. How old will Mary be when she is twice as old as her brother?", "20", "24", "26", "24");
        this.addQuestion(q7);
        Question q8 = new Question("1, 1, 2, 3, 4, 5, 8, 13, 21 .. Which one dosen't belong to this series?", "2", "3", "4", "4");
        this.addQuestion(q8);
        Question q9 = new Question("121, 144, 169, 196 .. What is next?", "225", "260", "298", "225");
        this.addQuestion(q9);
        Question q10 = new Question("5, 10, 19, 32, 49, 70, .. What is next?", "89", "95", "121", "95");
        this.addQuestion(q10);
        Question q11 = new Question("What number best completes the analogy: 8:4 as 10:", "3", "20", "5", "5");
        this.addQuestion(q11);
        Question q12 = new Question("Forest is to tree as tree to ?", "leaf", "branch", "plant", "leaf");
        this.addQuestion(q12);
        Question q13 = new Question("The day after the day after tomorrow is four days before Monday. What day is it today?", "Monday", "Tuesday", "Wednesday", "Monday");
        this.addQuestion(q13);
        Question q14 = new Question("3, 11, 19, 27, .. ", "33", "35", "37", "35");
        this.addQuestion(q14);
        Question q15 = new Question("3, 6, 11, 18, .. ", "25", "26", "27", "27");
        this.addQuestion(q15);
        Question q16 = new Question("516, 497, 478, 459, .. What is next?", "440", "438", "452", "440");
        this.addQuestion(q16);
        Question q17 = new Question("316, 323, 332, 343, , .. What is next?", "356", "357", "358", "356");
        this.addQuestion(q17);
        Question q18 = new Question("662, 645, 624, 599, .. What is next?", "587", "589", "570", "570");
        this.addQuestion(q18);
        Question q19 = new Question("33, ?, 19, 12, 5", "31", "26", "29", "26");
        this.addQuestion(q19);
        Question q20 = new Question("11, 19, ?, 41, 55", "31", "29", "26", "29");
        this.addQuestion(q20);
        Question q21 = new Question("20, 30, 25, 35, ?, 40", "25", "30", "45", "30");
        this.addQuestion(q21);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldV, int newV) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUEST);
        // Create tables again
        onCreate(db);
    }

    // Adding new question
    public void addQuestion(Question quest) {
        //SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_QUES, quest.getQUESTION());
        values.put(KEY_ANSWER, quest.getANSWER());
        values.put(KEY_OPTA, quest.getOPTA());
        values.put(KEY_OPTB, quest.getOPTB());
        values.put(KEY_OPTC, quest.getOPTC());
        // Inserting Row
        dbase.insert(TABLE_QUEST, null, values);
    }

    public List<Question> getAllQuestions() {
        List<Question> quesList = new ArrayList<Question>();
        // Select All Query
        String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
        dbase = this.getReadableDatabase();
        Cursor cursor = dbase.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Question quest = new Question();
                quest.setID(cursor.getInt(0));
                quest.setQUESTION(cursor.getString(1));
                quest.setANSWER(cursor.getString(2));
                quest.setOPTA(cursor.getString(3));
                quest.setOPTB(cursor.getString(4));
                quest.setOPTC(cursor.getString(5));
                quesList.add(quest);
            } while (cursor.moveToNext());
        }
        // return quest list
        return quesList;
    }

	/*
    public int rowcount()
	{
		int row=0;
		String selectQuery = "SELECT  * FROM " + TABLE_QUEST;
		SQLiteDatabase db = this.getWritableDatabase();
		Cursor cursor = db.rawQuery(selectQuery, null);
		row=cursor.getCount();
		return row;
	}*/
}
