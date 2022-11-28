package com.wrightapplications.medireq_client;

import android.database.sqlite.SQLiteDatabase;

public class Values {
    public static SQLiteDatabase sqLiteDatabase;

    public static SQLiteDatabase getSqLiteDatabase() {
        return sqLiteDatabase;
    }

    public static void setSqLiteDatabase(SQLiteDatabase sqLiteDatabase) {
        Values.sqLiteDatabase = sqLiteDatabase;
    }
}
