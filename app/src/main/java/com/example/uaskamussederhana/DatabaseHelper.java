package com.example.uaskamussederhana;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "translation.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_NAME = "translation";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_WORD_INDO = "wordIndo";
    private static final String COLUMN_WORD_ENG = "wordEng";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                COLUMN_WORD_INDO + " TEXT, " +
                COLUMN_WORD_ENG + " TEXT)";
        db.execSQL(createTable);

        // Insert initial data
        insertData(db, "selamat", "hello");
        insertData(db, "terima kasih", "thank you");
        insertData(db, "selamat pagi", "good morning");
        insertData(db, "selamat malam", "good night");
        insertData(db, "tolong", "please");
        insertData(db, "maaf", "sorry");
        insertData(db, "ya", "yes");
        insertData(db, "tidak", "no");
        insertData(db, "baik", "good");
        insertData(db, "buruk", "bad");
        insertData(db, "besar", "big");
        insertData(db, "kecil", "small");
        insertData(db, "cepat", "fast");
        insertData(db, "lambat", "slow");
        insertData(db, "panas", "hot");
        insertData(db, "dingin", "cold");
        insertData(db, "baru", "new");
        insertData(db, "lama", "old");
        insertData(db, "mudah", "easy");
        insertData(db, "sulit", "difficult");
        insertData(db, "murah", "cheap");
        insertData(db, "mahal", "expensive");
        insertData(db, "bahagia", "happy");
        insertData(db, "sedih", "sad");
        insertData(db, "lelah", "tired");
        insertData(db, "kuat", "strong");
        insertData(db, "lemah", "weak");
        insertData(db, "dekat", "near");
        insertData(db, "jauh", "far");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    private void insertData(SQLiteDatabase db, String wordIndo, String wordEng) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_WORD_INDO, wordIndo);
        contentValues.put(COLUMN_WORD_ENG, wordEng);
        db.insert(TABLE_NAME, null, contentValues);
    }

    public String getTranslationIndoToEng(String wordIndo) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_WORD_ENG},
                COLUMN_WORD_INDO + "=?", new String[]{wordIndo},
                null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            String result = cursor.getString(cursor.getColumnIndex(COLUMN_WORD_ENG));
            cursor.close();
            return result;
        }
        return null;
    }

    public String getTranslationEngToIndo(String wordEng) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(TABLE_NAME, new String[]{COLUMN_WORD_INDO},
                COLUMN_WORD_ENG + "=?", new String[]{wordEng},
                null, null, null);
        if (cursor != null && cursor.moveToFirst()) {
            String result = cursor.getString(cursor.getColumnIndex(COLUMN_WORD_INDO));
            cursor.close();
            return result;
        }
        return null;
    }
}

