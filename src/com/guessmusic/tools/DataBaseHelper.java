package com.guessmusic.tools;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by lance on 17-6-1.
 */

public class DataBaseHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "user.db";
    private static final int DB_VERSION = 1;
    private Context mContext;
    private static final String CREATE_USER = "create table user ("
            + "id integer primary key autoincrement, "
            + "username text, "
            + "password text, "
            + "level integer, "
            + "gold integer)";

    public DataBaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mContext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
