package com.guessmusic.model;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.guessmusic.tools.DataBaseHelper;

/**
 * Created by castor on 2017/6/2.
 */

public class UserService {
    private static final String LOG_TAG = "lancelot";
    private DataBaseHelper mDataBaseHelper;

    public UserService(Context context) {
        mDataBaseHelper = new DataBaseHelper(context);
    }

    //登录用
    public boolean login(String username,String password){
        SQLiteDatabase sdb=mDataBaseHelper.getReadableDatabase();
        String sql="select * from user where username=? and password=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username,password});
        if(cursor.moveToFirst()==true){
            cursor.close();
            return true;
        }
        return false;
    }
    //注册用
    public boolean register(User user){
        SQLiteDatabase sdb=mDataBaseHelper.getReadableDatabase();
        String sql="insert into user(username,password,level,gold) values(?,?,?,?)";
        Object obj[]={user.getUsername(),user.getPassword(),user.getLevel(),user.getGold()};
        sdb.execSQL(sql, obj);
        return true;
    }

    public int getLevel(String username) {
        SQLiteDatabase sdb=mDataBaseHelper.getReadableDatabase();
        String sql="select level from user where username=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username});
        int level = 0;
        if (cursor.moveToFirst()) {
            level =  cursor.getInt(cursor.getColumnIndex("level"));
        }
        return level;
    }

    public int getGold(String username) {
        SQLiteDatabase sdb=mDataBaseHelper.getReadableDatabase();
        String sql="select gold from user where username=?";
        Cursor cursor=sdb.rawQuery(sql, new String[]{username});
        int gold = 0;
        if (cursor.moveToFirst()) {
            gold =  cursor.getInt(cursor.getColumnIndex("gold"));
        }
        return gold;
    }

    public void saveData(String username, int mCurrentIndex, int mCurrentCoins) {
        Log.i(LOG_TAG,"saveData username:" + username + " level:" + mCurrentIndex + " gold:" + mCurrentCoins);
        SQLiteDatabase sdb=mDataBaseHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        values.put("level",mCurrentIndex);
        values.put("gold",mCurrentCoins);
        sdb.update("user", values , "username = ?", new String[] {username});
    }

    public void setGold(String username, int gold) {
        Log.i(LOG_TAG, "setGold username:" + username + " gold:" + gold);
        SQLiteDatabase sdb = mDataBaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("gold",gold);
        sdb.update("user", values , "username = ?", new String[] {username});
    }
}
