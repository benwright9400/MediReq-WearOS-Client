package com.wrightapplications.medireq_client.communication_modules;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.wrightapplications.medireq_client.Values;

public class Database {
    SQLiteDatabase sqLiteDatabase;

    public Database() {
        sqLiteDatabase = Values.getSqLiteDatabase();
    }

    public void addEncryptionKey(String key) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS EncryptionKey (keyValue VARCHAR, id INTEGER PRIMARY KEY)");
        sqLiteDatabase.execSQL("INSERT INTO EncryptionKey (keyValue) VALUES ('" + key + "')");
    }

    public String getEncryptionKey() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS EncryptionKey (keyValue VARCHAR, id INTEGER PRIMARY KEY)");
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT 1 FROM EncryptionKey ORDER BY id ASC", null);
        int keyIndex = cursor.getColumnIndex("keyValue");

        String key = "";

        while (!cursor.isAfterLast()) {
            key = cursor.getString(keyIndex);
        }

        return key;
    }

    public void addRequest(String id) {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MediReq (reqId VARCHAR, id INTEGER PRIMARY KEY)");
        sqLiteDatabase.execSQL("INSERT INTO MediReq (reqId) VALUES ('" + id + "')");
    }

    public String getRequest() {
        sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS MediReq (reqId VARCHAR, id INTEGER PRIMARY KEY)");
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM MediReq ORDER BY id ASC", null);
        int keyIndex = cursor.getColumnIndex("reqId");

        String key = "";

        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            key = cursor.getString(keyIndex);
            cursor.moveToNext();
        }

        System.out.println("key: " + key);
        return key;
    }

}
