package com.example.android_project.mapper;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.android_project.pojo.User;
@SuppressLint("Recycle")
public class UserDBHelper extends SQLiteOpenHelper {

    public static UserDBHelper userDBHelper = null;
    private SQLiteDatabase db = null;
    public static final String DB_NAME = "car.db";
    public static final String TABLE_NAME = "user";
    public static int DB_VERSION = 1;

    public UserDBHelper(@Nullable Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public UserDBHelper(@Nullable Context context, int version) {
        super(context, DB_NAME, null, version);
    }

    public static UserDBHelper getInstance(Context context, int version) {
        if (userDBHelper == null && version > 0) {
            userDBHelper = new UserDBHelper(context, version);
        } else if (userDBHelper == null) {
            userDBHelper = new UserDBHelper(context);
        }
        return userDBHelper;
    }

    public void openWriteLink() {
        if (db == null || !db.isOpen()) {
            db = userDBHelper.getWritableDatabase();
        }
    }

    public void closeLink() {
        if (db != null && db.isOpen()) {
            db.close();
            db = null;
        }
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String create_sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME + "("
                + "id INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "username VARCHAR(20) NOT NULL,"
                + "pwd VARCHAR(20) NOT NULL"
                + ");";
        db.execSQL(create_sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {}

    public boolean insert(User user) {
        if (selectByUsername(user.getUsername()) == -1) {
            ContentValues cv = putData(user);
            db.insert(TABLE_NAME, null, cv);
            return true;
        }
        return false;
    }

    public int update(User user, String condition, String[] args) {
        ContentValues cv = putData(user);
        return db.update(TABLE_NAME, cv, condition, args);
    }

    public int selectByUsername(String username) {
        Cursor query = db.query(TABLE_NAME, new String[]{"id"}, "username = ?", new String[]{username}, null, null, null);
        if (query != null) {
            query.moveToFirst();
            if (query.getCount() != 0)
                return query.getInt(0);
        }
        return -1;
    }

    public boolean select(User user) {
        Cursor query = db.query(TABLE_NAME, new String[]{"pwd"}, "username = ?", new String[]{user.getUsername()}, null, null, null);
        if (query != null) {
            query.moveToFirst();
            return query.getCount()!= 0 && user.getPwd().equals(query.getString(0));
        }
        return false;
    }

    public ContentValues putData(User user) {
        ContentValues cv = new ContentValues();
        cv.put("username", user.getUsername());
        cv.put("pwd", user.getPwd());
        return cv;
    }
}