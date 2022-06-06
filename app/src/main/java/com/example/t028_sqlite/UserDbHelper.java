package com.example.t028_sqlite;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class UserDbHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "userDb" ;
    public static final int DATABASE_VERSION = 1 ;
    public static final String QUERY =
            "CREATE TABLE " + UserContract.NewUserInfo.TABLE_NAME + "(" +
                              UserContract.NewUserInfo.USER_NAME + " TEXT, " +
                              UserContract.NewUserInfo.USER_MOBILE + " TEXT, " +
                              UserContract.NewUserInfo.USER_EMAIL + " TEXT);" ;

    public UserDbHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
        Log.e("DATABASE","DATABASE CREATED OR OPENED");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(QUERY);
        Log.e("DATABASE","TABLE CREATED");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void addInformation(String name, String mobile, String email, SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(UserContract.NewUserInfo.USER_NAME, name);
        contentValues.put(UserContract.NewUserInfo.USER_MOBILE, mobile);
        contentValues.put(UserContract.NewUserInfo.USER_EMAIL, email);
        sqLiteDatabase.insert(UserContract.NewUserInfo.TABLE_NAME, null, contentValues);
        Log.e("DATABASE", "DATA INSERTED");
    }
}
