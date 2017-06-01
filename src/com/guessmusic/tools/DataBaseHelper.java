package com.guessmusic.tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lance on 17-6-1.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    static String name="user.db";
    static int dbVersion=1;

    public DataBaseHelper(Context context) {
        super(context, name, null, dbVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String sql="create table user(id integer primary key autoincrement,username varchar(20),password varchar(20), integer,sex varchar(2))";
        sqLiteDatabase.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
